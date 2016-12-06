package com.revature.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.revature.beans.FoodItem;
import com.revature.dao.RestaurantMenuDao;
import com.revature.util.HibernateUtil;

public class MenuDao implements RestaurantMenuDao {
	
	@Override
	public void createMenuItem(FoodItem noms) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		session.save(noms);
		tx.commit();
		session.close();
	}

	@Override
	public FoodItem readMenuItem(int foodItemId) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		
		FoodItem item = (FoodItem) session.createCriteria(FoodItem.class)
				.add(Restrictions.ilike("id", foodItemId))
					.uniqueResult();
		
		return item;
	}

	@Override
	public List<FoodItem> getAllItems() {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		Criteria ct;
		List<FoodItem> foodItems = session.createCriteria(FoodItem.class).list();
		
		return foodItems;
	}

	@Override
	public FoodItem updateMenuItem(FoodItem noms) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteFoodItem(FoodItem noms) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		//Yeah you're gonna have to remove this
		//I know you're mad at me but I needed to test
		//You understand right?
		session.save(noms);
		session.delete(noms);
		tx.commit();
		session.close();
		
		return 1;
	}

}
