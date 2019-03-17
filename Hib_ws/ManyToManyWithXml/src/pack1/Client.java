package pack1;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		SessionFactory factory = new Configuration().configure("hib.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		
		Transaction beginTransaction = session.beginTransaction();
		Course c1 = new Course();
		c1.setCourseName("JAVA");
		c1.setDuration(100);
		
		Course c2 = new Course();
		c2.setCourseName("HTML");
		c2.setDuration(30);
		
		Course c3 = new Course();
		c3.setCourseName("Angular");
		c3.setDuration(60);
		
		
		Set<Course> courseList = new HashSet<Course>();
		courseList.add(c1);
		courseList.add(c2);
		courseList.add(c3);
		
		Student stu  =new Student();
		stu.setStuName("Surya");
		stu.setMarks(100);
		stu.setCourseList(courseList);
		
		
		session.saveOrUpdate(stu);
		beginTransaction.commit();
		
		session.close();
		

	}

}
