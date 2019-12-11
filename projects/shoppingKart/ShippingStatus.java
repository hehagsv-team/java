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
	public void updateShippingStatus(int itemid,int customerId) throws SQLException {
		
		String sql1 ="UPDATE hcl_sk_order SET payment=1 WHERE id="+customerId;
		System.out.println(sql1);
		String q1="update Hcl_Sk_Shipping_Order set Shipping_Status='d' where user_account_id="+customerId+" and item_id="+itemid;
		String q2="update Hcl_Sk_Shipping_Order set delivered_date=sysdate where shipping_status='d' and item_id="+itemid;
		statement.executeUpdate(sql1);
		statement.executeUpdate(q1);
		statement.executeUpdate(q2);
		System.out.println("Update Shipping Status Completed Successfully");
	}

}
