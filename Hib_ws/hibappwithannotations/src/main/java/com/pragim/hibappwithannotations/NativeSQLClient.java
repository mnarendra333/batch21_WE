package com.pragim.hibappwithannotations;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;

import com.pragim.hibappwithannotations.util.HibUtility;

public class NativeSQLClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory sessFactory = HibUtility.getSessFactory();
		Session session = sessFactory.openSession();
		
		NativeQuery nativeQry = session.createSQLQuery("select * from per_tab where p_name=?").setParameter(1, "raj");
		List<Object[]> list = nativeQry.list();
		for (Object[] objects : list) {
			System.out.println(objects[0]+" "+objects[1]+" "+objects[2]);
		}
		HibUtility.closeSession(session);
		
	}

}
