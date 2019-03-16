package com.pragim.hibappwithannotations;

import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import com.pragim.hibappwithannotations.model.Person;
import com.pragim.hibappwithannotations.util.HibUtility;

public class BulkOpsClient {

	public static void main(String[] args) {

		Configuration configuration = new Configuration();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.configure().build();
		SessionFactory factory = configuration
				.buildSessionFactory(serviceRegistry);
		Session session = factory.openSession();

		Transaction tx = session.beginTransaction();

		// full object selection
		Query query = session.createQuery("select p from Person p");
		List<Person> list = query.list();
		for (Person person : list) {
			System.out.println(person);
		}
		// partial object selection
		Query query2 = session
				.createQuery("select p.perName,p.addr from Person p");
		List<Object[]> list2 = query2.list();

		for (Object[] objects : list2) {
			System.out.println(objects[0] + " " + objects[1]);
		}
		// single property selection
		Query query3 = session.createQuery("select p.perId from Person p");
		List<Integer> list3 = query3.list();
		System.out.println(list3.getClass());
		for (Integer string : list3) {
			System.out.println(string);
		}

		// query with where condition
		Query query4 = session
				.createQuery("select p from Person p where p.perId=:perId");
		List list4 = query4.setParameter("perId", 2).list();
		System.out.println(list4);

		Query query5 = session
				.createQuery("select p from Person p where p.perId=?0");
		List list5 = query5.setParameter(0, 2).list();
		System.out.println(list5);

		int executeUpdate = session
				.createQuery("delete from Person p where p.perId=?0")
				.setParameter(0, 2).executeUpdate();
		System.out.println(executeUpdate);

		Query query6 = session
				.createQuery("delete from Person p where p.perId in ?0");
		query6.setParameterList(0, Arrays.asList(1, 3)).
		executeUpdate();
		
		
		NativeQuery createSQLQuery = session.createSQLQuery("select * from person");
		tx.commit();
		HibUtility.closeSession(session);
		// session.beginTransaction().commit();
	}

}
