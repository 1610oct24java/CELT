package com.revature.controllerTest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.revature.beans.ContactInfo;
import com.revature.controllers.DeliveryInfoController;

@Configuration
public class AppConfig {
	
	@Bean
	public DeliveryInfoController getDeliveryInfoController() {
		return new DeliveryInfoController();
	}
	
	@Bean
	public ContactInfo getContactInfo(){
		return new ContactInfo();
	}

}
