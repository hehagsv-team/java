package projects.shoppingKart;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class GetShippingStatus
{
	Connection connection;
	Statement statement;
	GetShippingStatus(Connection connection, Statement statement) 
	{
		this.connection=connection;
		this.statement=statement;
	}
	public void shippingstatus() throws SQLException 
	{
		String q1="SELECT  SHIPPING_STATUS FROM HCL_SK_SHIPPING_ORDER WHERE order_id=10";
	    statement.executeUpdate(q1);
		System.out.println("shipping status is displayed");
	}
}
