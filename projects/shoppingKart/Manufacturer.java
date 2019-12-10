package projects.shoppingKart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

public class Manufacturer
{
	Connection connection;
	Statement statement;
	Manufacturer(Connection connection, Statement statement) {
		this.connection=connection;
		this.statement=statement;
	}
	
	public boolean rateManufacturer(int rating, String manufacturerName) throws SQLException {
		String q1="UPDATE HCL_SK_MANUFACTURER SET RATING="+rating+" WHERE NAME='"+manufacturerName+"'";
	    int result = statement.executeUpdate(q1);
	    if (result>0)
	    	return true;//success
	    return false;
	}
	
	public String[] getManufacturerList () {
		String sql = "select name from hcl_sk_manufacturer";
		ResultSet rs;
		try {
			rs = statement.executeQuery(sql);
			ArrayList<String> list = new ArrayList<String>();
			while (rs.next()) {
				list.add(rs.getString("NAME"));
			}
			int size = list.size();
			if (size==0)
				return null; // fetch returned empty
			String [] listNames = new String[size];
			Iterator<String> iter = list.iterator();
			for (int i = 0; iter.hasNext(); i++) {
				listNames [i] = iter.next();
			}
			return listNames;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static void main (String args[]) throws ClassNotFoundException, SQLException {
		Connection connection=null;
		Statement statement = null;
		try {
			String driverClass = "oracle.jdbc.driver.OracleDriver";
			String connectionURL = "jdbc:oracle:thin:@135.250.220.98:1521:HCLDSDB";
			String dbUser = "HCL_DBUSER";
			String dbPwd = "test_user";
			Class.forName(driverClass);
			connection=DriverManager.getConnection(connectionURL,dbUser,dbPwd);
			System.out.println("connection established");
			statement = connection.createStatement();

			String[] arr = new Manufacturer(connection, statement).getManufacturerList();
			for (int i = 0; i < arr.length; i++) {
				System.out.println("Manu "+(i+1)+": "+arr[i]);
			}
		} finally {
			System.out.println("closing connection");
			try {
				if (statement !=null) 
					statement.close();
			} catch (SQLException e) {
				System.err.println("Unnable to close JDBC Statement");
				e.printStackTrace();
			}
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
