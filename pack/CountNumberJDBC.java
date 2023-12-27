package pack;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utility.JdbcUtil;

public class CountNumberJDBC {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = JdbcUtil.getConnectionWithDB();
		Statement stmt = con.createStatement();
		String countQuery = ("select count(cust_id) as total_cust_count from customerinfo");
		ResultSet rs = stmt.executeQuery(countQuery);
		if(rs.next()) {
			System.out.println("total customer in our system is "+""+rs.getInt(1));
		}
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