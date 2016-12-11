package com.revature.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.service.RestaurantService;

@Controller
@RequestMapping(value="/viewRestaurantList")
public class OrderProcessor {
	@ResponseBody
	@RequestMapping(method=RequestMethod.GET)
	public Object getRaiting(){
		return new RestaurantService().getOpenRestaurants();
	}
}
