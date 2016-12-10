package com.revature.testconfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.revature.beans.ContactInfo;
import com.revature.beans.Customer;
import com.revature.beans.FoodItem;
import com.revature.beans.Invoice;
import com.revature.beans.InvoiceItem;
import com.revature.beans.Manager;
import com.revature.beans.Restaurant;
import com.revature.beans.Review;
import com.revature.controllers.DeliveryInfoController;
import com.revature.controllers.MenuController;
import com.revature.controllers.MenuFrontController;
import com.revature.controllers.UserController;
import com.revature.dao.CustomerDAO;
import com.revature.dao.CustomerDAOImpl;
import com.revature.dao.DeliveryDao;
import com.revature.dao.DeliveryDaoImpl;
import com.revature.dao.MenuDao;
import com.revature.dao.RestaurantMenuDao;
import com.revature.exception.NoAuthorizedUserException;
import com.revature.logging.Logging;
import com.revature.service.MenuService;
import com.revature.util.HibernateUtil;

@Configuration
public class AppConfig {
	
	/*
	 * Creating TestBeans for com.revature.beans package
	 */
	
	@Bean
	public ContactInfo getContactInfo(){
		return new ContactInfo();
	}
	
	@Bean
	public Customer getCustomer(){
		return new Customer();
	}
	
	@Bean
	public FoodItem getFoodItem(){
		return new FoodItem();
	}
	
	@Bean
	public Invoice getInvoice(){
		return new Invoice();
	}
	
	@Bean
	public InvoiceItem getInvoiceItem(){
		return new InvoiceItem();
	}
	
	@Bean
	public Manager getManager(){
		return new Manager();
	}
	
	@Bean
	public Restaurant getRestaurant(){
		return new Restaurant();
	}
	
	@Bean
	public Review getReview(){
		return new Review();
	}
	
	/*
	 * Creating TestBeans for com.revature.controllers package
	 */
	
	@Bean
	public DeliveryInfoController getDeliveryInfoController() {
		return new DeliveryInfoController();
	}
	
	@Bean
	public MenuController getMenuController() {
		return new MenuController();
	}
	
	@Bean
	public MenuFrontController getMenuFrontController(){
		return new MenuFrontController();
	}
	
	@Bean
	public UserController getUserController(){
		return new UserController();
	}
	
	/*
	 * Creating TestBeans for com.revature.dao package
	 */
	
	@Bean
	public CustomerDAO getcustomerDAO(){
		return new CustomerDAOImpl();
	}
	
	@Bean
	public DeliveryDao getDeliveryDao(){
		return new DeliveryDaoImpl();
	}
	
	@Bean 
	public RestaurantMenuDao getRestaurantMenuDao(){
		return new MenuDao();
	}
	
	/*
	 * Creating TestBeans for com.revature.exception package
	 */

	@Bean
	public NoAuthorizedUserException getNoAuthorizedUserException(){
		return new NoAuthorizedUserException();
	}
	
	/*
	 * Creating TestBeans for com.revature.logging package
	 */
	
	@Bean
	public Logging getLoggin(){
		return new Logging();
	}

	/*
	 * Creating TestBeans for com.revature.service package
	 */
	
	@Bean
	public MenuService getMenuService(){
		return new MenuService();
	}
	
	/*
	 * Creating TestBeans for com.revature.util package
	 */
	
	@Bean
	public HibernateUtil getHibernateUtil(){
		return new HibernateUtil();
	}
}
