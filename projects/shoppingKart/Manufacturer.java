package projects.shoppingKart;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
			return (String[])list.toArray();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		

	}
}
