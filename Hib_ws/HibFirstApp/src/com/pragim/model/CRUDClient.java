package com.pragim.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CRUDClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		//select
		Product pro = (Product)session.get(Product.class, 1);
		/*
		if(pro!=null)
			pro.setPrice(80000);
		
		//session.update(pro);
		session.beginTransaction().commit();
		System.out.println(pro);*/
		
		
		//delete
		
		if(pro!=null)
			session.delete(pro);
		session.beginTransaction().commit();
	}

}
