package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.beans.ContactInfo;
import com.revature.beans.FoodItem;
import com.revature.beans.Invoice;
import com.revature.beans.InvoiceItem;
import com.revature.dao.DeliveryDao;
import com.revature.dao.DeliveryDaoImpl;
import com.revature.dao.InvoiceDao;
import com.revature.dao.InvoiceDaoImpl;
import com.revature.dao.MenuDao;
import com.revature.dao.RestaurantMenuDao;

@Component
public class /* Chelle's */DeliveryService {
	//As of yet there's no real point to this class but the name is too perfect
	@Autowired
	private DeliveryDao deliveryDao;
	@Autowired
	private InvoiceDao invoiceDao;
	@Autowired
	private RestaurantMenuDao menuDao;
	
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
		
		FoodItem f;
		ContactInfo contactInfo = invoice.getContact();
		List<InvoiceItem> order = invoice.getItems();
		
		deliveryDao.saveContactInfo(contactInfo);
		for(InvoiceItem i : order){
			f = menuDao.readMenuItem(i.getItem().getId());
			i.setItem(f);
			invoiceDao.saveInvoiceItem(i);
		}
		invoiceDao.saveInvoice(invoice);
		
		//tx.commit();
		//session.close();
	}
}
