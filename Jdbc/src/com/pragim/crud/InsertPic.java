package com.pragim.crud;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertPic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Connection connection = ConnectionUtility.getConnectionFromOracle();
		
		try {
			
			PreparedStatement pstmt = connection.prepareStatement("insert into emp values(?,?,?)");
			Scanner sc  =new Scanner(System.in);
			System.out.println("Enter:\n 1.Id \n 2.Name \n 3.Image");
			int eno = sc.nextInt();
			String ename = sc.next();
			String imageLoc = sc.next();
			
			
			pstmt.setInt(1, eno);
			pstmt.setString(2, ename);
			
			File file = new File(imageLoc);
			long length = file.length();
			
			FileInputStream fis = new FileInputStream(file);
			pstmt.setBinaryStream(3, fis, length);
			
			int executeUpdate = pstmt.executeUpdate();
			if(executeUpdate>0)
				System.out.println(executeUpdate+" rows inserted");
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
