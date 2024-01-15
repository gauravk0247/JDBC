package crudoperation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import utility.JdbcUtil;

public class CRUDOperation {

	public static void main(String[] args) throws SQLException {
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Your Choice For Operation");
		System.out.println("Enter 1 for insert Operation ");
		System.out.println("Enter 2 for read operation");
		System.out.println("Enter 3 for update operation");
		System.out.println("Enter 4 for delete operation");
		int choice = s.nextInt();
		switch (choice) {
		case 1:
			Connection con = JdbcUtil.getConnectionWithDB();
			String insertQuery = "insert into customerinfo values(?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(insertQuery);
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter customer ID");
			int cID = sc.nextInt();
			System.out.println("Enter customer Name");
			String cName = sc.next();
			System.out.println("Enter customer phone");
			long ph = sc.nextLong();
			System.out.println("Enter customer Address");
			String addr = sc.next();
			System.out.println("Enter customer Email");
			String email = sc.next();
			ps.setInt(1, cID);
			ps.setString(2, cName);
			ps.setLong(3, ph);
			ps.setString(4, addr);
			ps.setString(5, addr);
			int status = ps.executeUpdate();
			if(status>0){
				System.out.println("Data is inserted");
			}else {
				System.out.println("Not inseted! Try Again");
			}
			break;

		case 2:
			Connection con1 = JdbcUtil.getConnectionWithDB();
			PreparedStatement ps1 = con1.prepareStatement("select * from customerinfo");
			ResultSet rs = ps1.executeQuery();
			while(rs.next()) {
			int id = rs.getInt(1);
			String name = rs.getString(2);
			long phn = rs.getLong(3);
			String addrs = rs.getString(4);
			String emai = rs.getString(5);
			System.out.println(id+" "+name+" "+phn+" "+addrs+" "+emai);
			}
			break;
			
		case 3:
			Connection con2 = JdbcUtil.getConnectionWithDB();
			String updateQuery = "update customerinfo set cust_phone=?, cust_address=?,cust_email=? where cust_id=?";
			PreparedStatement ps2 = con2.prepareStatement(updateQuery);
			Scanner sc1 = new Scanner(System.in);
			System.out.println("Enter new Phone Number");
			long ph1 = sc1.nextLong();
			ps2.setLong(1, ph1);
			System.out.println("Enter new Address");
			String addr1 = sc1.next();
			ps2.setString(2, addr1);
			System.out.println("Enter new Email");
			String email1 = sc1.next();
			ps2.setString(3, email1);
			System.out.println("Enter Existing customer id");
			int eid = sc1.nextInt(); 
			ps2.setInt(4, eid);
			int status1 = ps2.executeUpdate();
			if(status1>0) {
				System.out.println("Updated successfully");
			}else {
				System.out.println("Not Updated");
			}
			break;
			
		case 4:
			try(Connection con3 = JdbcUtil.getConnectionWithDB();
					Scanner sc3 = new Scanner(System.in);) {
			PreparedStatement ps3 = con3.prepareStatement("delete from customerinfo where cust_id=?");
			System.out.println("Enter existing Customer Id to delete the data");
			int did = sc3.nextInt();
			ps3.setInt(1, did);
			int dupdate = ps3.executeUpdate();
			if(dupdate>0){
				System.out.println("Delete Successfully");
			}
			else{
				System.out.println("Not Deleted");
			}
			}catch(Exception e) {
				System.out.println(e);
			}
			break;
		default:
			System.out.println("Add More Operation");
			break;
		}		
	}
}