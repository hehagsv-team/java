import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class TestSchoolSchema {
	@Before
	public void setUp() throws Exception {		
	}

	@Test
	void testTaahira() {
		ClassTeacher classTeacher = new ClassTeacher();
		Connection connection = DatabaseConnection.getConnection();
		ResultSet resultset = null;
		String execute=null;
		QueryClass queclass=new QueryClass();
		ExecuteClass execlass=new ExecuteClass();
		PreparedStatement prestat = null;
		String result;
		try {
			result = classTeacher.classdetails(queclass, execlass, prestat, connection, 1, resultset, execute);
			System.out.println("Result =>"+result);
			Assert.assertEquals(result, "Taahira");
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

	@Test
	void testWrongSelection() {
		ClassTeacher classTeacher = new ClassTeacher();
		Connection connection = DatabaseConnection.getConnection();
		ResultSet resultset = null;
		String execute=null;
		QueryClass queclass=new QueryClass();
		ExecuteClass execlass=new ExecuteClass();
		PreparedStatement prestat = null;
		String result;
		try {
			result = classTeacher.classdetails(queclass, execlass, prestat, connection, 1, resultset, execute);
			System.out.println("Result =>"+result);
			Assert.assertEquals(result, null);
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
