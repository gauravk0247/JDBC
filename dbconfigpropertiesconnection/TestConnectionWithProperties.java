package dbconfigpropertiesconnection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class TestConnectionWithProperties {

	public static void main(String[] args) throws IOException {
		try{
			Reader reader = new FileReader("./src/DBConfig.properties");
			/*
			 * to load any properties file we need the object of properties class in java
			 * 
			 * Inside java.util package there is one legacy class in available properties class
			 * 
			 * we can create the object of properties class using new keyboard like 
			 * Properties p = new Properties();
			 * 
			 * The properties class provides one of the very important method called,
			 * void load(Reader reader)
			 * void load(InputStreamReader reader)
			 * the above method is used to load any properties file
			 * 
			 * Properties class also provides setter and getter methods
			 * like
			 * 
			 * String getProperty(String key)
			 * void setProperty(String keyName, String value)
			 * 
			 * What is properties file?
			 * it is plain textual file which contains only text data as key and value pair
			 * key(text)=value(text)
			 * The properties files mostly used for configuration purpose like database configuration,
			 * logger configuration, mail configuration, sms configuration.
			 */
			
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
			
			FileInputStream fis = new FileInputStream("C://Users//91800//Downloads//fav.png");
			PreparedStatement ps = con.prepareStatement("insert into product values(?, ?)");
			
			ps.setInt(1, 108);
			ps.setBinaryStream(2, fis);
			int status=ps.executeUpdate();
			if(status>0) {
				System.out.println("inserted");
			}else {
				System.out.println("Not inserted");
			}
			
		}catch(FileNotFoundException |ClassNotFoundException| SQLException e){
			System.out.println(e);
		}
	}
}