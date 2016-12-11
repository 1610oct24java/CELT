package com.revature.controllers;

import java.io.IOException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.revature.beans.ContactInfo;
import com.revature.beans.Manager;
import com.revature.beans.Restaurant;
import com.revature.dao.RestaurantDAOImpl;

@Controller 
public class RestaurantController 
{
	@RequestMapping(value ="/restaurant",method=RequestMethod.GET)
	public String restaurantRegisterPage()
	{
		return "forward:pages/RegisterRestaurant.html";
	}
	
	@RequestMapping(value = "/restaurant", method=RequestMethod.POST)
	public String saveData(@RequestBody String JsonData) throws JsonParseException, JsonMappingException, IOException
	{
		ObjectMapper om = new ObjectMapper();
		JsonParser parser = new JsonParser(); 
		JsonObject obj = parser.parse(JsonData).getAsJsonObject(); 
		
		String info = obj.get("info").getAsString();
		String res = obj.get("restaurant").getAsString();
		String man = obj.get("manager").getAsString();
		
		ContactInfo contacInfo = om.readValue(info,ContactInfo.class);
		Restaurant restaurant = om.readValue(res, Restaurant.class);
		Manager manager = om.readValue(man, Manager.class);
		
		RestaurantDAOImpl dao = new RestaurantDAOImpl();
		
		dao.saveRestaurant(contacInfo, restaurant, manager);	
    	
    	return "redirect:pages/RegisterRestaurant.html";
	}
}
