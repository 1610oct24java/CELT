package com.revature.dao;

import com.revature.beans.User;

public interface UserDAO {
	public User checkLogin(String username, String password);
}
