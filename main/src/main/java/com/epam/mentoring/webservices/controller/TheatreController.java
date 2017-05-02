package com.epam.mentoring.webservices.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/theatre")
public class TheatreController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String start(Model model) {
		return "theatres";
	}
}
