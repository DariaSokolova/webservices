package com.epam.mentoring.webservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.epam.mentoring.webservices.bean.Theatre;
import com.epam.mentoring.webservices.dao.TheatreDAO;

@Controller
@RequestMapping("/theatres")
public class TheatreController {
	
	@Autowired
	protected TheatreDAO theatreDAO;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getTheatresList(Model model) {
		List<Theatre> theatres = theatreDAO.getAll();
		model.addAttribute("beans", theatres);
		return "theatre/list";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{theatreID}")
	public String view(Model model, @PathVariable long theatreID) {
		Theatre theatre = theatreDAO.get(theatreID);
		model.addAttribute("bean", theatre);
		return "theatre/view";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String save(Model model, @RequestBody Theatre theatre) {
		theatreDAO.save(theatre);
		model.addAttribute("bean", theatre);
		return "theatre/view";
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{theatreID}")
	public String delete(@PathVariable long theatreID) {
		theatreDAO.delete(theatreID);
		return "home";
	}
}
