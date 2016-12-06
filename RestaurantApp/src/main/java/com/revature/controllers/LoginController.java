package com.revature.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.revature.beans.Customer;
import com.revature.beans.User;
import com.revature.service.UserService;

@Controller
@RequestMapping(value="/login")
public class LoginController {
	@Autowired
	private UserService userService;
	
	//Create a new user
	@RequestMapping(method=RequestMethod.GET)
	public String getLoginPage(ModelMap modelMap){
		User emptyUser = new Customer();
		
		modelMap.addAttribute("user",emptyUser);
		return "login";
	}
	
	//Log in an existing user
	@RequestMapping(method=RequestMethod.POST)
	public String doLogin(@Valid User user, BindingResult bindingResult, ModelMap modelMap){
		if(bindingResult.hasErrors()){
			return "login";
		}
		
		User authUser = userService.auth(user);
		
		if(authUser != null){
			return "redirect:home";
		} else {
			modelMap.addAttribute("errorMessage","Username/Password incorrect");
			return "login";
		}
	}
}
