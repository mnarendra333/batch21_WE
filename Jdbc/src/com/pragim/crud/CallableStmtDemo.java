package com.pragim.crud;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import java.util.Scanner;

public class CallableStmtDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		try {
			
			
			Connection connection = ConnectionUtility.getConnectionFromOracle();
			
			CallableStatement cstmt = connection.prepareCall("{call empl_exp(?,?,?)}");
			Scanner sc = new Scanner(System.in);
			System.out.println("enter emp no");
			cstmt.setInt(1, sc.nextInt());
			cstmt.registerOutParameter(2, Types.NVARCHAR);
			cstmt.registerOutParameter(3, Types.NUMERIC);
			
			
			cstmt.execute();
			
			
			System.out.println(cstmt.getString(2)+" "+cstmt.getInt(3));
		
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
