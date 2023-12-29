package preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import utility.JdbcUtil;

// Demo program to execute parameterized using PreparedStatement
public class TestJdbcDemo1 {
	public static void main(String[] args) throws SQLException {
		// first we need established  connection
		Connection con = JdbcUtil.getConnectionWithDB();
		String insertQuery="insert into customerinfo values (?, ?, ?, ?, ?)";
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter customer Id");
		int id = sc.nextInt();
		System.out.println("Enter customer name");
		String name = sc.next();
		System.out.println("Enter customer phone number");
		long ph = sc.nextLong();
		System.out.println("Enter customer address");
		String addr = sc.next();
		System.out.println("Enter customer email");
		String emailId = sc.next();
		// Creating object of PreparedStatement
		PreparedStatement ps = con.prepareStatement(insertQuery);
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setLong(3, ph);
		ps.setString(4, addr);
		ps.setString(5, emailId);
		int status = ps.executeUpdate();
		if(status>0) {
			System.out.println("Data is inserted");
		}
		else {
			System.out.println("Data is Not inserted");
		}
	}
}