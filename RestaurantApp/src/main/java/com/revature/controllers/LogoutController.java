package com.revature.controllers;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/logout")
public class LogoutController {
	@RequestMapping(method=RequestMethod.POST)
	public String logout(HttpRequest request){
		request.getSession().invalidate();
		return "redirect:/login";
	}
}
