package com.pragim.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Client2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		SessionFactory factory = config.buildSessionFactory();
		
		//step-2 ######## creating session ####### enable local cache
		Session session = factory.openSession();
		
		
		Product pro1 = (Product)session.load(Product.class, 2);
		System.out.println(pro1.getProName());
		Product pro2 = (Product)session.load(Product.class, 2);
		System.out.println(pro2.getProName());
		session.close();
		
		
		try {
			System.out.println("Waiting");
			Thread.sleep(4000);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		Session session2 = factory.openSession();
		Product pro3 = (Product)session2.load(Product.class, 2);
		System.out.println(pro3.getProName());

	}

}
