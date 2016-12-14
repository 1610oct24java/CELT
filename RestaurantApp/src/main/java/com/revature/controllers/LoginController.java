package com.revature.controllers;

import java.util.LinkedHashMap;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.beans.Manager;
import com.revature.beans.Customer;
import com.revature.beans.User;
import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImp;

@Controller
@RequestMapping(value = "/login")
public class LoginController {
	@RequestMapping(method=RequestMethod.POST)
	public @ResponseBody Object doLogin(@RequestBody LinkedHashMap<String, String> lhm, HttpServletRequest request){
		Object direct = null;
		UserDAO userDAO = new UserDAOImp();
		Manager manager = null;
		Customer customer = null;
		
	/*	Set<String> keys = lhm.keySet();
		Object[]strarr =   keys.toArray();
		
		for(Object str : strarr){
			System.out.println(str);
		}
		System.out.println("++++++++++++++++++++++++++++++++++++++");
		Collection<String> values = lhm.values();
		for(String str : values){
			System.out.println(str);
		}*/
		String username = lhm.getOrDefault("username", null);
		String password = lhm.getOrDefault("password", null);
		User user = userDAO.checkLogin(username, password);
		if (user != null) {
			manager = userDAO.getManagerByID(user.getUserId());
			if (manager != null){
				// user is a manager
				request.getSession().setAttribute("user", manager);
				direct = manager;
			}
			else{
				// user is a customer
				customer = userDAO.getCustomerByID(user.getUserId());
				request.getSession().setAttribute("user", customer);
				direct = customer;
			}
		}
		return direct;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String getLogin(){
		return "redirect:pages/login.html";
	}
}
