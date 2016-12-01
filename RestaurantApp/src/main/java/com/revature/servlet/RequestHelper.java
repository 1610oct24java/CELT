package com.revature.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelper {
	
	public String process(HttpServletRequest request, HttpServletResponse response){
		switch(request.getRequestURI()){
		case "/RestaurantApp/login.do": 
			//return ;
			
		}
		return "index.html";
	}
}
