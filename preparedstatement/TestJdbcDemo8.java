package preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Scanner;

import utility.JdbcUtil;

public class TestJdbcDemo8 {
	// Delete train data from the our databse
	public static void deleteTrain(int trainNumber)
	{
		int rs=0;
		try {
			Connection con = JdbcUtil.getConnectionWithDB();
			PreparedStatement ps = con.prepareStatement("delete from Train_Table where train_number=?");
			ps.setInt(1, trainNumber);
			rs = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println(e);
		}
		
		if(rs>0){
			System.out.println("Delete Successfully");
		}
		else {
			System.out.println("Not deleted");
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a train Number");
		int tid = sc.nextInt();
		deleteTrain(tid);
	}
}