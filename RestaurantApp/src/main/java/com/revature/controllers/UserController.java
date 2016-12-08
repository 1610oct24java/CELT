package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.beans.Customer;
import com.revature.dao.CustomerDAO;

@Controller
public class UserController {

	@Autowired
	private CustomerDAO cdao;

	@RequestMapping(value="/cCustomer", method=RequestMethod.POST)
	public @ResponseBody Customer createUser(@RequestBody Customer customer){
	return cdao.createCustomer(customer);
	}
}
