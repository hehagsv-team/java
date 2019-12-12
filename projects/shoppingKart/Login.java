package projects.shoppingKart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Login {

	static class UserDetails {
		String name;
		long ID;
	}
	
	UserDetails loggedInUser;
	Connection connection;
	
	Login (Connection conn){
		connection = conn;
	}
	
	public UserDetails validateUser (String userName) {
		Statement stmnt = null;
		try {
			stmnt = connection.createStatement();
			String sql="select ID from hcl_sk_user_account where name='"+userName+"'";
			ResultSet rs = stmnt.executeQuery(sql);
			if (rs.next()) {
				loggedInUser = new UserDetails ();
				loggedInUser.ID = rs.getLong("ID");
				loggedInUser.name = userName;
				return loggedInUser;
			} else {
				System.out.println("The user "+userName+" does not exist in the system");
			}
			return null;
		} catch (SQLException e) {
			System.err.println("Error while validating User");
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (stmnt!=null) stmnt.close();
			} catch (SQLException e) {
				System.err.println("Error in closing statement while validating User");
				e.printStackTrace();
			}
		}
	}
	
	public UserDetails getLoggedInUser () {
		return loggedInUser;
	}
	
	public static void main (String args[]) throws ClassNotFoundException, SQLException {
		Connection connection=null;
		try {
			String driverClass = "oracle.jdbc.driver.OracleDriver";
			String connectionURL = "jdbc:oracle:thin:@135.250.220.98:1521:HCLDSDB";
			String dbUser = "HCL_DBUSER";
			String dbPwd = "test_user";
			Class.forName(driverClass);
			connection=DriverManager.getConnection(connectionURL,dbUser,dbPwd);
			System.out.println("In login classconnection established");

			System.out.println("USER ID= "+new Login(connection).validateUser("Ashok").ID);
		} finally {
			System.out.println("closing connection");

			try {
				if (connection !=null) 
					connection.close();
			} catch (SQLException e) {
				System.err.println("Unnable to close Oracle Connection");
				e.printStackTrace();
			}
		}
	}
}

