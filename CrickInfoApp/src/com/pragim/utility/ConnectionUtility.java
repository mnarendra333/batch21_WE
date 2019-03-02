package com.pragim.utility;



import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionUtility {

	public static String[] getConnectionProperties() {

		// step-1
		Properties props = new Properties();
		try {
			props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("conn.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		String driverClass = props.getProperty("driver");
		String url = props.getProperty("url");
		String username = props.getProperty("username");
		String password = props.getProperty("password");

		String[] data = { driverClass, url, username, password };
		return data;
	}

	public static Connection getConnectionFromOracle() {

		String[] connprop = getConnectionProperties();
		Connection connection = null;
		try {
			Class.forName(connprop[0]);
			connection = DriverManager.getConnection(connprop[1], connprop[2],
					connprop[3]);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return connection;
	}

}
