package com.pragim.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class PreparedstmtDemo {

	public static void main(String[] args) {
		
		try {
			Connection connection = ConnectionUtility.getConnectionFromOracle();
			PreparedStatement pstmt = connection.prepareStatement("insert into empl values(?,?,?)");
			Scanner sc = new Scanner(System.in);
			int countRec = 0;
			
			for (int i = 1; i <=5; i++) {
				System.out.println("enter "+i+"  record id/name/saal");
				int id = sc.nextInt();
				String name = sc.next();
				int sal = sc.nextInt();
				pstmt.setInt(1, id);
				pstmt.setString(2, name);
				pstmt.setInt(3, sal);
				
				int count = pstmt.executeUpdate();
				if(count>0)
					countRec++;
				System.out.println(count);
			}
			
			System.out.println(countRec+" inserted");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
