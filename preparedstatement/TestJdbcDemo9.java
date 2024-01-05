package preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Scanner;

import utility.JdbcUtil;

public class TestJdbcDemo9 {
	// Delete train data from the our databse
	public static Train fetchTrainWithMaxPrice()
	{ 
		Train tObj = null;
		try {
			Connection con = JdbcUtil.getConnectionWithDB();
			PreparedStatement ps = con.prepareStatement("select * from Train_Table where train_price=(select max(train_price) from Train_Table)");
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				int tno=rs.getInt(1);
				String tname = rs.getString(2);
				String source = rs.getString(3);
				String dest = rs.getString(4);
				String status1 = rs.getString(5);
				java.sql.Date d = rs.getDate(6);
				LocalDate ld = d.toLocalDate();
				double price = rs.getDouble(7);
				tObj = new Train(tno, tname, source, dest, status1, ld, price);			
			} 
		
		}catch(Exception e) {
			System.out.println(e);
		}
		return tObj;
	}
	public static void main(String[] args) {
		Train t1 = fetchTrainWithMaxPrice();
//		System.out.println(t1.getTrainPrice());
		System.out.println(t1.getTrainNumber()+" "+t1.getTrainName()+" "+t1.getTrainSource()+" "+t1.getTrainDestination()+" "+t1.getTrainStatus()+" "+t1.getTrainRunningDate()+" "+t1.getTrainPrice());
	}
}

// public static Map<Double, Train> 
//{}