package projects.shoppingKart;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class AddCart
{
	Connection connection;
	Statement statement;
	public AddCart(Connection connections, Statement statement) {
		this.connection=connections;
		this.statement=statement;
	}

	void cart() throws SQLException
	{
		
		String q1="INSERT  INTO HCL_SK_ORDER(ITEM_ID,ID,ORDER_DATE,QUANTITY,USER_ACCOUNT_ID,PAYMENT) VALUES(127,203,SYSDATE,1,2,0)";
		statement.executeUpdate(q1);
		System.out.println("INSERTION IS DONE");
		
	}
}
