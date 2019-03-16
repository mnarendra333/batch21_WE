package com.pragim.hibappwithannotations.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibUtility {
	
	
	
	public static void closeSession(Session session){
		session.close();
	}
	
	public static SessionFactory getSessFactory(){
		
		
		Configuration configuration = new Configuration();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.configure().build();
		SessionFactory factory = configuration
				.buildSessionFactory(serviceRegistry);
		
		return factory;
	}

}
