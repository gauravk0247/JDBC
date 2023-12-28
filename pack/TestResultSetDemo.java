package pack;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utility.JdbcUtil;

public class TestResultSetDemo {

	public static void main(String[] args) throws SQLException {
		Connection con = JdbcUtil.getConnectionWithDB();
		// Statement createStatement(int, int) throws SQlException
		// first contant is specifying the type of ResultSet
		// that can be either ResultSet.TYPE_SCROLL_SENSETIVE or
		// ResultSet.TYPE.SCROLL_INSENSETIVE
		// and then constant specifying the mode of the Result Set
		// mode can either CONCUR_READ_ONLY or CONCUR_UPDATEABLE
//		Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = stmt.executeQuery("Select * from customerinfo");
		System.out.println("*********Printing and fetching the records in forward direction*********");
		while(rs.next()) {
			int id = rs.getInt(1);
			String name=rs.getString(2);
			long ph =rs.getLong(3);
			String addr=rs.getString(4);
			String email=rs.getString(5);
			System.out.println(id+" "+name+" "+ph+" "+addr+" "+email);
			}
		/*System.out.println("------------------------------------------------");
		System.out.println("*********fetching the records in backward direction*********");
		while(rs.previous()) {
			int id = rs.getInt(1);
			String name=rs.getString(2);
			long ph =rs.getLong(3);
			String addr=rs.getString(4);
			String email=rs.getString(5);
			System.out.println(id+" "+name+" "+ph+" "+addr+" "+email);
			}*/
		System.out.println("fetching absulate record by passing ");
		rs.absolute(3);
		System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getLong(3)+" "+rs.getString(4));
		
		System.out.println("Fetching last record");
		rs.last();
		System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getLong(3)+" "+rs.getString(4)+" "+rs.getString(5));
		
		System.out.println("Fetching first record");
		rs.first();
		System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getLong(3)+" "+rs.getString(4)+" "+rs.getString(5));
		
		System.out.println("Fetching relative record");
		rs.relative(4);
		System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getLong(3)+" "+rs.getString(4)+" "+rs.getString(5));
	}
}