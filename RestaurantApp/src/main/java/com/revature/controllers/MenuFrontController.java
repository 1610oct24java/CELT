package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.revature.beans.ContactInfo;
import com.revature.beans.FoodItem;
import com.revature.beans.Manager;
import com.revature.beans.Restaurant;

@Controller
@RequestMapping(value="/ManagerDashboard")
public class MenuFrontController {
	
	@RequestMapping
	public String viewManagerDashboard(ModelMap modelMap, HttpSession session){
		
		Manager manager = (Manager) session.getAttribute("currentUser");
		if(manager == null){
			manager = new Manager();
			manager.setUserId(0);
			manager.setPassword("SecurePassword");
			
			Restaurant restaurant = new Restaurant();
			restaurant.setId(0);
			restaurant.setName("Chicken Stop");
			
			ContactInfo address = new ContactInfo();
			address.setCity("Nowhere");
			address.setEmail("donotreply@gmail.com");
			address.setId(0);
			address.setPhone("1800goodbye");
			address.setState("Canada");
			address.setStreet("1234 No Way");
			address.setZip("12345");
			restaurant.setAddress(address);
			
			List<FoodItem> menu = new ArrayList<FoodItem>();
			
			FoodItem chicken = new FoodItem();
			FoodItem chickenWithFries = new FoodItem();
			chicken.setDescription("It's literally just chicken");
			chickenWithFries.setDescription("Do I really need to explain anything?");
			chicken.setId(0);
			chickenWithFries.setId(1);
			chicken.setName("Chicken");
			chickenWithFries.setName("Chicken with Fries");
			chicken.setPrice(123.4f);
			chickenWithFries.setPrice(1876);
			chicken.setRestaurant(restaurant);
			chickenWithFries.setRestaurant(restaurant);
			chicken.setSoldOut(false);
			chickenWithFries.setSoldOut(false);
			chicken.setSpecial(false);
			chickenWithFries.setSpecial(false);

			menu.add(chicken);
			menu.add(chickenWithFries);
			restaurant.setMenu(menu);
			
			manager.setRestaurant(restaurant);
			
			session.setAttribute("currentUser", manager);
		}
		
		return "forward:/menuData/main.html";
	}
}
