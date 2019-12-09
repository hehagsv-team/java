package project1;
import java.sql.*;
public class JdbcConnection1
{
public static void main(String[] args) throws Exception
{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@135.250.220.98:1521:HCLDSDB","HCL_DBUSER","test_user");
    System.out.println("connection established");
	Statement statement=connection.createStatement();
//	add to cart
	addtocart cart=new addtocart(connection, statement);
	cart.shiporder();
//	manufacture feedback
	manufacturersfeedback manufacturer=new manufacturersfeedback(connection, statement);
	manufacturer.feedback();	
	System.out.println("closing connection");
	statement.close();
	connection.close();
}
}
class addtocart
{
	Connection connection;
	Statement statement;
	public addtocart(Connection connections, Statement statement) {
		this.connection=connections;
		this.statement=statement;
	}
   void shiporder() throws SQLException
	{
		
		String q1="INSERT  INTO HCL_SK_ORDER(ITEM_ID,ID,ORDER_DATE,QUANTITY,USER_ACCOUNT_ID,PAYMENT) VALUES(131,208,SYSDATE,1,2,0)";
		statement.executeUpdate(q1);
		System.out.println("INSERTION IS DONE");
		
	}
}

class manufacturersfeedback
{
	Connection connection;
	Statement statement;
	manufacturersfeedback(Connection connection, Statement statement) {
		this.connection=connection;
		this.statement=statement;
	}
	public void feedback() throws SQLException {
		String q1="UPDATE HCL_SK_MANUFACTURER SET RATING=6 WHERE NAME='Huawei'";
	    statement.executeUpdate(q1);
		System.out.println("RATING IS DONE");
		statement.close();
	}
}

