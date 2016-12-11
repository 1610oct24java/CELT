package com.revature.controllers;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.revature.beans.FoodItem;
import com.revature.beans.Manager;
import com.revature.beans.Restaurant;
import com.revature.exception.NoAuthorizedUserException;
import com.revature.service.MenuService;
import com.revature.service.ReviewService;

@Controller
@RequestMapping(value = "/viewMyMenu")
public class MenuController {
	Logger log = Logger.getRootLogger();
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.GET)
	public Object getMenu(HttpSession s,
				@RequestParam(value = "action") String action) throws NoAuthorizedUserException{
		Manager manager = (Manager) s.getAttribute("currentUser");
		if(manager == null){
			throw new NoAuthorizedUserException("Manager not defined.");
		}
		
		System.out.println(action);
		log.debug(action);
		System.out.println(action);
		Restaurant restaurant = manager.getRestaurant();
		
		switch(action){
		case "restaurant":
			log.debug("restaurant = " + restaurant);
			return restaurant;
		case "stars":
			log.debug("stars = " + restaurant.getReviews());
			return new ReviewService().getRaiting(restaurant.getReviews());
		case "menu":
			log.debug("menu = " + restaurant.getMenu());
			return restaurant.getMenu();
		default:
			return "";
		}
	}
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.POST)
	public String addItemsToMenu(@RequestBody String JsonMenu){
		ObjectMapper om = new ObjectMapper();
		System.out.println(JsonMenu);
		
		try {			
			FoodItem[] menuArray = om.readValue(JsonMenu, FoodItem[].class);
			
			new MenuService().addMenuItems(Arrays.asList(menuArray));
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			return "failure";
		}
		
		return "success";
	}
	
	@RequestMapping(method=RequestMethod.DELETE)
	public void deleteMenu(@RequestBody String JsonMenu){
		ObjectMapper om = new ObjectMapper();
		
		FoodItem[] menuArray;
		try {
			menuArray = om.readValue(JsonMenu, FoodItem[].class);
			new MenuService().deleteMenu(Arrays.asList(menuArray));
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
