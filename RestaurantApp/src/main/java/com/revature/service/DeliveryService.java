package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.beans.ContactInfo;
import com.revature.beans.Invoice;
import com.revature.beans.InvoiceItem;
import com.revature.dao.DeliveryDao;
import com.revature.dao.DeliveryDaoImpl;
import com.revature.dao.InvoiceDao;
import com.revature.dao.InvoiceDaoImpl;
import com.revature.dao.MenuDao;
import com.revature.dao.RestaurantMenuDao;
import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImp;

@Component
public class /* Chelle's */DeliveryService {
	//As of yet there's no real point to this class but the name is too perfect
	@Autowired
	private DeliveryDao deliveryDao;
	@Autowired
	private InvoiceDao invoiceDao;
	@Autowired
	private RestaurantMenuDao menuDao;
	@Autowired
	private UserDAO userDao;
	
	/*
	 * Setters for Dependency Injection
	 */
	public void setDeliveryDao(DeliveryDao dao){
		this.deliveryDao = dao;
	}
	
	public void setInvoiceDao(InvoiceDao dao){
		this.invoiceDao = dao;
	}
	
	public void setMenuDao(RestaurantMenuDao dao){
		this.menuDao = dao;
	}

	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

	/*	
	 * This won't actually work upon 
	 * implementing the transaction 
	 * because the implementations of 
	 * the daos save the current 
	 * transaction automatically so
	 * but it should work as is
	 */ 
	public void saveInvoice(Invoice invoice){
		//Session session = new HibernateUtil().getSession();
		//Transaction tx = session.beginTransaction();		
		ContactInfo contactInfo = invoice.getContact();
		List<InvoiceItem> order = invoice.getItems();
		
		setDeliveryDao(new DeliveryDaoImpl());
		setInvoiceDao(new InvoiceDaoImpl());
		setMenuDao(new MenuDao());
		setUserDao(new UserDAOImp());
		
		deliveryDao.saveContactInfo(contactInfo);
		for(InvoiceItem i : order){
			System.out.println("ID: " + i.getItem().getId());
			menuDao.readMenuItem(i.getItem().getId());
			i.setItem(i.getItem());
			i.setOrder(invoice);
		}
		System.out.println(invoice.getCustomer());
		
		invoice.setCustomer(
				userDao.getCustomerByID(
						invoice.getCustomer().getId()));
		invoiceDao.saveInvoice(invoice);
		
		//tx.commit();
		//session.close();
	}
}
