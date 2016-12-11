package com.revature.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.revature.beans.Customer;
import com.revature.beans.Manager;
import com.revature.beans.User;
import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImp;

@Controller
@RequestMapping(value = "/login")
public class LoginController {
	@RequestMapping(method=RequestMethod.POST)
	public String doLogin(HttpServletRequest request, @RequestBody Object obj){
		String direct = "login.html";
		UserDAO userDAO = new UserDAOImp();
		Manager manager = null;
		Customer customer = null;
		
		User user = userDAO.checkLogin(request.getParameter("username"), request.getParameter("password"));
		if (user != null) {
			manager = userDAO.getManagerByID(user.getUserId());
			if (manager != null){
				// user is a manager
				request.getSession().setAttribute("user", manager);
				direct = "manager";
			}
			else{
				// user is a customer
				customer = userDAO.getCustomerByID(user.getUserId());
				request.getSession().setAttribute("user", customer);
				direct = "customer";
			}
		}
		return direct;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String getLogin(){
		return "redirect:pages/login.html";
	}
}
