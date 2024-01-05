package preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import utility.JdbcUtil;

public class TestJdbcDemo3 {

	public static void main(String[] args) throws ParseException, SQLException {
		Connection con = JdbcUtil.getConnectionWithDB();
		// reading inputs to store into order table
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the order id");
		int oId = sc.nextInt();
		
		System.out.println("Enter the order name");
		String oName = sc.next();
		
		System.out.println("Enter the order date");
		String od = sc.next();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date orderDate = sdf.parse(od);
		
		java.sql.Date order_date = new java.sql.Date(orderDate.getTime());
		System.out.println("Enter existing customer id");
		int cId = sc.nextInt();
		
		String orderInsertQuery = "insert into Customer_Order values (?, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(orderInsertQuery);
		
		ps.setInt(1, oId);
		ps.setString(2, oName);
		ps.setDate(3, order_date);
		ps.setInt(4, cId);
		int status = ps.executeUpdate();
		if(status>0) {
			System.out.println("Congratulation!! you maked order");
		}else {
			System.out.println("try again....");
		}
	}

}
