package com.revature.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/ManagerDashboard")
public class MenuFrontController {
	
	@RequestMapping
	public String viewManagerDashboard(ModelMap modelMap){
		String url = null;
		
		return "forward:/menuData/main.html";
	}
}
