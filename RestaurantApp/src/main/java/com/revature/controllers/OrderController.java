package com.revature.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.revature.beans.Customer;

@Controller
@RequestMapping(value="/Order")
public class OrderController {
	
	@RequestMapping
	public String forwardToOrderingPage(HttpSession s){
		Customer customer = (Customer) s.getAttribute("user");
		
		if(customer==null){
			//No one is logged in so customer is set to guest
			customer = new Customer();
			customer.setUsername("guest");
			customer.setUserId(0);
			s.setAttribute("user", customer);
		}
		return "forward:pages/orderData/main.html";
	}

}
