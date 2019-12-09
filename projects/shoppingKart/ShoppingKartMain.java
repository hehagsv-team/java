package projects.shoppingKart;

import java.sql.*;
public class ShoppingKartMain {

	public static void main(String[] args) throws Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@135.250.220.98:1521:HCLDSDB","HCL_DBUSER","test_user");
		System.out.println("connection established");
		Statement statement=connection.createStatement();
		//update shippng status
		ShippingStatus shippingStatus=new ShippingStatus(connection,statement);
		shippingStatus.updateShippingStatus();
		
//		add to cart
		AddCart addCart=new AddCart(connection, statement);
		addCart.cart();
//		manufacture feedback
		ManufacturerFeedback manufacturer=new ManufacturerFeedback(connection, statement);
		manufacturer.feedback();
		
		//manufacture filtering
		Product filter=new Product(connection, statement);
		filter.itemsByManufacturer();	
		filter.itemsByPrice();
		//shipping status
		ShippingStatus shipping=new ShippingStatus(connection, statement);    
		shipping.getShippingStatus();			
		
		System.out.println("closing connection");
		statement.close();
		connection.close();
	}

}



