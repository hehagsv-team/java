package src.main.java.org.hcl.harika.schoolMgmt;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DatabaseConnection {
	static final String DB_URL = "jdbc:h2:~/test";  	   
	static final String USER = "sa"; 
	static final String PASS = "";
	public static Connection getConnection() {
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = DriverManager.getConnection(DB_URL,USER,PASS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
}
