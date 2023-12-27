package pack;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import utility.JdbcUtil;

public class TestJdbcDelete {

	public static void main(String[] args) throws SQLException {
		// delete data
		// First we will established the connection
		Connection con = JdbcUtil.getConnectionWithDB();
		// Now we can able to create the object of statement
		Statement stmt = con.createStatement();
		Scanner s = new Scanner(System.in);
		System.out.println("Enter id to delete");
		int id = s.nextInt();
		String deleteQuery = "delete from customerinfo where cust_id="+id;
		int status = stmt.executeUpdate(deleteQuery);
		if(status>0) {
			System.out.println(id + " ID delete successfully...");
		}else {
			System.out.println("Not deleted data");
		}
	}

}
