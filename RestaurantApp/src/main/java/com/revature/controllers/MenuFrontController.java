package com.revature.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.revature.beans.Manager;
import com.revature.exception.NoAuthorizedUserException;

@Controller
@RequestMapping(value="/ManagerDashboard")
public class MenuFrontController {
	
	@RequestMapping
	public String viewManagerDashboard(ModelMap modelMap, HttpSession session) throws NoAuthorizedUserException{
		
		Manager manager = (Manager) session.getAttribute("user");
		
		if(manager == null){
			throw new NoAuthorizedUserException("Manager Not Defined");
		}

		return "forward:/pages/menuData/main.html";
	}
}
