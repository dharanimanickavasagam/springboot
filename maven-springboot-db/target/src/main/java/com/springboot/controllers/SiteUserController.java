package com.springboot.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.model.SiteUser;
import com.springboot.service.SiteUserService;

@Controller
public class SiteUserController {

	@Autowired
	private SiteUserService siteUserService;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register(ModelAndView mv) {

		SiteUser siteUser = new SiteUser();
		mv.setViewName("register");
		mv.getModel().put("siteUser", siteUser);

		return mv;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView register(ModelAndView mv, @Valid SiteUser siteUser,
			BindingResult result) {

		mv.setViewName("register");
		if (!result.hasErrors()) {
			siteUserService.saveSiteUser(siteUser);
			mv.setViewName("redirect:/");
		}

		return mv;
	}

}
