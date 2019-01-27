package com.pragim.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		try {
			
			Class.forName("oracle.jdbc.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521", "system", "system");
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from empl");
		
			while(rs.next()){
				System.out.println(rs.getString(1)+" "+rs.getInt(2));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
