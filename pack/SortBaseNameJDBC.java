package pack;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utility.JdbcUtil;

public class SortBaseNameJDBC {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = JdbcUtil.getConnectionWithDB();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from customerinfo order by cust_name;");
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