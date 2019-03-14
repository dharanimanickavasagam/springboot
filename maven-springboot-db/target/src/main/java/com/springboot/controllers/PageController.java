package com.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.model.StatusUpdate;
import com.springboot.service.StatusUpdateService;

@Controller
// It tells spring to create an object from this class - i.e bean
// springs wires this object to rest of the application
//
public class PageController {

	@Autowired
	private StatusUpdateService statusUpdateService;

	// @ResponseBody
	// returns value is sent to the browser
	@RequestMapping("/")
	public ModelAndView getHome(ModelAndView mv) {
		mv.setViewName("home");
		StatusUpdate statusUpdate = statusUpdateService.getlatest();
		mv.getModel().put("statusUpdate", statusUpdate);
		return mv;
	}

	@RequestMapping("/about")
	public String about() {
		return "about";
	}

	@RequestMapping("/register")
	public String register() {
		return "register";
	}

}
