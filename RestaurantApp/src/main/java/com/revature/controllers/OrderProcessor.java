package com.revature.controllers;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Customer;
import com.revature.beans.Invoice;
import com.revature.service.DeliveryService;
import com.revature.service.RestaurantService;

@Controller
@RequestMapping(value="/orderProcessing")
public class OrderProcessor {
	@ResponseBody
	@RequestMapping(method=RequestMethod.GET)
	public Object getRaiting(){
		return new RestaurantService().getOpenRestaurants();
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String submitOrder(@RequestBody String order, HttpSession session) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper om = new ObjectMapper();
		Customer customer = (Customer) session.getAttribute("user");
		
		System.out.println(order);

		Invoice invoice = om.readValue(order, Invoice.class);
		invoice.setCustomer(customer);
		
		new DeliveryService().saveInvoice(invoice);;
		
		return "redirect:/review";
	}
}

