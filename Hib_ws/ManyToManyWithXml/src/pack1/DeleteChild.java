package pack1;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteChild {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory factory = new Configuration().configure("hib.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		
		Transaction beginTransaction = session.beginTransaction();
		
		
		List<Student> list = session.createQuery("from Student").list();
		for (Student student : list) {
			Set<Course> courseList = student.getCourseList();
			
			Iterator<Course> iterator = courseList.iterator();
			while (iterator.hasNext()) {
				Course course = iterator.next();
				if(student.getStuName().equalsIgnoreCase("Surya") &&
						course.getCourseName().equalsIgnoreCase("HTML")){
					iterator.remove();
				}
				
			}
		}
		
		beginTransaction.commit();

	}

}
