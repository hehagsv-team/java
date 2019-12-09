package projects.shoppingKart;

import java.sql.*;
public class ShoppingKartMain {

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
		
//		add to cart
		AddCart addCart=new AddCart(connection, statement);
		addCart.cart();
//		manufacture feedback
		ManufacturerFeedback manufacturer=new ManufacturerFeedback(connection, statement);
		manufacturer.feedback();
		
		//manufacture filtering
		ManufactureFilter filter=new ManufactureFilter(connection, statement);
		filter.manufacturer();	
		//shipping status
		GetShippingStatus shipping=new GetShippingStatus(connection, statement);    
		shipping.shippingstatus();			
		
		System.out.println("closing connection");
		statement.close();
		connection.close();
	}

}



