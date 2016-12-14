package com.revature.dao;

import javax.transaction.Transaction;

import org.hibernate.Query;
import org.hibernate.Session;

import com.revature.beans.Customer;
import com.revature.beans.Manager;
import com.revature.beans.User;
import com.revature.util.HibernateUtil;

public class UserDAOImp implements UserDAO {

	@Override
	public User checkLogin(String username, String password) {
		System.out.println("In checkLogin: " + username + " " + password);
		Session session = HibernateUtil.getSession();
		Query query;
		String hql;
		Object returnUser = null;

		hql = "FROM User WHERE username = :u_name";
		query = session.createQuery(hql);
		query.setParameter("u_name", username);
		returnUser = query.uniqueResult();
		if (returnUser != null) {
			// username was found
			if (((User) returnUser).checkPassword(password)) {
				// login is correct
				return (User) returnUser;
				
			} else {
				// password is incorrect
				return null;
				
			}
		}
		// username was not found
		return null;
	}

	@Override
	public Manager getManagerByID(int id) {
		Session session = HibernateUtil.getSession();
		Query query;
		String hql;
		Object returnManager = null;

		hql = "FROM Manager AS M WHERE M.userId = :accountID";
		query = session.createQuery(hql);
		query.setParameter("accountID", id);
		returnManager = query.uniqueResult();
		if (returnManager != null){
			return (Manager) returnManager;
			
		}
		return null;
	}

	@Override
	public Customer getCustomerByID(int id) {
		Session session = HibernateUtil.getSession();
		Query query;
		String hql;
		Transaction tx;
		Object returnCustomer = null;

		hql = "FROM Customer AS C WHERE C.userId = :accountID";
		query = session.createQuery(hql);
		query.setParameter("accountID", id);
		returnCustomer = query.uniqueResult();
		if (returnCustomer != null){
			return (Customer) returnCustomer;
					
		}
		
		return null;
	}
}
