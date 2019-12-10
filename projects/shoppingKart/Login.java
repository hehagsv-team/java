package projects.shoppingKart;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Login {

	static class UserDetails {
		String name;
		long ID;
	}
	
	UserDetails loggedInUser = null;
	Connection connection;
	
	Login (Connection conn){
		connection = conn;
	}
	
	public UserDetails validateUser (String userName) {
		Statement stmnt = null;
		try {
			stmnt = connection.createStatement();
			String sql="select ID from hcl_sk_user_account where name="+userName;
			ResultSet rs = stmnt.executeQuery(sql);
			if (rs.next()) {
				loggedInUser = new UserDetails ();
				loggedInUser.ID = rs.getLong("ID");
				loggedInUser.name = userName;
				return loggedInUser;
			}
			return null;
		} catch (SQLException e) {
			System.err.println("Error while validating User");
			e.printStackTrace();
			return null;
		} finally {
			try {
				stmnt.close();
			} catch (SQLException e) {
				System.err.println("Error in closing statement while validating User");
				e.printStackTrace();
			}
		}
	}
	
	public UserDetails getLoggedInUser () {
		return loggedInUser;
	}
}
