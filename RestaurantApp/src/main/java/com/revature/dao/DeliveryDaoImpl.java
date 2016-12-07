package com.revature.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.beans.ContactInfo;
import com.revature.util.HibernateUtil;

public class DeliveryDaoImpl implements DeliveryDao {

	private Session session;
	@Override
	@RequestMapping(value = "/addContactInfo", method = RequestMethod.POST)
	public @ResponseBody ContactInfo saveContactInfo(@RequestBody ContactInfo ci) {
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
