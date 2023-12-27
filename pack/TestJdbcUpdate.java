package pack;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import utility.JdbcUtil;

public class TestJdbcUpdate {

	public static void main(String[] args) throws SQLException {
		// Update phone number and address customerInfo table
		// First we will established the connection
		Connection con = JdbcUtil.getConnectionWithDB();
		// Now we can able to create the object of statement
		Statement stmt = con.createStatement();
		Scanner s = new Scanner(System.in);
		System.out.println("Enter id to update");
		int id = s.nextInt();
		System.out.println("Enter new Phone number to update");
		long ph = s.nextLong();
		System.out.println("Enter new address to update");
		String addr = s.next();
		String updateQuery = "update customerinfo set cust_phone="+ph+", cust_address='"+addr+"' where cust_id="+id+"";
		int status = stmt.executeUpdate(updateQuery);
		if(status>0) {
			System.out.println("data updated successfully...");
		}else {
			System.out.println("Not updated");
		}
	}

}
