package com.pragim.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BatchDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//step1
		
		try {
			
			
			Class.forName("oracle.jdbc.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521", "system", "system");
			
			
			
			Statement stmt1 = connection.createStatement();
			stmt1.addBatch("insert into emp values(4,'raj')");
			stmt1.addBatch("update emp set name='kamal2' where id=1");
			stmt1.addBatch("delete from emp where id=3");
			
			
			int[] executeBatch = stmt1.executeBatch();
			for (int i : executeBatch) {
				System.out.println("rows effected "+i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
