package callablestatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.JDBCType;
import java.util.Scanner;

import utility.JdbcUtil;

public class TestCallableDemo3 {

	public static void main(String[] args) {
		try(Connection con = JdbcUtil.getConnectionWithDB();
				Scanner sc = new Scanner(System.in);)
		{
			String query = "{call fetchAccountDetailsByNumber(?,?,?,?)}";
			CallableStatement csmt = con.prepareCall(query);
			System.out.println("Enter account number to search");
			int acn = sc.nextInt();
			csmt.setInt(1, acn);
			csmt.setInt(1, acn);
			csmt.registerOutParameter(2, JDBCType.VARCHAR);
			csmt.registerOutParameter(3, JDBCType.VARCHAR);
			csmt.registerOutParameter(4, JDBCType.DOUBLE);
			
			csmt.execute();
			String name = csmt.getString(2);
			String city = csmt.getString(3);
			double balance = csmt.getDouble(4);
			System.out.println(name+" "+city+" "+balance);
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}