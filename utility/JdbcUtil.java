package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtil {
	public static Connection getConnectionWithDB() {
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbc1", "root", "gaurav@123");
		}catch(ClassNotFoundException | SQLException e){
			System.out.println(e);
		}
		return con;
	}
}