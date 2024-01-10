package resultsetmetadata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import utility.JdbcUtil;

public class TestResultSetMetaData {

	public static void main(String[] args) throws SQLException {
		try(Connection con = JdbcUtil.getConnectionWithDB();){
			PreparedStatement ps = con.prepareStatement("select * from BankAccount");
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData mtdt = rs.getMetaData();
			System.out.println(mtdt.getColumnCount());
			System.out.println(mtdt.getColumnName(2));
			System.out.println(mtdt.getColumnTypeName(3));
			System.out.println(mtdt.getTableName(3));
			System.out.println(mtdt.getColumnClassName(3));
			System.out.println(mtdt.getColumnDisplaySize(4));
		}
	}
}