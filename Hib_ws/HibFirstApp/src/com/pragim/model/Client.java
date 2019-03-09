package com.pragim.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//step-1
		
		Configuration config = new Configuration();
		config.configure("hib.cfg.xml");
		SessionFactory factory = config.buildSessionFactory();
		
		//step-2 ######## creating session ####### enable local cache
		Session session = factory.openSession();
		
		
		//step-3 ### prepare object and save
		Product pobj = new Product();
		//pobj.setProId(101);
		pobj.setProName("Dell-5040");
		pobj.setPrice(60000);
		
		session.save(pobj);
		Transaction tx = session.beginTransaction();
		tx.commit();

	}

}
