package com.revature.controllers;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.beans.FoodItem;
import com.revature.beans.Manager;
import com.revature.exception.NoAuthorizedUserException;
import com.revature.service.MenuService;

@Controller
@RequestMapping(value = "/viewMyMenu")
public class MenuController {
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.GET)
	public List<FoodItem> getMenu(HttpSession session) throws NoAuthorizedUserException{
		
		Manager manager = (Manager) session.getAttribute("currentUser");
		
		if(manager == null){
			throw new NoAuthorizedUserException("Manager Not Defined");
		}
		
		return manager.getRestaurant().getMenu();
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String addItemsToMenu(@RequestBody String JsonMenu){
		ObjectMapper om = new ObjectMapper();
		System.out.println(JsonMenu);
		
		try {			
			FoodItem[] menuArray = om.readValue(JsonMenu, FoodItem[].class);
			
			new MenuService().addMenuItems(Arrays.asList(menuArray));
		} catch (org.codehaus.jackson.JsonParseException e) {

			e.printStackTrace();
		} catch (org.codehaus.jackson.map.JsonMappingException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		return "redirect:/home";
	}
	
	@RequestMapping(method=RequestMethod.DELETE)
	public String deleteMenu(@RequestBody String JsonMenu){
		ObjectMapper om = new ObjectMapper();
		try {			
			FoodItem[] menuArray = om.readValue(JsonMenu, FoodItem[].class);
			
			new MenuService().deleteMenu(Arrays.asList(menuArray));
		} catch (org.codehaus.jackson.JsonParseException e) {

			e.printStackTrace();
		} catch (org.codehaus.jackson.map.JsonMappingException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		return "redirect:/home";
	}
}
