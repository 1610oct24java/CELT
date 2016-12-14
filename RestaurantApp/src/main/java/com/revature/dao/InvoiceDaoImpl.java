package com.revature.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.revature.beans.Invoice;
import com.revature.beans.InvoiceItem;
import com.revature.util.HibernateUtil;

@Component
public class InvoiceDaoImpl implements InvoiceDao {
	
	@Override
	public void saveInvoice(Invoice invoice) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		session.save(invoice);
		tx.commit();
		session.close();
	}

	@Override
	public void saveInvoiceItem(InvoiceItem i) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		try{
			session.save(i);
			tx.commit();
		} finally {
			session.close();
		}
	}

}
