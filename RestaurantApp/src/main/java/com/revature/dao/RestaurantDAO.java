package com.revature.dao;

import java.util.List;

import com.revature.beans.ContactInfo;
import com.revature.beans.Manager;
import com.revature.beans.Restaurant;

public interface RestaurantDAO 
{
	public void saveRestaurant(ContactInfo info,Restaurant res, Manager man);
	public void updateRestaurant(Restaurant res);
	public void deleteRestaurant(Restaurant res);
	public List<Restaurant> getRestaurants();
}