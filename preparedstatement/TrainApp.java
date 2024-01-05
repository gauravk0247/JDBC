package preparedstatement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import utility.JdbcUtil;

class Train {
	private int trainNumber;
	private String trainName;
	private String trainSource;
	private String trainDestination;
	private String trainStatus;
	private LocalDate trainRunningDate;
	private double trainPrice;
	public Train(int trainNumber, String trainName, String trainSource, String trainDestination, String trainStatus,
			LocalDate trainRunningDate, double trainPrice) {
		this.trainNumber = trainNumber;
		this.trainName = trainName;
		this.trainSource = trainSource;
		this.trainDestination = trainDestination;
		this.trainStatus = trainStatus;
		this.trainRunningDate = trainRunningDate;
		this.trainPrice = trainPrice;
	}
	public int getTrainNumber() {
		return trainNumber;
	}
	public String getTrainName() {
		return trainName;
	}
	public String getTrainSource() {
		return trainSource;
	}
	public String getTrainDestination() {
		return trainDestination;
	}
	public String getTrainStatus() {
		return trainStatus;
	}
	public LocalDate getTrainRunningDate() {
		return trainRunningDate;
	}
	public double getTrainPrice() {
		return trainPrice;
	}
	//@Override
//	public int compareTo(Train t) {
//		if()
//		return this.;
//	}
}
public class TrainApp {
	// This method will store the train details into DB train_table
	static Train addTrain(Train trainObj) {
		int status=0;
		try {
			Connection con = JdbcUtil.getConnectionWithDB();
			String insertQuery = "insert into train_table values(?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(insertQuery);
			ps.setInt(1, trainObj.getTrainNumber());
			ps.setString(2, trainObj.getTrainName());
			ps.setString(3, trainObj.getTrainSource());
			ps.setString(4, trainObj.getTrainDestination());
			ps.setString(5, trainObj.getTrainStatus());
			// Fetching the localdate object from train object
			LocalDate ld = trainObj.getTrainRunningDate();
			// localdate object converting into java.sql.Date object
			java.sql.Date d1 = java.sql.Date.valueOf(ld);
			ps.setDate(6, d1);
			ps.setDouble(7, trainObj.getTrainPrice());
			
			status = ps.executeUpdate();

		}catch(Exception e) {
			System.out.println(e);
		}
		if(status>0) 
		{
			return trainObj;
		}
		else
		{
			return null;
		}
	}
		/*
		 * This method fetch all data from train_table
		 * It will construct train object base on given data from DB
		 * it will bind that train object with list object
		 * and finally we will return that list.
		 */
		/*static List<Train> viewAllTrain(){
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
		*/
		/*public static Set<Train> searchTrainByLocation(String src, String dest){
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
		}*/
		
		public static Train searchByNumber(int trainNumber) {
			Train tObj = null;
			try {
				Connection con = JdbcUtil.getConnectionWithDB();
				PreparedStatement ps = con.prepareStatement("select * from train_table where train_number=?");
				ps.setInt(1, trainNumber);

				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					int tno=rs.getInt(1);
					String tname = rs.getString(2);
					String source = rs.getString(3);
					String dest = rs.getString(4);
					String status1 = rs.getString(5);
					java.sql.Date d = rs.getDate(6);
					// Converting java.sql.Date type into LocalDate type
					LocalDate ld = d.toLocalDate();
					double price = rs.getDouble(7);
					tObj = new Train(tno, tname, source, dest, status1, ld, price);
				} 
			}catch(Exception e) {
				System.out.println(e);
			}
			return tObj;
		}
		
		public static int updateTrain(Train trainObj)
		{
			return 0;
		}
		public static void deleteTrain(int trainNumber)
		{
			
		}
	public static void main(String[] args) {
	// Calling addTrain(Train Object)
		// to call any method we need check the following
		/*
		 * 1. Whether the method is static or non-static
		 * 2. if static and if method in the same class then no need to create object we can 
		 * directly call the method.
		 * 3. If the static method in different class then we need call the method with the class name reference
		 * 4. if method non-static and if you invoke or call that method from any static method like main then we 
		 * 	must have to create the object that class to access.
		 * 5. Next we have check what is the type or what are the types of parameters, because we have call based on 
		 * appropriate parameter.
		 * 6. What is the return type of the method.
		 */
		Train train=new Train(2021, "Rajdhani Express", "Mumbai","new Delhi", "running", LocalDate.of(2021, 01, 13), 2000.00);
		Train t = addTrain(train);
		if(t!=null) {
			System.out.println(t.getTrainNumber()+" "+t.getTrainName()
			+" "+t.getTrainSource()+" "+t.getTrainDestination()+" "
					+t.getTrainStatus()+" "+t.getTrainRunningDate()+" "+t.getTrainPrice());
		}else {
			System.out.println("Not stored");
		}
		
		/*List<Train> resultlist = viewAllTrain();
		resultlist.forEach(t1->System.out.println(t1.getTrainNumber()+" "+t1.getTrainName()+" "+t1.getTrainSource()+" "+t1.getTrainDestination()+" "+t1.getTrainStatus()+" "+t1.getTrainRunningDate()+" "+t1.getTrainPrice()));
		*/
		
		/*Set<Train> resultlist1 = searchTrainByLocation("Mumbai", "New Delhi");
		resultlist1.forEach(t1->System.out.println(t1.getTrainNumber()+" "+t1.getTrainName()+" "+t1.getTrainSource()+" "+t1.getTrainDestination()+" "+t1.getTrainStatus()+" "+t1.getTrainRunningDate()+" "+t1.getTrainPrice()));
*/
//		Train t1 = searchByNumber(2023);
//		System.out.println(t1.getTrainNumber()+" "+t1.getTrainName()+" "+t1.getTrainSource()+" "+t1.getTrainDestination()+" "+t1.getTrainStatus()+" "+t1.getTrainRunningDate()+" "+t1.getTrainPrice());

	}
}


// update Train_Table set train_price=6000, train_source='Nashik' where train_number=2023;