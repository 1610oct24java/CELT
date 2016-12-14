package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.revature.beans.ContactInfo;
import com.revature.beans.Manager;
import com.revature.beans.Restaurant;
import com.revature.util.HibernateUtil;

@Component
public class RestaurantDAOImpl implements RestaurantDAO {

	private HibernateUtil hu;
	public RestaurantDAOImpl()
	{
		super();
		hu = new HibernateUtil();
	}
	@Override
	public void saveRestaurant(ContactInfo info, Restaurant res, Manager man)
	{
		Session session = hu.getSession();
		Transaction tx = session.beginTransaction();
		res.setAddress(info);
		man.setRestaurant(res);
		session.save(man);
		
		tx.commit();
		session.close();	
	}

	@Override
	public void updateRestaurant(Restaurant res) {
		
	}

	@Override
	public void deleteRestaurant(Restaurant res) {
	
	}
	@Override
	public List<Restaurant> getRestaurants() {
		ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
		Session session = hu.getSession();
		Transaction tx = session.beginTransaction();
		
		restaurants = (ArrayList<Restaurant>) session.createCriteria(Restaurant.class)
								.list();
		
		return restaurants;
	}

}
