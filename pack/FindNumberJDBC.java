package pack;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import utility.JdbcUtil;

public class FindNumberJDBC {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = JdbcUtil.getConnectionWithDB();
		Statement stmt = con.createStatement();
		Scanner sc = new Scanner(System.in);
		ResultSet rs = stmt.executeQuery("select cust_name, cust_phone from customerinfo where cust_address='Nashik'");
		System.out.println(rs);
		rs.next();
		String name=rs.getString(1);
		long ph =rs.getLong(2);
		System.out.println(name+" "+ph);
		}
}