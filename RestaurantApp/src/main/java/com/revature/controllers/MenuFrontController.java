package com.revature.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.revature.beans.FoodItem;
import com.revature.beans.Manager;
import com.revature.beans.Restaurant;
import com.revature.exception.NoAuthorizedUserException;

@Controller
@RequestMapping(value="/ManagerDashboard")
public class MenuFrontController {
	
	@RequestMapping
	public String viewManagerDashboard(ModelMap modelMap, HttpSession session) throws NoAuthorizedUserException{
		Manager manager = (Manager) session.getAttribute("currentUser");
		if(manager == null){
			//throw new NoAuthorizedUserException("Manager Not Defined");
			Manager m = new Manager();
			m.setRestaurant(new Restaurant());
			m.getRestaurant().setId(150);
			m.getRestaurant().setMenu(new ArrayList<FoodItem>());
			m.getRestaurant().getMenu().add(new FoodItem());
			m.getRestaurant().getMenu().add(new FoodItem());
			m.getRestaurant().getMenu().get(0).setDescription("It's just chicken");
			m.getRestaurant().getMenu().get(1).setDescription("I can't explain any more than that");
			m.getRestaurant().getMenu().get(0).setName("Chicken");
			m.getRestaurant().getMenu().get(1).setName("Chicken With Fries");
			m.getRestaurant().getMenu().get(0).setPrice(5.5f);
			m.getRestaurant().getMenu().get(1).setPrice(8.5f);
			
			session.setAttribute("currentUser", m);
		}
		
		return "forward:/pages/menuData/main.html";
	}
}
