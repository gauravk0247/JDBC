package preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import utility.JdbcUtil;

public class TestJdbcDemo4 {
	public static Set<Train> searchTrainByLocation(String src, String dest){
	Set<Train> setTrain = new HashSet();
	try {
		Connection con = JdbcUtil.getConnectionWithDB();
		PreparedStatement ps = con.prepareStatement("select * from train_table where train_source=? and train_destination=?");
		ps.setString(1, src);
		ps.setString(2, dest);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			int tno=rs.getInt(1);
			String tname = rs.getString(2);
			String source = rs.getString(3);
			String dest1 = rs.getString(4);
			String status1 = rs.getString(5);
			java.sql.Date d = rs.getDate(6);
			// Converting java.sql.Date type into LocalDate type
			LocalDate ld = d.toLocalDate();
			double price = rs.getDouble(7);
			Train tObj = new Train(tno, tname, source, dest, status1, ld, price);
			setTrain.add(tObj);
		} 
	}catch(Exception e) {
		System.out.println(e);
	}
	return setTrain;
}
	public static void main(String[] args) {
		Set<Train> resultlist1 = searchTrainByLocation("Nashik", "New Delhi");
		resultlist1.forEach(t1->System.out.println(t1.getTrainNumber()+" "+t1.getTrainName()+" "+t1.getTrainSource()+" "+t1.getTrainDestination()+" "+t1.getTrainStatus()+" "+t1.getTrainRunningDate()+" "+t1.getTrainPrice()));
	}
}