 package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.beans.ContactInfo;
import com.revature.dao.DeliveryDao;

@Controller("diController")
public class DeliveryInfoController {

	@Autowired
	private DeliveryDao ddao;

	@RequestMapping(value = "/addContactInfo", method = RequestMethod.POST)
	
	public @ResponseBody ContactInfo saveContactInfo(@RequestBody ContactInfo ci) {
		return ddao.saveContactInfo(ci);
	}
	
	
	
}
