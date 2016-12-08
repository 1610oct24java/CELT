package com.revature.dao;

import com.revature.beans.Customer;
import com.revature.beans.Manager;
import com.revature.beans.User;

public interface UserDAO {
	public User checkLogin(String username, String password);
	public Manager getManagerByID(int id);
	public Customer getCustomerByID(int id);
}
