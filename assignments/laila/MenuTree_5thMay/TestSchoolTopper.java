import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class TestStudentTopper {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test9() {
		StudentTopper studenttopper = new StudentTopper();
		Connection connection = DatabaseConnection.getConnection();
		ResultSet resultset = null;
		String execute=null;
		QueryClass queclass=new QueryClass();
		ExecuteClass execlass=new ExecuteClass();
		PreparedStatement prestat = null;
		String result;
		try {
			result = studenttopper.classdetails(queclass, execlass, prestat, connection, 4, resultset, execute);
			System.out.println("Result =>"+result);
			Assert.assertEquals(result, "Nolan");
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
}
