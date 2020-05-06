import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import junit.framework.Assert;

public class TestBestTeacher {

	@Before
	public void setUp() throws Exception {
		
	}
	@Test
	void testTaahira() {
		BestTeacher bestTeacher = new BestTeacher();
		Connection connection = DatabaseConnection.getConnection();
		ResultSet rs = null;
		QueryClass t=new QueryClass();
		ExecuteClass e=new ExecuteClass();
		PreparedStatement ps = null;
		Map<String, Object> result;
		try {
			result = bestTeacher.classdetails(t, e, ps, connection, 1, rs);
			System.out.println("Result =>"+result);
			assertEquals(result.get("average"), 76);
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			if(null != connection) {
				try {
					connection.close();
				} catch (SQLException e1) {
					//e1.printStackTrace();
				}
			}
		}
	}
}
