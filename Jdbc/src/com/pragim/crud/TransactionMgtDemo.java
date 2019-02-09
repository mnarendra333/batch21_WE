package com.pragim.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionMgtDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521", "system", "system");
			
			//step-1
			connection.setAutoCommit(false);
			Statement stmt1 = connection.createStatement();
			int executeUpdate = stmt1.executeUpdate("insert into emp values(8,'barath')");
			System.out.println(executeUpdate+" rows effected");
			
			
			Statement stmt2 = connection.createStatement();
			int executeUpdate2 = stmt2.executeUpdate("update emp set name='rajkumar1' where id=4");
			System.out.println(executeUpdate2+" rows effected");
			
			
			Statement stmt3 = connection.createStatement();
			int executeUpdate3 = stmt3.executeUpdate("delete from emp where id=4");
			System.out.println(executeUpdate3+" rows effected");
			//ACID
			
			connection.commit();
		} catch (Exception e) {
			
			try {
				connection.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			e.printStackTrace();
		}
		
		finally{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		

	}

}
