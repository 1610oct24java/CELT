package com.revature.service;

import org.springframework.stereotype.Component;

import com.revature.beans.User;

@Component
public class UserService {
	public User auth(User user){
		User authUser = null	;
		if(user.checkPassword(null)){
			authUser = user;
		}
		
		return authUser;
	}
}
