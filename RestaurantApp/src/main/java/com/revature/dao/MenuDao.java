package com.revature.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.revature.beans.FoodItem;
import com.revature.util.HibernateUtil;

public class MenuDao implements RestaurantMenuDao {
	
	@Override
	public void createMenuItem(FoodItem noms) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		session.save(noms);
		tx.commit();
		session.close();
	}

	@Override
	public FoodItem readMenuItem(int foodItemId) {
		Session session = HibernateUtil.getSession();
		
		FoodItem item = (FoodItem) session.createCriteria(FoodItem.class)
				.add(Restrictions.ilike("id", foodItemId))
					.uniqueResult();
		
		return item;
	}

	@Override
	public List<FoodItem> getAllItems() {
		Session session = HibernateUtil.getSession();
		Criteria ct;
		List<FoodItem> foodItems = session.createCriteria(FoodItem.class).list();
		
		return foodItems;
	}

	@Override
	public FoodItem updateMenuItem(FoodItem noms) {
		return null;
	}

	@Override
	public int deleteFoodItem(FoodItem noms) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		FoodItem item;
		
		try{
			item = (FoodItem) session.load(FoodItem.class, noms.getId());
		} catch (ObjectNotFoundException e) {
			tx.rollback();
			session.close();
			return 0;
		}
		
		session.delete(item);
		tx.commit();
		session.close();
		
		return 1;
	}

}
