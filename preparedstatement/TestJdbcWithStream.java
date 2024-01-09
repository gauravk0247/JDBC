package preparedstatement;

import java.security.KeyStore.Entry;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import utility.JdbcUtil;

//class trainName implements Comparator<Train>{
//
//	public int compare(Train t1, Train t2) {
//		return t1.trainName.compareTo(t2.trainName);
//	}	
//}
public class TestJdbcWithStream {
	public static Map<Integer, Train> fetchTrainWithSortedOrder(){
		Map<Integer, Train> mObj  = new HashMap(); 
		try {
			Connection con = JdbcUtil.getConnectionWithDB();
			PreparedStatement ps = con.prepareStatement("select * from Train_Table");
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
				//Train tObj = new Train();
				mObj.put(tno, new Train(tno, tname, source, dest1, status1, ld, price));
				/*Set s = mObj.entrySet();
				Iterator i = s.iterator();
				while(i.hasNext()) {
					Map.Entry<Integer, Train> tr1 = (Map.Entry<Integer, Train>)i.next();
					int key= tr1.getKey();
					Train t = tr1.getValue();
					System.out.println(key+" "+t.getTrainNumber()+" "+t.getTrainName()+" "+t.getTrainSource()+" "+t.getTrainDestination()+" "+t.getTrainStatus()+" "+t.getTrainRunningDate()+" "+t.getTrainPrice());
				}	*/	
			} 
			Set s = mObj.entrySet();
			Iterator i = s.iterator();
			while(i.hasNext()) {
				Map.Entry<Integer, Train> tr1 = (Map.Entry<Integer, Train>)i.next();
				int key= tr1.getKey();
				Train t = tr1.getValue();
				System.out.println(key+" "+t.getTrainNumber()+" "+t.getTrainName()+" "+t.getTrainSource()+" "+t.getTrainDestination()+" "+t.getTrainStatus()+" "+t.getTrainRunningDate()+" "+t.getTrainPrice());
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return mObj;
	}
	public static void main(String[] args) {
		Map<Integer, Train> resultlist1 = fetchTrainWithSortedOrder();
	}
}