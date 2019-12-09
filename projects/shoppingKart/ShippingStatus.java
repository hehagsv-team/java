package projects.shoppingKart;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ShippingStatus
{
	Connection connection;
	Statement statement;
	ShippingStatus(Connection connection, Statement statement) 
	{
		this.connection=connection;
		this.statement=statement;
	}
	public void getShippingStatus() throws SQLException 
	{
		String q1="SELECT  SHIPPING_STATUS FROM HCL_SK_SHIPPING_ORDER WHERE order_id=10";
	    statement.executeUpdate(q1);
		System.out.println("shipping status is displayed");
	}
	public void updateShippingStatus() throws SQLException {
		String q1="update Hcl_Sk_Shipping_Order set Shipping_Status='d' where id in(select id from Hcl_Sk_Shipping_Order where mod(id,2)=0)";
		String q2="update Hcl_Sk_Shipping_Order set delivered_date=sysdate where shipping_status='d'";
		statement.executeUpdate(q1);
		statement.executeUpdate(q2);
		System.out.println("Update Shipping Status Completed Successfully");
	}

}
