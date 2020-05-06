import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class ClassStrengthTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test6() {
		ClassStrength classstrength = new ClassStrength();
		Connection connection = DatabaseConnection.getConnection();
		ResultSet resultset = null;
		String execute=null;
		QueryClass queclass=new QueryClass();
		ExecuteClass execlass=new ExecuteClass();
		PreparedStatement prestat = null;
		String result;
		try {
			result = classstrength.classdetails(queclass, execlass, prestat, connection, 1, resultset, execute);
			System.out.println("Result =>"+result);
			Assert.assertEquals(result, "20");
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
