package preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import utility.JdbcUtil;

public class TestJdbcDemo2 {

	public static void main(String[] args) throws ParseException, SQLException {
		Connection con = JdbcUtil.getConnectionWithDB();
		// reading inputs to store into order table
		/*Scanner sc = new Scanner(System.in);
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
		}*/
		
		String fetchQury = "select cust.cust_name , cust.cust_phone, cust.cust_address, myorder.order_name from customerinfo cust JOIN Customer_Order myorder on cust.cust_id=myorder.cust_id where myorder.order_name=?";
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter order name");
		String name = sc.next();
		PreparedStatement ps = con.prepareStatement(fetchQury);
		ps.setString(1, name);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			String name1 = rs.getString(1);
			long ph = rs.getLong(2);
			String address = rs.getString(3);
			System.out.println(name1+"\t"+ph+"\t"+address);
			
		}
	}

}
