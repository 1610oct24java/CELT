package com.revature.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelper {
	
	public String process(HttpServletRequest request, HttpServletResponse response){
		String direct = "index.html";
		int accountID = 0;
		
		switch(request.getRequestURI()) {
		case "/RestaurantApp/login.do":
			accountID = checkLogin(request.getParameter("username"), request.getParameter("password"));
			if (accountID > 0) {
				// valid user so save userID in the session
				request.getSession().setAttribute("userID", accountID);
				if (accountID == 1) {
					direct = "customer.html";
				} else {
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

	public int checkLogin(String username, String password) {
		if (username.equals("me")) {

			return 1;
		} else if (username.equals("you")) {

			return 2;
		}
		return 0;
	}
}
