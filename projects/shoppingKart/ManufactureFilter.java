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
		String q1= "select i.name,i.manufacturer_id,m.id from Hcl_Sk_Item i join Hcl_Sk_Manufacturer m on i.manufacturer_id=m.id where manufacturer_id=4";
		ResultSet resultSet=statement.executeQuery(q1);
		while(resultSet.next())
		{
			System.out.println(resultSet.getString("name"));
		}
		System.out.println("Filtering successful");		
	}
}
