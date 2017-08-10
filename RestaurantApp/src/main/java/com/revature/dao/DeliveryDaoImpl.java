package com.revature.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.revature.beans.ContactInfo;
import com.revature.util.HibernateUtil;

@Component
public class DeliveryDaoImpl implements DeliveryDao {

	private Session session;
	
	@Override
	public ContactInfo saveContactInfo(ContactInfo ci) {
		session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		System.out.println(ci.toString());
		int id = (Integer) session.save(ci);
		if(id<1){
			tx.rollback();
			ci = null;
		}else{
			tx.commit();
			ci.setId(id);
		}
		session.close();
		return ci;
	}

}
