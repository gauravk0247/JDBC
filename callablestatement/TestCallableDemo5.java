package callablestatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.JDBCType;
import java.util.Scanner;

import utility.JdbcUtil;

public class TestCallableDemo5 {

	public static void main(String[] args) {
		try(Connection con = JdbcUtil.getConnectionWithDB();
				Scanner sc = new Scanner(System.in);)
		{
			String query = "{call calculateBill(?,?,?,?)}";
			CallableStatement csmt = con.prepareCall(query);
			System.out.println("Enter month");
			int mnth = sc.nextInt();
			csmt.setInt(1, mnth);
			System.out.println("Enter no_of_order");
			int no_of_order = sc.nextInt();
			csmt.setInt(2, no_of_order);
			
			System.out.println("Enter price");
			double price = sc.nextDouble();
			csmt.setDouble(3, price);
			// regiaster OUT parameter with JDBC type
			csmt.registerOutParameter(4, JDBCType.DOUBLE);
			csmt.execute();
			double balance = csmt.getDouble(4);
			
			System.out.println(balance);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}