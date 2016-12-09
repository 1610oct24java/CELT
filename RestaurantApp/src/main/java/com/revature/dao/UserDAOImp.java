package com.revature.dao;

import java.util.List;

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
		Session session = HibernateUtil.getSession();
		Query query;
		String hql;
		Transaction tx;
		User returnUser = null;

		hql = "FROM User WHERE username = :u_name";
		query = session.createQuery(hql);
		query.setParameter("u_name", username);
		List users = query.list();
		System.out.println(users.toString());
		for (Object user : users) {
			returnUser = (User) user;
		}
		if (returnUser != null) {
			// username was found
			if (returnUser.checkPassword(password)) {
				// login is correct
				return returnUser;
				
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
		Transaction tx;
		Manager returnManager = null;

		hql = "FROM Manager AS M WHERE M.userId = :accountID";
		query = session.createQuery(hql);
		query.setParameter("accountID", id);
		List managers = query.list();
		for (Object manager : managers) {
			returnManager = (Manager) manager;
		}
		return returnManager;
	}

	@Override
	public Customer getCustomerByID(int id) {
		Session session = HibernateUtil.getSession();
		Query query;
		String hql;
		Transaction tx;
		Customer returnCustomer = null;

		hql = "FROM Customer AS C WHERE C.userId = :accountID";
		query = session.createQuery(hql);
		query.setParameter("accountID", id);
		List customers = query.list();
		for (Object customer : customers) {
			returnCustomer = (Customer) customer;
		}
		return returnCustomer;
	}
}
