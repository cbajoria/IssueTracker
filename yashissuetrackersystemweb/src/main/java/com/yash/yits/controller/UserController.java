package com.yash.yits.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

	@RequestMapping(value="/welcomeView")
	public String userWelcome(){
		return "Welcome";
	}
	
	@RequestMapping(value="/userWelcome")
	public String userDashboard(){
		return "User";
	}
}
