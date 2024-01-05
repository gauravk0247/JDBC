package pack;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import utility.JdbcUtil;

public class FindIDjdbc {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = JdbcUtil.getConnectionWithDB();
		Statement stmt = con.createStatement();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the customer id for the entire details of the customer");
		int id1 = sc.nextInt();
		ResultSet rs = stmt.executeQuery("select * from customerinfo where cust_id="+id1);
		System.out.println(rs);
		rs.next();
		int id = rs.getInt(1);
		String name=rs.getString(2);
		long ph =rs.getLong(3);
		String addr=rs.getString(4);
		String email=rs.getString(5);
		System.out.println(id+" "+name+" "+ph+" "+addr+" "+email);
		}
}