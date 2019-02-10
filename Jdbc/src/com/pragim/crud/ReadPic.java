package com.pragim.crud;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class ReadPic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
Connection connection = ConnectionUtility.getConnectionFromOracle();
		
		try {
			
			PreparedStatement pstmt = connection.prepareStatement("select emp_pic from emp where id=?");
			Scanner sc  =new Scanner(System.in);
			System.out.println("Enter:\n 1.Id \n 2.Name \n 3.Image");
			int eno = sc.nextInt();
			pstmt.setInt(1, eno);
			ResultSet rs = pstmt.executeQuery();
			FileOutputStream  fos = new FileOutputStream("target.jpg");
			if(rs.next()) {
				InputStream is = rs.getBinaryStream(1);
				int k;
				while ((k = is.read())!=-1) {
					fos.write(k);
				}
				System.out.println("file read is completed");
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}