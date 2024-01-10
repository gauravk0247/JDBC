package tourpacakage;

import java.io.BufferedReader;
import java.io.File;
import java.io.Reader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import utility.JdbcUtil;

public class MyTourPackage {
	static List<Package> addPackageData(){
		List<Package> list = new ArrayList();
		try {
			Connection con = JdbcUtil.getConnectionWithDB();
			PreparedStatement ps = con.prepareStatement("insert into train_table values(?, ?, ?, ?, ?)");
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
	public static void main(String[] args) throws NumberFormatException, IOException {
		File file = new File("./src/TourPackage.txt");
		Reader reader = new FileReader(file);
		BufferedReader br = new BufferedReader(reader);
		String line = null;
		
		List<Package> list = new ArrayList();
		while((line=br.readLine())!=null) {
			String[] str = line.split(",");
			String pID = str[0];
			String source = str[1];
			String dest = str[2];
			int nDay = Integer.parseInt(str[3]);
			double cost = Double.parseDouble(str[4]);
			Package pack = new  Package(pID, source, dest, nDay, cost);
			System.out.println(pack.getPackageId()+" "+pack.getSource()+" "+pack.getDestination()+" "+pack.getNod()+" "+pack.getPackageCost());
			List<Package> resultlist = addPackageData();
		}
//		List<Package> resultlist = addPackageData();
//		resultlist.forEach(t1->System.out.println(t1.getPackageId()+" "+t1.getSource()+" "+t1.getDestination()+" "+t1.getNod()+" "+t1.getPackageCost()));
		
	}
}