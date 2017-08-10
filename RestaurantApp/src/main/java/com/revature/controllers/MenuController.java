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
		Manager manager = (Manager) s.getAttribute("user");
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
			return new ReviewService().getRating(restaurant.getReviews());
		case "menu":
			log.debug("menu = " + restaurant.getMenu());
			return restaurant.getMenu();
		default:
			return "";
		}
	}
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.POST)
	public void addItemsToMenu(@RequestBody String JsonMenu, HttpSession session) throws IOException {
		ObjectMapper om = new ObjectMapper();
		
		Manager manager = (Manager) session.getAttribute("currentUser");
		FoodItem[] menuArray = om.readValue(JsonMenu, FoodItem[].class);
		
		for(FoodItem i : menuArray){
			i.setRestaurant(manager.getRestaurant());
		}

		new MenuService().addMenuItems(Arrays.asList(menuArray));
	}
	
	@RequestMapping(method=RequestMethod.DELETE)
	public void deleteMenu(@RequestBody String JsonMenu) throws IOException {
		ObjectMapper om = new ObjectMapper();
		
		FoodItem[] menuArray = om.readValue(JsonMenu, FoodItem[].class);
		new MenuService().deleteMenu(Arrays.asList(menuArray));

	}
}
