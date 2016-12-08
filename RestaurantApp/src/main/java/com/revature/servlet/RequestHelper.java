package com.revature.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.beans.User;
import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImp;

public class RequestHelper {
	
	public String process(HttpServletRequest request, HttpServletResponse response){
		String direct = "index.html";
		UserDAO userDAO = new UserDAOImp();
		
		switch(request.getRequestURI()) {
		case "/RestaurantApp/login.do":
			User user = checkLogin(request.getParameter("username"), request.getParameter("password"));
			if (user != null) {
				// valid user so save userID in the session
				//request.getSession().setAttribute("user", user);
				//if () {
//					direct = "customer.html";
//				} else {
//					direct = "restaurant.html";
//				}
				if (userDAO.getManagerByID(user.getUserId()) != null){
					direct = "restaurant.html";
				}
			}
			break;
		case "/RestaurantApp/logout.do":
			request.getSession().invalidate();
			break;
		}
		return direct;
	}

	public User checkLogin(String username, String password) {
//		if (username.equals("me")) {
//
//			return 1;
//		} else if (username.equals("you")) {
//
//			return 2;
//		}
//		return 0;
		UserDAO userDAO = new UserDAOImp();
		User user = userDAO.checkLogin(username, password);
		return user;
	}
}
