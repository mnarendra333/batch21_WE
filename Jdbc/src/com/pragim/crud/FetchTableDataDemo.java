package com.pragim.crud;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Scanner;

public class FetchTableDataDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection connection  =null;
		try {
			
			Scanner sc = new Scanner(System.in);
			connection = ConnectionUtility.getConnectionFromOracle();			
			Statement pstmt = connection.createStatement();
			System.out.println("Enter Table name");
			String tableName = sc.next();
			
			
			ResultSet rs = pstmt.executeQuery("select * from "+tableName);
			
			
			ResultSetMetaData metaData = rs.getMetaData();
			
			for (int i = 1; i <=metaData.getColumnCount(); i++) {
				System.out.print(metaData.getColumnName(i)+"\t");
			}
			
			System.out.println();
			while (rs.next()) {
				for (int i = 1; i <=metaData.getColumnCount(); i++) {
					
					if(metaData.getColumnTypeName(i).equalsIgnoreCase("NUMBER"))
						System.out.print(rs.getInt(i)+"\t");
					else if(metaData.getColumnTypeName(i).equalsIgnoreCase("VARCHAR2"))
						System.out.print(rs.getString(i)+"\t");
					else if(metaData.getColumnTypeName(i).equalsIgnoreCase("DATE"))
						System.out.print(rs.getDate(i)+"\t");
				}
				System.out.println();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		finally{
			try {
				connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

}
