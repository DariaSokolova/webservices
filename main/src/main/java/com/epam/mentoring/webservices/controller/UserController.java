package com.epam.mentoring.webservices.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.util.List;

import javax.servlet.http.Part;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.epam.mentoring.webservices.bean.User;
import com.epam.mentoring.webservices.constant.ApplicationConstant;
import com.epam.mentoring.webservices.dao.UserDAO;
import com.epam.mentoring.webservices.exception.FileUploadException;
import com.epam.mentoring.webservices.validator.UserControllerValidator;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	protected UserDAO userDAO;
	@Autowired
	protected UserControllerValidator userControllerValidator;

	private static final String PAGE_EDIT = "user/edit";
	private static final String PAGE_LIST = "user/list";
	private static final String PAGE_VIEW = "user/view";

	@RequestMapping(method = RequestMethod.GET)
	public String getList(Model model) {
		List<User> users = userDAO.getAll();
		model.addAttribute("beans", users);
		return PAGE_LIST;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/new")
	public String addNew(Model model) {
		model.addAttribute("user", new User());
		return PAGE_EDIT;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/edit/{userID}")
	public String edit(Model model, @PathVariable long userID) {
		model.addAttribute("user", userDAO.get(userID));
		return PAGE_EDIT;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{userID}")
	public String view(Model model, @PathVariable long userID) {
		User user = userDAO.get(userID);
		model.addAttribute("bean", user);
		return PAGE_VIEW;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String save(@ModelAttribute("user") User user,
			BindingResult result, Model model,
			@RequestParam(value = "file", required = false) Part file) {
		userControllerValidator.validate(user, result);
		if (!result.hasErrors()) {
			processUploadFile(user, file);
			userDAO.save(user);
			model.addAttribute("bean", user);
			return PAGE_VIEW;
		} else
			return PAGE_EDIT;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/delete/{userID}")
	public String delete(@PathVariable long userID) {
		userDAO.delete(userID);
		return ApplicationConstant.PAGE_HOME;
	}
	
	@RequestMapping(value = "/photo/{userID}", method = RequestMethod.GET)
	@ResponseBody
	public byte[] downloadPhoto(@PathVariable("userID") long userID) {
		return userDAO.getPhoto(userID);
	}
	
	private void processUploadFile(User user, Part file) {
		if (file != null) {
			Blob fileContent = null;
			try {
				InputStream inputStream = file.getInputStream();
				fileContent = Hibernate.createBlob(inputStream);
				user.setPhoto(fileContent);
			} catch (IOException e) {
				throw new FileUploadException(e);
			}
		}
	}
}
