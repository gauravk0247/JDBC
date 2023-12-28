package pack;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utility.JdbcUtil;

public class TestResultSetDemo6 {

	public static void main(String[] args) throws SQLException {
		Connection con = JdbcUtil.getConnectionWithDB();
		Statement stmt =  con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ResultSet rs = stmt.executeQuery("Select * from customerinfo");
		rs.absolute(3);
		// For updating
		//rs.updateLong("cust_phone", 12345);
		//rs.updateLong(3, 1234567890);
		//rs.updateRow();
		
		// For deleting
		//rs.deleteRow();
	}
}