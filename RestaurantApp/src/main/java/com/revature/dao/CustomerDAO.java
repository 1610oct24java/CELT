package com.revature.dao;

import javax.servlet.http.HttpServletRequest;

import com.revature.beans.Customer;

public interface CustomerDAO {

	public Customer createCustomer(HttpServletRequest request);
}
