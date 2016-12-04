package com.revature.dao;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.revature.beans.Customer;
import com.revature.util.HibernateUtil;

@Component
public class CustomerDAOImpl implements CustomerDAO {

	private Session session;
	public Customer createCustomer(Customer customer ) {
		session = HibernateUtil.getSession();
		customer = (Customer) session.save(customer);
		session.close();
		return customer;
	}

}
