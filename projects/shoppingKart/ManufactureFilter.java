package projects.shoppingKart;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ManufactureFilter
{
	Connection connection;
	Statement statement;
	public ManufactureFilter(Connection connections, Statement statement) 
	{
		this.connection=connections;
		this.statement=statement;
	}
   void manufacturer() throws SQLException
	{
		String q1= "SELECT item.NAME FROM HCL_SK_ITEM item JOIN HCL_SK_MANUFACTURER manufacture ON (item.MANUFACTURER_ID = manufacture.ID)";
		ResultSet resultSet=statement.executeQuery(q1);
		while(resultSet.next())
		{
			System.out.println(resultSet.getString("name"));
		}
		System.out.println("Filtering successful");		
	}
}
