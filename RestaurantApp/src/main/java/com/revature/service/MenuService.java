package com.revature.service;

import java.util.List;

import com.revature.beans.FoodItem;
import com.revature.dao.MenuDao;
import com.revature.dao.RestaurantMenuDao;

public class MenuService {
	private RestaurantMenuDao rmd;
	
	public MenuService(){
		rmd = new MenuDao();
	}
	
	public int deleteMenu(List<FoodItem> menu){
		int rows = 0;
		
		for(FoodItem item : menu){
			rows += rmd.deleteFoodItem(item);
		}
		
		return rows;
	}
	
	public int addMenuItems(List<FoodItem> menu){
		int rows = 0;
		for(FoodItem item : menu){
			rmd.createMenuItem(item);
			rows++;
		}
		
		return rows;
	}
}
