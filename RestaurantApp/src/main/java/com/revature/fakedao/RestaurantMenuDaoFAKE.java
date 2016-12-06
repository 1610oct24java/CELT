package com.revature.fakedao;

import java.util.ArrayList;

import com.revature.beans.FoodItem;
import com.revature.dao.RestaurantMenuDao;

public class RestaurantMenuDaoFAKE implements RestaurantMenuDao {

	public RestaurantMenuDaoFAKE() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public ArrayList<FoodItem> getAllItems(){
		return FakeRestaurantDB.getInstance().selectAllFromFoodItem();
	}

	@Override
	public void createMenuItem(FoodItem noms) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public FoodItem readMenuItem(int foodItemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FoodItem updateMenuItem(FoodItem noms) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteFoodItem(FoodItem noms) {
		// TODO Auto-generated method stub
		return 0;
	}

}

class FakeRestaurantDB{
	private ArrayList<FoodItem> menu;
	private static FakeRestaurantDB fdb;
	private static boolean build = true;;
	
	private FakeRestaurantDB(){
		build = false;
		menu = new ArrayList<FoodItem>();
		populateDb();
	}
	
	public static FakeRestaurantDB getInstance(){
		if(build){
			fdb = new FakeRestaurantDB();
		}
		
		return fdb;
	}
	
	private void populateDb(){
		int id = 1;
		FoodItem nom = new FoodItem();
		nom.setDescription("It's just chicken");
		nom.setId(id++);
		nom.setName("Chicken");
		nom.setSoldOut(false);
		nom.setSpecial(false);
		menu.add(nom);
		nom=new FoodItem();
		nom.setDescription("Is there anything to explain honestly??");
		nom.setId(id++);
		nom.setName("Chicken with Fries");
		nom.setSoldOut(false);
		nom.setSpecial(false);
		
	}
	
	public ArrayList<FoodItem> selectAllFromFoodItem(){
		return menu;
	}
}
