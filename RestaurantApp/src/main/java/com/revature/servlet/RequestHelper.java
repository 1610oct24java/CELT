package com.revature.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.beans.Customer;
import com.revature.beans.Manager;
import com.revature.beans.User;
import com.revature.dao.RestaurantDAO;
import com.revature.dao.RestaurantDAOImp;
import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImp;

public class RequestHelper {
	
	public String process(HttpServletRequest request, HttpServletResponse response){
		String direct = "index.html";
		UserDAO userDAO = new UserDAOImp();
		RestaurantDAO restaurantDAO = new RestaurantDAOImp();
		Manager manager = null;
		Customer customer = null;
		
		switch(request.getRequestURI()) {
		case "/RestaurantApp/login.do":
			User user = checkLogin(request.getParameter("username"), request.getParameter("password"));
			if (user != null) {
				manager = userDAO.getManagerByID(user.getUserId());
				if (manager != null){
					// user is a manager
					request.getSession().setAttribute("user", manager);
					direct = "restaurant.html";
				}
				else{
					// user is a customer
					customer = userDAO.getCustomerByID(user.getUserId());
					request.getSession().setAttribute("user", customer);
					direct = "customer.html";
				}
			}
			break;
		case "/RestaurantApp/logout.do":
			request.getSession().invalidate();
			break;
		case "/RestaurantApp/status.do":
			restaurantDAO.changeStatus(50);
			break;
		}
		return direct;
	}

	public User checkLogin(String username, String password) {
		UserDAO userDAO = new UserDAOImp();
		User user = userDAO.checkLogin(username, password);
		
		return user;
	}
}
