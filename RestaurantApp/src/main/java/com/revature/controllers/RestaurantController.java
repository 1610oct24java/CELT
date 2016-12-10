package com.revature.controllers;

import java.io.IOException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.ContactInfo;
import com.revature.beans.Manager;
import com.revature.beans.Restaurant;
//import com.revature.dao.RestaurantDAOImpl;

@Controller 
public class RestaurantController 
{
	@RequestMapping(value ="/restaurant",method=RequestMethod.GET)
	public String restaurantRegisterPage()
	{
		System.out.println("inside get method");
		return "forward:pages/RegisterRestaurant.html";
	}
	
	@RequestMapping(value = "/restaurant", method=RequestMethod.POST)
	public void saveData(ModelMap modelMap) throws JsonParseException, JsonMappingException, IOException
	{
		System.out.println("inside post method");
		ObjectMapper om = new ObjectMapper();
		String info,res,man;
		info = (String) modelMap.get("info");
		res = (String) modelMap.get("restaurant");
		man = (String) modelMap.get("manager");
		
		ContactInfo contacInfo = om.readValue(info,ContactInfo.class);
		Restaurant restaurant = om.readValue(res, Restaurant.class);
		Manager manager = om.readValue(man, Manager.class);
		//RestaurantDAOImpl dao = new RestaurantDAOImpl();
		
		System.out.println("This is the info: "+contacInfo);
		System.out.println("This is the res: "+restaurant);
		System.out.println("This is the manager: "+manager);
		
		//dao.saveRestaurant(contacInfo, restaurant, manager);	
	}
}
