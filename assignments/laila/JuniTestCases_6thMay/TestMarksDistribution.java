import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class TestMarksDistribution {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testTaahira() {
		ClassTeacher classTeacher = new ClassTeacher();
		Connection connection = DatabaseConnection.getConnection();
		ResultSet rs = null;
		String execute=null;
		QueryClass t=new QueryClass();
		ExecuteClass e=new ExecuteClass();
		PreparedStatement ps = null;
		String result;
		try {
			result = classTeacher.classdetails(t, e, ps, connection, 1, rs, execute);
			System.out.println("Result =>"+result);
			assertEquals(result, "Taahira");
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
