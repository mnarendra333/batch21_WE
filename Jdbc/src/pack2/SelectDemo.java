package pack2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class SelectDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		try {
			Connection connection= ConnectionUtility.getConnectionFromOracle();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from empl");
			ResultSetMetaData metaData = rs.getMetaData();
			System.out.println(metaData.getColumnCount());
			for (int i = 1; i <= metaData.getColumnCount(); i++) {
				System.out.print(metaData.getColumnName(i)+" ");
			}
			System.out.println();
			
			while (rs.next()) {
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getInt(3));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
