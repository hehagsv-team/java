package projects.shoppingKart;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ManufacturerFeedback
{
	Connection connection;
	Statement statement;
	ManufacturerFeedback(Connection connection, Statement statement) {
		this.connection=connection;
		this.statement=statement;
	}
	public void feedback() throws SQLException {
		String q1="UPDATE HCL_SK_MANUFACTURER SET RATING=0 WHERE NAME='Huawei'";
	    statement.executeUpdate(q1);//DONE
		System.out.println("RATING IS DONE");
	}
}
