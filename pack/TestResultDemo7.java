package pack;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utility.JdbcUtil;

public class TestResultDemo7 {

	public static void main(String[] args) throws SQLException, InterruptedException {
		Connection con = JdbcUtil.getConnectionWithDB();
		Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ResultSet rs = stmt.executeQuery("Select * from customerinfo");
		int counter=1;
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getLong(3)+" "+rs.getString(4)+" "+rs.getString(5));
			if(counter==2) {
				Thread.sleep(30000);
			}
			counter++;
		}
	}
}