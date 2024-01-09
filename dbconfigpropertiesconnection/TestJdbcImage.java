package dbconfigpropertiesconnection;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import utility.JdbcUtil;

public class TestJdbcImage {

	public static void main(String[] args) throws SQLException {
		// try Resource
		try(FileOutputStream fout = new FileOutputStream("C://Users//91800//Downloads//newGenerate.png");
				Connection con = JdbcUtil.getConnectionWithDB();
				Scanner sc = new Scanner(System.in);
				)
		{
//		Connection con = JdbcUtil.getConnectionWithDB();
		String sqlQuery = "Select p_photo from product where p_id=?";
		PreparedStatement ps = con.prepareStatement(sqlQuery);
//		Scanner sc = new Scanner(System.in);
		System.out.println("Enter product id");
		int id = sc.nextInt();
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		//FileOutputStream fout = new FileOutputStream("C://Users//91800//Downloads//newGenerate.png");
		if(rs.next()) {
			byte[] imageArray = rs.getBytes(1);
			fout.write(imageArray);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}