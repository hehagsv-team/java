package projects.shoppingKart;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PriceSelect
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
