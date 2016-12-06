package com.revature.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class HomeController {
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String getHomepage(){
		return "";	
	}
}