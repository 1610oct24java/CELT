package com.revature.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

//import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.ContactInfo;
import com.revature.beans.FoodItem;
import com.revature.beans.Manager;
import com.revature.beans.Restaurant;
import com.revature.beans.Review;
import com.revature.service.MenuService;

@Controller
@RequestMapping(value = "/viewMyMenu")
public class MenuController {
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.GET)
	public List<FoodItem> getMenu(ModelMap modelMap){
		//Hey! Future me! Be sure to change this to the session user
		//If you don't this'll never actually work >.>
		Manager manager = new Manager(1, "password", "123456",
					new Restaurant(1, "Chicken Stop", 
						new ArrayList<FoodItem>(), new ArrayList<Review>(), 
							new ContactInfo(1, "1500 Golden Arches Way", "New York", "New York", "12345", "1800eatfresh", "RMcDonald@MCo.com")));
		manager.getRestaurant().getMenu().add(new FoodItem(1, "Chicken", "It's literally just chicken", 8.50f, manager.getRestaurant(), false, false));
		manager.getRestaurant().getMenu().add(new FoodItem(2, "Chicken with Fries", "Is there honestly anything I need to explain?", 12.50f, manager.getRestaurant(), false, false));
		
		return manager.getRestaurant().getMenu();
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String addItemsToMenu(@RequestBody String JsonMenu){
		ObjectMapper om = new ObjectMapper();
		List<FoodItem> menu = new ArrayList<FoodItem>();
		System.out.println(JsonMenu);
		
		try {			
			FoodItem[] menuArray = om.readValue(JsonMenu, FoodItem[].class);
			
			for(FoodItem item : menuArray){
				menu.add(item);
			}
			
			new MenuService().addMenuItems(menu);
		} catch (org.codehaus.jackson.JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (org.codehaus.jackson.map.JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:http://www.google.com";
	}
	
	@RequestMapping(method=RequestMethod.DELETE)
	public String deleteMenu(@RequestBody String JsonMenu){
		ObjectMapper om = new ObjectMapper();
		List<FoodItem> menu = new ArrayList<FoodItem>();
		try {			
			FoodItem[] menuArray = om.readValue(JsonMenu, FoodItem[].class);
			
			for(FoodItem item : menuArray){
				menu.add(item);
			}
			
			new MenuService().deleteMenu(menu);
		} catch (org.codehaus.jackson.JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (org.codehaus.jackson.map.JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:http://www.google.com";
	}
}
