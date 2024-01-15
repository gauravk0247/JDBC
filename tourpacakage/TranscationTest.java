package tourpacakage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utility.JdbcUtil;

public class TranscationTest {

	public static void main(String[] args) throws SQLException {
		Connection con=null;
		try 
		{
			con = JdbcUtil.getConnectionWithDB();
		//con.setAutoCommit(false);
		Package p=new Package("1", "Kolkata", "Mumbai", 5, 5000.00);
		PreparedStatement ps = con.prepareStatement("insert into package_details values(?, ?, ?, ?, ?)");
		 ps.setString(1, p.getPackageId());
         ps.setString(2, p.getSource());
         ps.setString(3, p.getDestination());
         ps.setInt(4,p. getNod());
         ps.setDouble(5,p.getPackageCost());
         //ps.executeUpdate();
         
        con. commit();
        ps=con.prepareStatement("update package_details set source_location=? where package_id=?");
        ps.setString(1, "Pune");
        ps.setString(2, "1");
        //create , insert, update, delete 
        //executeUpdate() int
        ps.executeUpdate();
        //select or fetch query
        //executeQuery()---ResultSet
        con.commit();
        
        
		}catch(Exception e) {
//			System.out.println(e);
			con.rollback();
		}
	}
}