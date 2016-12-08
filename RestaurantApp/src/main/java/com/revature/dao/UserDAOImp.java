package com.revature.dao;

import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.Query;
import org.hibernate.Session;

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
		
		//hql = "FROM User AS U WHERE U.username = :u_name AND U.password = :u_password ";
		hql = "FROM MANAGERS AS M WHERE M.username = :u_name AND M.password = :u_password ";
		query = session.createQuery(hql);
		query.setParameter("u_name", username);
		query.setParameter("u_password", password);
		List users = query.list();
		for(Object user: users)
		{
			returnUser = (User) user;
		}
		return returnUser;
	}
}