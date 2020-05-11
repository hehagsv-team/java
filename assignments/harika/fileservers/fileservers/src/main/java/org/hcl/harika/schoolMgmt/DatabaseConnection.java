package org.hcl.harika.schoolMgmt;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.log4j.Logger;

public class DatabaseConnection {
	final static Logger logger=Logger.getLogger(DatabaseConnection.class);
	static final String DB_URL = "jdbc:h2:~/test";  	   
	static final String USER = "sa"; 
	static final String PASS = "";
	public static Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(DB_URL,USER,PASS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
}
