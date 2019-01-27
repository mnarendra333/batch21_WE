package com.pragim.crud;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class EmplDeemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		try {
			
			
			Connection conn = ConnectionUtility.getConnectionFromOracle();
			
			Statement stmt = conn.createStatement();
			
			Scanner sc  =new Scanner(System.in);
			System.out.println("Enter emp info");
			System.out.println("enter name");
			String name = sc.next();
			System.out.println("enter emp no");
			int empNo = sc.nextInt();
			int count = stmt.executeUpdate("update empl set name='"+name+"' where id='"+empNo+"'");
			if(count>0)
				System.out.println(count+" rows effected");
		} catch (Exception e) {
				e.printStackTrace();
		}
	}

}
