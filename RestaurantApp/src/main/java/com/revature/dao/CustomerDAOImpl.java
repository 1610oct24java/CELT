package com.revature.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.revature.beans.Customer;
import com.revature.util.HibernateUtil;

@Component
public class CustomerDAOImpl implements CustomerDAO {

	private Session session;
	
	public Customer createCustomer(Customer customer){
		session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		System.out.println(customer.toString());
		int id = (Integer) session.save(customer);
		if(id<1){
			tx.rollback();
			customer = null;
		}else{
			tx.commit();
			customer.setUserId(id);
		}
		session.close();
		return customer;
	}

}
