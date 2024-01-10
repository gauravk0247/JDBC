package callablestatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.JDBCType;
import java.sql.SQLException;
import java.util.Scanner;

import utility.JdbcUtil;

public class TestCallableDemo4 {

	public static void main(String[] args) throws SQLException {
		try(Connection con = JdbcUtil.getConnectionWithDB();
				Scanner sc = new Scanner(System.in);)
		{
			String query = "{call deleteById(?)}";
			CallableStatement csmt = con.prepareCall(query);
			System.out.println("Enter a value for input paramater1");
			int param1 = sc.nextInt();
			csmt.setInt(1, param1);
			csmt.executeUpdate();
			
			System.out.println("Delete Successfully");
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}