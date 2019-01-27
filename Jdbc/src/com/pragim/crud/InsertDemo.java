package com.pragim.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertDemo {

	public static void main(String[] args) {
		
		
		
			//step-1
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			//step-2 - get connection object
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
			System.out.println(connection.getClass());
			
			Statement stmt = connection.createStatement();
			int res = stmt.executeUpdate("update empl set sal=5000 where id=106");
			System.out.println(res + "records updataed");
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
