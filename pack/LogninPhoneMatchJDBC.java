package pack;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;

import utility.JdbcUtil;
class InvalidLoginException extends Exception{
	public InvalidLoginException(String errorMsg, Date date) {
		System.out.println(errorMsg+"\t"+date);
	}
}
public class LogninPhoneMatchJDBC {

	public static void main(String[] args) throws SQLException, InvalidLoginException {
		// I want to login customer with customerId as username  and customer phone as password
		// stwp -1 -- We have established connection
		Connection con = JdbcUtil.getConnectionWithDB();
		Statement stmt = con.createStatement();
		// Resultset are readable mode only and forward direction
		ResultSet rs = stmt.executeQuery("Select * from customerinfo");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your customer id");
		int id = sc.nextInt();
		System.out.println("Enter your phone as password");
		long ph = sc.nextLong();
		int flag=0;
		while(rs.next()) {
			int custid = rs.getInt(1);
			long phoneNum = rs.getLong(3);
			if(custid==id && phoneNum==ph) {
				flag=1;
				break;
			}
		}		
		if(flag==1) {
			System.out.println("Your are valid user");
			System.out.println("You can make order");
		}else {
			
			
			// we can throws user defined exception object
			//System.out.println("Not a valid user");
			throw new InvalidLoginException("Login Failed", new Date());
		}
		
	}
}