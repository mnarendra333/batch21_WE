package com.pragim.hibappwithannotations;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import com.pragim.hibappwithannotations.model.Person;
import com.pragim.hibappwithannotations.util.HibUtility;

public class CriteriaClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory sessFactory = HibUtility.getSessFactory();
		Session session = sessFactory.openSession();

		// select full object
		Criteria criteria = session.createCriteria(Person.class);
		List<Person> list = criteria.list();
		for (Person person : list) {
			System.out.println(person);
		}

		// select partial object
		ProjectionList projectionList = Projections.projectionList();
		projectionList.add(Projections.property("perName")).add(
				Projections.property("addr"));

		criteria.setProjection(projectionList);
		List<Object[]> list2 = criteria.list();
		for (Object[] objects : list2) {
			System.out.println(objects[0] + " " + objects[1]);
		}

		// single property selection
		List<String> list3 = criteria.setProjection(
				Projections.property("perName")).list();
		for (String string : list3) {
			System.out.println(string);
		}
	}

}
