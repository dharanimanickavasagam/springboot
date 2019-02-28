package com.springboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//Restricts access to admin access 
@Controller
public class AuthController {

	@RequestMapping("/admin")
	public String admin() {
		return "admin";
	}

}
