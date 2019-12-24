package projects.shoppingKart;


package com.shop;

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
		
//		String sql1 ="UPDATE hcl_sk_order SET payment=1 WHERE id="+customerId+" and id="+orderid;
//		statement.executeUpdate(sql1);
//		System.out.println(sql1);
		String q1="update Hcl_Sk_Shipping_Order set Shipping_Status='d' where order_id="+orderid;
		String q2="update Hcl_Sk_Shipping_Order set delivered_date=sysdate where shipping_status='d'and order_id="+orderid;
		System.out.println("Shipping Status Updated Successfully");
	}


}
