package resultsetmetadata;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;

import utility.JdbcUtil;

public class TestDataBaseMetaDateDemo {

	public static void main(String[] args) {
		try (Connection con = JdbcUtil.getConnectionWithDB();){
			DatabaseMetaData mt = con.getMetaData();
			System.out.println(mt.getDriverName());
			System.out.println(mt.getDriverVersion());
			System.out.println(mt.getJDBCMajorVersion());
			System.out.println(mt.getDatabaseProductVersion());
//			ResultSet rs = mt.getSchemas();
//			while(rs.next()) {
//				System.out.println(rs.getString(1));
//			}
			
			ResultSet rs = mt.getTableTypes();
			while(rs.next()) {
				System.out.println(rs.getString(1));
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}