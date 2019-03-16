package com.pragim.hibappwithannotations;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.pragim.hibappwithannotations.model.Person;
import com.pragim.hibappwithannotations.util.HibUtility;

public class CriteriaClient2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory sessFactory = HibUtility.getSessFactory();
		Session session = sessFactory.openSession();
		
		@SuppressWarnings("deprecation")
		Criteria criteria = session.createCriteria(Person.class);
		//List<Person> list = criteria.add(Restrictions.eq("addr", "hyd")).list();
		//System.out.println(list);
		criteria.setProjection(Projections.rowCount());
		System.out.println(criteria.uniqueResult());
		//and condition
		
	/*	Conjunction conjunction = Restrictions.conjunction();
		
		conjunction.add(Restrictions.eq("perName", "raj"));
		conjunction.add(Restrictions.eq("addr", "hyd")).;
		
		List<Person> list2 = criteria.add(conjunction).list();
		for (Person person : list2) {
			System.out.println(person);
		}*/
		HibUtility.closeSession(session);
	}

}
