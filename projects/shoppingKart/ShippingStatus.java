package projects.shoppingKart;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.spi.DirStateFactory.Result;

public class ShippingStatus
{
	Connection connection;
	Statement statement;
	ShippingStatus(Connection connection, Statement statement) 
	{
		this.connection=connection;
		this.statement=statement;
	}
	public String getShippingStatus(int orderid) throws SQLException 
	{
		
		String q1="SELECT  SHIPPING_STATUS FROM HCL_SK_SHIPPING_ORDER WHERE order_id"+orderid;
	    ResultSet resultSet=statement.executeQuery(q1);
	    if(resultSet.next())
	    {
	    	return resultSet.getString("SHIPPING_STATUS");
	    }
		System.out.println("shipping status is displayed");
		return null;
	}
	public void updateShipping(int orderid) throws SQLException {
		
		String q1="update Hcl_Sk_Shipping_Order set Shipping_Status='d' where order_id="+orderid;
		statement.executeUpdate(q1);
		String q2="update Hcl_Sk_Shipping_Order set delivered_date=sysdate where shipping_status='d'and order_id="+orderid;
		statement.executeUpdate(q2);
		System.out.println("Update Shipping Status Completed Successfully");
	}


}
