package pack1;

import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ClientForSelect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		SessionFactory factory = new Configuration().configure("hib.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		
		
		Vendor vendor = (Vendor)session.get(Vendor.class, 1);
		System.out.println(vendor.getVenId()+" "+vendor.getVenName());
		
		
		Set<Customer> custList = vendor.getCustList();
		
		Iterator<Customer> iterator = custList.iterator();
		while (iterator.hasNext()) {
			Customer customer =  iterator.next();
			if("Hp".equalsIgnoreCase(customer.getCustName()))
				iterator.remove();
			
		}
		
		session.beginTransaction().commit();
	}

}
