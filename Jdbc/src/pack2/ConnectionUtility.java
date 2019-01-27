package pack2;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionUtility {

	public static Connection getConnectionFromOracle() {

		Properties props = getConnectionProps();
		Connection  connection = null;
		try {
			Class.forName(props.getProperty("driver"));
			connection= DriverManager.getConnection(props.getProperty("url"), props.getProperty("username"), props.getProperty("password"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return connection;
	}

	private static Properties getConnectionProps() {

		Properties props = new Properties();
		try {
			FileInputStream fis = new FileInputStream("conn.properties");
			props.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return props;
	}

	public static void main(String[] args) {

		getConnectionProps();

	}

}
