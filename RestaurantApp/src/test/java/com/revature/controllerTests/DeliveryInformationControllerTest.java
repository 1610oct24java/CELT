package com.revature.controllerTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;


import com.revature.beans.ContactInfo;
import com.revature.controllers.DeliveryInfoController;
import com.revature.testconfiguration.AppConfig;

@RunWith(SpringJUnit4ClassRunner.class)
//Reference https://examples.javacodegeeks.com/core-java/junit/spring-junit-test-example/
@ContextConfiguration(classes = AppConfig.class, loader = AnnotationConfigContextLoader.class)
public class DeliveryInformationControllerTest {

	@Autowired
	private DeliveryInfoController diController;
	
	@Autowired
	private ContactInfo ci;
	
	@Before
	public void setUp()
	{ 
		ci.setCity("NukeTown");
		ci.setEmail("spring@jUnit.net");
		ci.setId(0);
		ci.setPhone("555-555-5555");
		ci.setZip("55555");
		ci.setStreet("NukeTown Street");
		ci.setState("TX");	
	}
	@After
	public void tearDown(){
		ci = null;
	}
	
	@Test
	public void saveContactInfoTest(){
		ContactInfo ci2 = diController.saveContactInfo(ci);
		assertNotNull(ci2);
		assertEquals("city", "NukeTown", ci2.getCity());
		assertEquals("email", "spring@jUnit.net", ci2.getEmail());
		assertEquals("phone", "555-555-5555", ci2.getPhone());
		assertEquals("zip", "55555", ci2.getZip());
		assertEquals("street", "NukeTown Street", ci2.getStreet());
		assertEquals("state", "TX", ci2.getState());
	}
}
