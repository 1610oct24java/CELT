package com.revature.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.beans.ContactInfo;
import com.revature.beans.Manager;
import com.revature.beans.Restaurant;
import com.revature.util.HibernateUtil;

public class RestaurantDAOImp implements RestaurantDAO{

	@Override
	public void saveRestaurant(ContactInfo info, Restaurant res, Manager man)
	{
		Session session = HibernateUtil.getSession();
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
	public int changeStatus(int restaurantId) {
		int rowsUpdated = 0;
		Session session = HibernateUtil.getSession();
		String hql;
		Transaction tx;
		Query query;
		
		tx = session.beginTransaction();
		hql = "UPDATE Restaurant SET status = 'OPEN' WHERE id = :r_id AND status = 'CLOSED'";
		query = session.createQuery(hql);
		query.setParameter("r_id", restaurantId);
		rowsUpdated = query.executeUpdate();
		tx.commit();
		
		if (rowsUpdated == 0){
			tx = session.beginTransaction();
			hql = "UPDATE Restaurant SET status = 'CLOSED' WHERE id = :r_id";
			query = session.createQuery(hql);
			query.setParameter("r_id", restaurantId);
			rowsUpdated = query.executeUpdate();
			tx.commit();
		}
		session.close();
		
		return rowsUpdated;
	}
}
