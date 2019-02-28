package com.springboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
// It tells spring to create an obj from this class- i.ebean
// springs wires this object to rest of the application
public class PageController {

	// @ResponseBody
	// returns value is sent to the browser
	@RequestMapping("/")
	public String home() {
		return "home";
	}

	@RequestMapping("/about")
	public String about() {
		return "about";
	}

	@RequestMapping("/addstatus")
	public String status() {
		return "addStatus";
	}

}
