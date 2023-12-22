package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class TestJdbcDemo1 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("My Driver loaded");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbc1", "root", "gaurav@123");
			System.out.println("Connection Established");
			/*
			 * Connection is an interface , which resides inside java.sql package
			 * 
			 * This is provides a methods by which we can commit and rollback transction in databse
			 * by invoke, setAutoCommit(boolean value) rollback()
			 * 
			 *  by using this connection object we can close the connection by invoke close()
			 *  
			 */
			
			// I want to crate one table in the databse
			//String  tableSqlQuery = "create table CustomerInfo(cust_id int primary key, cust_name varchar(40), cust_phone bigint, cust_address varchar(40), cust_email varchar(40))";
			
			// I have to create the object of the statement by invoking method of Connection
			
			// Statement createStatement();
			Statement stmt = con.createStatement();
			
//			int status = stmt.executeUpdate(tableSqlQuery);
//			System.out.println("table created");
			String choice = null;
			do {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter customer id");
			int cid = sc.nextInt();
			System.out.println("Enter customer name ");
			String name = sc.next();
			System.out.println("Enter customer phone");
			long phone = sc.nextLong();
//			int cid = (int)phone%1000;
			System.out.println("Enter customer Address");
			String address = sc.next();
			System.out.println("Enter email id");
			String mailId = sc.next();
			
			String insertQuery = "insert into customerinfo values("+cid+""+",'"+name+",'"+","+phone+""+",'"+address+"'"+",'"+mailId+"')";
			int status = stmt.executeUpdate(insertQuery);
			
			System.out.println("Enter your choice YES/yes");
			choice=sc.next();
			System.out.println("Congratulations !!!"+" "+name+" registred successfully");
			}while(!(choice.equalsIgnoreCase("No")));
		}catch(ClassNotFoundException | SQLException e) {
			System.out.println(e);
		}
	}
}