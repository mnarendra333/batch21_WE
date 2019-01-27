package com.pragim.crud;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class PlayerDemo {

	public static void main(String[] args) {
		try {

			Connection connection = ConnectionUtility.getConnectionFromOracle();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from player");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getInt(2) + " "
						+ rs.getString(3) + " " + rs.getString(4));
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
