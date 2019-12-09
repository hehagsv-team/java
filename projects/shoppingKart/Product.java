package projects.shoppingKart;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class ProductDetails {
	int ID;
	String name;
	int price;
}

public class Product
{
	Connection connection;
	Statement statement;
	public Product(Connection connections, Statement statement) 
	{
		this.connection=connections;
		this.statement=statement;
	}
   ProductDetails[] itemsByManufacturer() throws SQLException
	{
		String q1= "SELECT item.NAME FROM HCL_SK_ITEM item JOIN HCL_SK_MANUFACTURER manufacture ON (item.MANUFACTURER_ID = manufacture.ID)";
		ResultSet resultSet=statement.executeQuery(q1);
		while(resultSet.next())
		{
			System.out.println(resultSet.getString("name"));
		}
		System.out.println("Filtering successful");	
		return null;
	}
   
   void itemsByPrice () throws SQLException
   {

	   // select the items within the price range
	   String q1="select price from Hcl_Sk_Item where price between 6000 and 15000";
	   ResultSet resultset=statement.executeQuery(q1);
	   while(resultset.next())
	   {
		   System.out.println(resultset.getInt("price"));
	   }
	   System.out.println("select price done");
	   resultset.close();
   }
}
