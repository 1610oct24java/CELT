package com.revature.dao;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Customer;
import com.revature.util.HibernateUtil;

public class CustomerDAOImpl implements CustomerDAO {

	private Session session;
	private HibernateUtil hu;
	
	public Customer createCustomer(HttpServletRequest request) {
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Customer customer = new Customer(0, password, null, firstName, lastName);
		session = hu.getSession();
		customer = (Customer) session.save(customer);
		return customer;
	}

}
