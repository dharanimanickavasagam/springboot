package com.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.service.SiteUserService;

//Restricts access to admin access 
@Controller
public class AuthController {

	@Autowired
	private SiteUserService siteUserService;

	@RequestMapping(value = "/login")
	public ModelAndView login(ModelAndView mv) {
		return mv;
	}

	// Always write a GET for every page
	// since it exposes the available methods anytime

}
