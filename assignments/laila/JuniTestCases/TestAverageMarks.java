import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import junit.framework.Assert;

public class TestAverageMarks {

	@Before
	public void setUp() throws Exception {
		
	}

	
	
	@Test
	void test7() {
		AverageMarks averagemarks = new AverageMarks();
		Connection connection = DatabaseConnection.getConnection();
		ResultSet resultset = null;
		String execute=null;
		QueryClass queclass=new QueryClass();
		ExecuteClass execlass=new ExecuteClass();
		PreparedStatement prestat = null;
		String result;
		try {
			result = averagemarks.classdetails(queclass, execlass, prestat, connection, 2, resultset, execute);
			System.out.println("Result =>"+result);
			Assert.assertEquals(result, "73");
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			if(null != connection) {
				try {
					connection.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
	
	
	
	@After
	public void destroy() {
		
	}

}

