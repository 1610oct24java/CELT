package com.revature.controllerTest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.revature.beans.ContactInfo;
import com.revature.controllers.DeliveryInfoController;
import com.revature.dao.DeliveryDao;
import com.revature.dao.DeliveryDaoImpl;

@Configuration
public class AppConfig {
	
	/**
	 * TestBeans for com.revature.beans package
	 * 
	 */
	@Bean
	public ContactInfo getContactInfo(){
		return new ContactInfo();
	}
	
	/******************************************************************************************/
	
	@Bean
	public DeliveryInfoController getDeliveryInfoController() {
		return new DeliveryInfoController();
	}
	
	@Bean
	public DeliveryDao getDeliveryDao(){
		return new DeliveryDaoImpl();
	}

}
