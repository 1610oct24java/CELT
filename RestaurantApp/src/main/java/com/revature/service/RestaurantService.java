package com.revature.service;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.revature.beans.Restaurant;
import com.revature.dao.RestaurantDAO;
import com.revature.dao.RestaurantDAOImpl;

@Component
public class RestaurantService {
	private RestaurantDAO rdao;
	
	public RestaurantService(){
		rdao = new RestaurantDAOImpl();
	}
	
	public ArrayList<Restaurant> getOpenRestaurants() {
		ArrayList<Restaurant> openRestaurants = new ArrayList<Restaurant>();
		
		for(Restaurant r : rdao.getRestaurants()){
			//if(r.isOpen())
				openRestaurants.add(r);
		}
		
		return openRestaurants;
	}

}
