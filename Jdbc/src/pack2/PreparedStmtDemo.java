package pack2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class PreparedStmtDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		try {
			
			Connection connection = ConnectionUtility.getConnectionFromOracle();
			
			PreparedStatement pstmt = connection.prepareStatement("insert into empl values(?,?,?)");
			System.out.println(pstmt.getClass());
			Scanner sc = new Scanner(System.in);
			
			int countRec=0;
			for (int i = 1; i <=5; i++) {
				
				System.out.println("Enter emp data - id/name/sal");
				pstmt.setInt(1, sc.nextInt());
				pstmt.setString(2, sc.next());
				pstmt.setInt(3, sc.nextInt());
				
				int count = pstmt.executeUpdate();
				System.out.println(count+" rows inserted");
				if(count>0)
					countRec++;
			}
			System.out.println(countRec+" inserted");
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
