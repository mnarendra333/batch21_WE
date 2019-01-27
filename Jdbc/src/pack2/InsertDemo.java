package pack2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// step-1

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521", "system", "system");
			Statement stmt = connection.createStatement();
			System.out.println(stmt.getClass());
			int count = stmt.executeUpdate("select count(*) from empl");
			if(count>0)
				System.out.println(count+" rows effected");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
