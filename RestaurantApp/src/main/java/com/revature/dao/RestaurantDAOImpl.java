package com.revature.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.beans.ContactInfo;
import com.revature.beans.Manager;
import com.revature.beans.Restaurant;
import com.revature.util.HibernateUtil;

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
		
		//session.save(res); cascadetype.All will save the restaurant corresponding to this manager
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

}
