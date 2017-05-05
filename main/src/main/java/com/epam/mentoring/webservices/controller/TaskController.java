package com.epam.mentoring.webservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.epam.mentoring.webservices.bean.Task;
import com.epam.mentoring.webservices.bean.User;
import com.epam.mentoring.webservices.constant.ApplicationConstant;
import com.epam.mentoring.webservices.dao.TaskDAO;
import com.epam.mentoring.webservices.dao.UserDAO;
import com.epam.mentoring.webservices.exception.ServiceException;
import com.epam.mentoring.webservices.validator.TaskControllerValidator;

@Controller
@RequestMapping("/tasks")
public class TaskController {

	@Autowired
	protected TaskDAO taskDAO;
	@Autowired
	protected UserDAO userDAO;
	@Autowired
	protected TaskControllerValidator taskControllerValidator;

	private static final String PAGE_EDIT = "task/edit";
	private static final String PAGE_LIST = "task/list";
	private static final String PAGE_VIEW = "task/view";

	@RequestMapping(method = RequestMethod.GET)
	public String getList(Model model) {
		List<Task> tasks = taskDAO.getAll();
		model.addAttribute("beans", tasks);
		return PAGE_LIST;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/new")
	public String addNew(Model model) {
		model.addAttribute("task", new Task());
		loadData(model);
		return PAGE_EDIT;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/edit/{taskID}")
	public String edit(Model model, @PathVariable long taskID) {
		model.addAttribute("task", taskDAO.get(taskID));
		loadData(model);
		return PAGE_EDIT;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{taskID}")
	public String view(Model model, @PathVariable long taskID) {
		Task task = taskDAO.get(taskID);
		model.addAttribute("bean", task);
		return PAGE_VIEW;
	}

	@RequestMapping(method = RequestMethod.POST)
	@ExceptionHandler({ ServiceException.class })
	public String save(@ModelAttribute("task") Task task, BindingResult result,
			Model model) {
		taskControllerValidator.validate(task, result);
		if (!result.hasErrors()) {
			task.setUser(userDAO.get(task.getUser().getID()));
			taskDAO.save(task);
			model.addAttribute("bean", task);
			return PAGE_VIEW;
		} else {
			loadData(model);
			return PAGE_EDIT;
		}
	}

	@RequestMapping(method = RequestMethod.POST, value = "/delete/{taskID}")
	public String delete(@PathVariable long taskID) {
		taskDAO.delete(taskID);
		return ApplicationConstant.PAGE_HOME;
	}

	private void loadData(Model model) {
		List<User> users = userDAO.getAll();
		model.addAttribute("users", users);
	}
}
