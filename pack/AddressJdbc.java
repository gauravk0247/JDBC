package pack;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import utility.JdbcUtil;

public class AddressJdbc {

	public static void main(String[] args) throws SQLException {
		Connection con = JdbcUtil.getConnectionWithDB();
		Statement stmt = con.createStatement();
		Scanner sc = new Scanner(System.in);
		ResultSet rs = stmt.executeQuery("select * from customerinfo where cust_address='Nashik' or cust_address='Pune'");
		System.out.println(rs);
		while(rs.next()) {
			int id = rs.getInt(1);
			String name=rs.getString(2);
			long ph =rs.getLong(3);
			String addr=rs.getString(4);
			String email=rs.getString(5);
			System.out.println(id+" "+name+" "+ph+" "+addr+" "+email);
			}
	}
}