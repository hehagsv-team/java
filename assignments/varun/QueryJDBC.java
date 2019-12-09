package com.dss.basic;
import java.sql.*;
public class QueryJDBC {

	public static void main(String[] args) throws Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@135.250.220.98:1521:HCLDSDB","HCL_DBUSER","test_user");
		System.out.println("connection established");
		Statement statement=connection.createStatement();
		//price range
		PriceSelect priceselect=new PriceSelect(connection,statement);
		priceselect.selectprice();
		//update shippng status
		UpdateShippingStatus shippingStatus=new UpdateShippingStatus(connection,statement);
		shippingStatus.update();

		System.out.println("closing connection");
		statement.close();
		connection.close();
	}

}
class PriceSelect
{
	Connection connections;
	Statement statement;
	public PriceSelect(Connection connections, Statement statement) {
		this.connections=connections;
		this.statement=statement;
	}

	void selectprice() throws SQLException
	{
		
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

class UpdateShippingStatus
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
		statement.close();
	}
}


