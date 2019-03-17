package com.pragim.onetomanywithannotations;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pragim.onetomanywithannotations.model.Customer;
import com.pragim.onetomanywithannotations.model.Vendor;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		
		
		//prepare customer data
		Customer c1 = new Customer();
		c1.setCustName("Capgemini1");
		c1.setAddr("bangl");
		
		Customer c2 = new Customer();
		c2.setCustName("Hp1");
		c2.setAddr("pune");
		
		
		Customer c3 = new Customer();
		c3.setCustName("TCS1");
		c3.setAddr("bangl");
		
		
		Set<Customer> custList = new HashSet<Customer>();
		custList.add(c1);
		custList.add(c2);
		custList.add(c3);
		
		
		//prepare parent
		
		Vendor vobj = new Vendor();
		vobj.setVenName("Altisource");
		vobj.setCustList(custList);
		
		
		session.persist(vobj);
		
		session.beginTransaction().commit();
    }
}
