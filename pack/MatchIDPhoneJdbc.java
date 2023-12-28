package pack;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import utility.JdbcUtil;

public class MatchIDPhoneJdbc {

	public static void main(String[] args) throws SQLException {
		Connection con = JdbcUtil.getConnectionWithDB();
		Statement stmt = con.createStatement();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your id");
		int id1 = sc.nextInt();
		System.out.println("Enter your phone number");
		long ph1 = sc.nextLong();
		ResultSet rs = stmt.executeQuery("SELECT * FROM customerinfo WHERE cust_id ="+id1+" AND cust_phone ="+ph1+"");
	//	System.out.println(rs);
		if(rs.next()) {
			int id = rs.getInt(1);
			/*String name=rs.getString(2);
			long ph =rs.getLong(3);
			String addr=rs.getString(4);
			String email=rs.getString(5);
			if(id==id1 && ph==ph1) {
				System.out.println(id+" "+name+" "+ph+" "+addr+" "+email);				
			}
			else {
				System.out.println("Not match any data");
			}*/
			System.out.println(id +""+" is valid user");
		}else
		{
			System.out.println("not able to login");
		}
	}
}
