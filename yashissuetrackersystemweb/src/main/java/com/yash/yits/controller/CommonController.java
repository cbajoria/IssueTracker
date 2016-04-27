package com.yash.yits.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {

	@RequestMapping(value="welcome")
	public String welcomePage(){
		return "welcome";
	}
}