package com.pragim.hibappwithannotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.pragim.hibappwithannotations.model.Person;
import com.pragim.hibappwithannotations.util.HibUtility;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		// SessionFactory factory = new
		// Configuration().configure().buildSessionFactory();

		Configuration configuration = new Configuration();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure()
				.build();
		SessionFactory factory = configuration
				.buildSessionFactory(serviceRegistry);
		Session session = factory.openSession();

		Person obj = new Person();
		obj.setPerName("Surya");
		obj.setAddr("bangl");

		session.save(obj);
		session.beginTransaction().commit();
		HibUtility.closeSession(session);
	}
}
