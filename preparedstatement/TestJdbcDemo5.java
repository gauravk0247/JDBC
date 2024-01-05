package preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import utility.JdbcUtil;

public class TestJdbcDemo5 {
	static List<Train> viewAllTrain(){
	List<Train> listOfTrain = new ArrayList();
	try {
		Connection con = JdbcUtil.getConnectionWithDB();
		PreparedStatement ps = con.prepareStatement("select * from train_table");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			int tno=rs.getInt(1);
			String tname = rs.getString(2);
			String source = rs.getString(3);
			String dest = rs.getString(4);
			String status1 = rs.getString(5);
			java.sql.Date d = rs.getDate(6);
			// Converting java.sql.Date type into LocalDate type
			LocalDate ld = d.toLocalDate();
			double price = rs.getDouble(7);
			Train tObj = new Train(tno, tname, source, dest, status1, ld, price);
			listOfTrain.add(tObj);
			
		} // ends of while loop
	} // ends of try block
	catch(Exception e) {
		System.out.println(e);
	} // ends of catch block
	return listOfTrain;
} // ends of method block
	public static void main(String[] args) {
		List<Train> resultlist = viewAllTrain();
		resultlist.forEach(t1->System.out.println(t1.getTrainNumber()+" "+t1.getTrainName()+" "+t1.getTrainSource()+" "+t1.getTrainDestination()+" "+t1.getTrainStatus()+" "+t1.getTrainRunningDate()+" "+t1.getTrainPrice()));
	}
}
