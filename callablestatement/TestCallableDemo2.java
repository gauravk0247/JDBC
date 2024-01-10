package callablestatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.Scanner;

import utility.JdbcUtil;

public class TestCallableDemo2 {

	public static void main(String[] args) {
		try(Connection con = JdbcUtil.getConnectionWithDB();
				Scanner sc = new Scanner(System.in);) {
			String query = "{call addAccount(?,?,?,?,?)}";
			CallableStatement csmt = con.prepareCall(query);
			System.out.println("Enter account number");
			int acn = sc.nextInt();
			csmt.setInt(1, acn);
			System.out.println("Enter customer name");
			String name = sc.next();
			csmt.setString(2, name);
			System.out.println("Enter customer phone");
			long ph = sc.nextLong();
			csmt.setLong(3, ph);
			System.out.println("Enter customer address");
			String add = sc.next();
			csmt.setString(4, add);
			System.out.println("Enter the balance");
			double balance = sc.nextDouble();
			csmt.setDouble(5, balance);
			
			csmt.execute();
			System.out.println("data inserted");
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}