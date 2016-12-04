package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.revature.beans.Customer;
import com.revature.dao.CustomerDAO;

@Controller
public class UserController {

	@Autowired
	private CustomerDAO cdao;
	
	/*@RequestMapping(value="/index")
	public String getIndexPage(){
		return "index";
	}*/
	
	@RequestMapping(value="/createCustomer")
	public Customer createUser(@RequestBody Customer customer){
		return cdao.createCustomer(customer);
	}
}
