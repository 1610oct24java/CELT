package com.revature.dao;

import java.util.List;

import com.revature.beans.FoodItem;

public interface RestaurantMenuDao {
	//C
	public void createMenuItem(FoodItem noms);
	
	//R
	public FoodItem readMenuItem(int foodItemId);
	public List<FoodItem> getAllItems();
	
	//U
	public FoodItem updateMenuItem(FoodItem noms);
	
	//D
	public int deleteFoodItem(FoodItem noms);
}