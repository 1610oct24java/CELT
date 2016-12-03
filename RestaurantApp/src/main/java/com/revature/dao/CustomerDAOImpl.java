package com.revature.dao;

import org.hibernate.Session;
import org.springframework.web.bind.annotation.RequestBody;

import com.revature.beans.Customer;
import com.revature.util.HibernateUtil;

public class CustomerDAOImpl implements CustomerDAO {

	private Session session;
	public Customer createCustomer(@RequestBody Customer customer ) {
		session = HibernateUtil.getSession();
		customer = (Customer) session.save(customer);
		return customer;
	}

}
