package tourpacakage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import utility.JdbcUtil;

public class MyTourFindMax {
	static List<Package> viewFetch(){
	List<Package> list = new ArrayList();
	try {
		Connection con = JdbcUtil.getConnectionWithDB();
		PreparedStatement ps = con.prepareStatement("select * from package_details order by cost desc");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			String pID=rs.getString(1);
			String source = rs.getString(2);
			String dest = rs.getString(3);
			int nDay = rs.getInt(4);
			Double cost = rs.getDouble(5);
			Package tObj = new Package(pID, source, dest, nDay, cost);
			list.add(tObj);	
		} 
	} 
	catch(Exception e) {
		System.out.println(e);
	} 
	return list;
} 
	public static void main(String[] args){
		List<Package> resultlist = viewFetch();
		resultlist.forEach(t1->System.out.println(t1.getPackageId()+" "+t1.getSource()+" "+t1.getDestination()+" "+t1.getNod()+" "+t1.getPackageCost()));
	}
}