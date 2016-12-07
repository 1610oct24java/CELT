package com.revature.controllers;

import java.util.Map.Entry;

import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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

	/*
	 * @RequestMapping(value="/index") public String getIndexPage(){ return
	 * "index"; }
	 */

	@RequestMapping(value="/cCustomer", method=RequestMethod.POST)
	public @ResponseBody Customer createUser(@RequestBody Customer customer){
	return cdao.createCustomer(customer);
	//	return "redirect:pages/index.html";
	}
}
