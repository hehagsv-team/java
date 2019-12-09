package projects.shoppingKart;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateShippingStatus
{
	Connection connection;
	Statement statement;
	UpdateShippingStatus(Connection connection, Statement statement) {
		this.connection=connection;
		this.statement=statement;
	}
	public void update() throws SQLException {
		String q1="update Hcl_Sk_Shipping_Order set Shipping_Status='d' where id in(select id from Hcl_Sk_Shipping_Order where mod(id,2)=0)";
		String q2="update Hcl_Sk_Shipping_Order set delivered_date=sysdate where shipping_status='d'";
		statement.executeUpdate(q1);
		statement.executeUpdate(q2);
		System.out.println("Update Shipping Status Completed Successfully");
	}
}
