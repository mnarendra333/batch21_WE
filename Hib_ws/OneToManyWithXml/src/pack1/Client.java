package pack1;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory factory = new Configuration().configure("hib.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		
		
		//prepare customer data
		Customer c1 = new Customer();
		c1.setCustName("Capgemini");
		c1.setAddr("bangl");
		
		Customer c2 = new Customer();
		c2.setCustName("Hp");
		c2.setAddr("pune");
		
		
		Customer c3 = new Customer();
		c3.setCustName("TCS");
		c3.setAddr("bangl");
		
		
		Set<Customer> custList = new HashSet<Customer>();
		custList.add(c1);
		custList.add(c2);
		custList.add(c3);
		
		
		//prepare parent
		
		Vendor vobj = new Vendor();
		vobj.setVenName("CISCO");
		vobj.setCustList(custList);
		
		
		session.persist(vobj);
		
		session.beginTransaction().commit();
		
		
		
		
	}

}
