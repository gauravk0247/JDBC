package callablestatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.JDBCType;
import java.sql.SQLException;
import java.util.Scanner;

import utility.JdbcUtil;

public class TestCallableDemo1 {

	public static void main(String[] args) throws SQLException {
		try(Connection con = JdbcUtil.getConnectionWithDB();
				Scanner sc = new Scanner(System.in);)
		{
			String procedureCall1 = "{call multiply(?,?,?)}";
			CallableStatement csmt = con.prepareCall(procedureCall1);
			System.out.println("Enter a value for input paramater1");
			int param1 = sc.nextInt();
			System.out.println("Enter the value for input parameter2");
			int param2 = sc.nextInt();
			// setting value with In parameter
			csmt.setInt(1, param1);
			csmt.setInt(2, param2);
			
			// Fetching result from stored procedure in register with JDBC type
			csmt.registerOutParameter(3, JDBCType.INTEGER);
			
			// executing callable statement
			csmt.execute();
			
			// fetching result by getter method of callable Statement
			// in this case 3 parameter is the OUT parameter based on the procedure thats way we passed 3
			int result = csmt.getInt(3);
			// printing result
			System.out.println("Multiplication is "+" "+result);
		}
	}
}