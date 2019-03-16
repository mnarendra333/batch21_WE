package com.pragim.hibappwithannotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.pragim.hibappwithannotations.model.Person;

public class ClientOnLoadAndGet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Configuration configuration = new Configuration();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure()
				.build();
		SessionFactory factory = configuration
				.buildSessionFactory(serviceRegistry);
		Session session = factory.openSession();

		
		
		//load method
		
		Person person = session.load(Person.class, 24);
		System.out.println(person.getAddr());
		
		Person person2 = session.get(Person.class, 25);
		System.out.println(person2.getAddr());

	}

}
