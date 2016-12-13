package com.revature.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.revature.beans.ContactInfo;
import com.revature.beans.FoodItem;
import com.revature.beans.Manager;
import com.revature.beans.Restaurant;
import com.revature.beans.Review;
import com.revature.exception.NoAuthorizedUserException;

@Controller
@RequestMapping(value="/ManagerDashboard")
public class MenuFrontController {
	
	@RequestMapping
	public String viewManagerDashboard(ModelMap modelMap, HttpSession session) throws NoAuthorizedUserException{
		
		Manager manager = (Manager) session.getAttribute("currentUser");
		if(manager == null){
			//throw new NoAuthorizedUserException("You must be logged in to view this page");
			manager = new Manager();
			manager.setPassword("SecurePassword");
			manager.setUserId(1);
			
			manager.setRestaurant(new Restaurant());
			
			manager.getRestaurant().setAddress(new ContactInfo());
			manager.getRestaurant().getAddress().setCity("Nowhere");
			manager.getRestaurant().getAddress().setEmail("donotReply@GoAway.com");
			manager.getRestaurant().getAddress().setId(1);
			manager.getRestaurant().getAddress().setPhone("1800getout!");
			manager.getRestaurant().getAddress().setState("Canada");
			manager.getRestaurant().getAddress().setStreet("1234 no way");
			manager.getRestaurant().getAddress().setZip("12345");
			manager.getRestaurant().setId(0);

			manager.getRestaurant().setMenu(new ArrayList<FoodItem>());
			manager.getRestaurant().getMenu().add(new FoodItem());
			manager.getRestaurant().getMenu().get(0).setDescription("It's chicken");
			manager.getRestaurant().getMenu().get(0).setId(0);
			manager.getRestaurant().getMenu().get(0).setName("Chicken");
			manager.getRestaurant().getMenu().get(0).setPrice(12.3f);
			manager.getRestaurant().getMenu().get(0).setRestaurant(manager.getRestaurant());
			//manager.getRestaurant().getMenu().get(0).setSoldOut(false);
			manager.getRestaurant().getMenu().get(0).setSpecial(false);

			manager.getRestaurant().getMenu().add(new FoodItem());
			manager.getRestaurant().getMenu().get(1).setDescription("There's nothing to explain");
			manager.getRestaurant().getMenu().get(1).setId(1);
			manager.getRestaurant().getMenu().get(1).setName("Chicken With Fries");
			manager.getRestaurant().getMenu().get(1).setPrice(12.3f);
			manager.getRestaurant().getMenu().get(1).setRestaurant(manager.getRestaurant());
			//manager.getRestaurant().getMenu().get(1).setSoldOut(false);
			manager.getRestaurant().getMenu().get(1).setSpecial(false);
			
			manager.getRestaurant().setReviews(new ArrayList<Review>());
			manager.getRestaurant().getReviews().add(new Review(0,3,"food was ok", manager.getRestaurant()));
			manager.getRestaurant().getReviews().add(new Review(0,4,"food was p good", manager.getRestaurant()));
			manager.getRestaurant().getReviews().add(new Review(0,(float) 3.5,"food was meh", manager.getRestaurant()));
			manager.getRestaurant().setName("Chicken Stop");
			
			session.setAttribute("currentUser", manager);
		}
		
		return "forward:pages/menuData/main.html";
	}
}
