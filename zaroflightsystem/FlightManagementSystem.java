package zaroflightsystem;

import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;
import java.util.function.Predicate;

public class FlightManagementSystem {
	public boolean addFlight(Flight flightObj) {
		int status = 0;
		try{
			Reader reader = new FileReader("./src/DBConfig.properties");
			Properties p = new Properties();
			p.load(reader);
			String driverName = p.getProperty("driver");
			String urlName = p.getProperty("url");
			String uname = p.getProperty("un");
			String pass = p.getProperty("pw");
			System.out.println(driverName+"\n"+urlName+"\n"+uname+"\n"+pass);
			Class.forName(driverName);
			Connection con = DriverManager.getConnection(urlName, uname, pass);
			System.out.println("Connection Established");
			
			PreparedStatement ps = con.prepareStatement("insert into Flight_Table values(?, ?, ?, ?, ?)");
			
			ps.setInt(1, flightObj.getFlightId());
			ps.setString(2, flightObj.getSource());
			ps.setString(3, flightObj.getDestination());
			ps.setInt(4, flightObj.getNoOfSeats());
			ps.setDouble(5, flightObj.getFlightFare());
			status=ps.executeUpdate();
			
			if(status>0) {
				System.out.println("inserted");
			}else {
				System.out.println("Not inserted");
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return true;
	}
	public static void main(String[] args) {
		Flight flight = new Flight(1005, "Pune", "Nashik", 45, 23000.00);
		FlightManagementSystem fms = new FlightManagementSystem();
		boolean status = fms.addFlight(flight);
		if(status) {
			System.out.println("Flight details added successfully");
		}else {
			System.out.println("Addition not done");
		}
		
//		Predicate<Flight> predicate = (flight1)->{
//			if(flight.equals(flight)) {
//				return true;
//			}
//			return false;
//		};
//		boolean status1 = fms.addFlight(flight);
//		if(status) {
//			System.out.println("Flight details added successfully");
//		}
//		else {
//			System.out.println("Addition not done");
//		}
	}
}