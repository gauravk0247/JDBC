package pack;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TestJdbcDemo2 {

	public static void main(String[] args) throws IOException{
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("My Driver is loaded");
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbc1", "root", "gaurav@123");
		System.out.println("Connection Established");
		
		Statement stmt = con.createStatement();
		
		File fis = new File("./src/Data.txt");
		Reader reader = new FileReader(fis);
		BufferedReader br = new BufferedReader(reader);
		String line = null;
		while((line=br.readLine()) !=null) {
			String[] str = line.split(",");
			int cid = Integer.parseInt(str[0]);
			String name = str[1];
			double phone = Double.parseDouble(str[2]);
			String address = str[3];
			String mailId = str[4];
			String insertQuery = "insert into customerinfo values("+cid+""+",'"+name+",'"+","+phone+""+",'"+address+"'"+",'"+mailId+"')";
			int status = stmt.executeUpdate(insertQuery);
		}
		
		}catch(NumberFormatException | FileNotFoundException | ClassNotFoundException | SQLException e) {
			System.out.println(e);
		}
	}
}