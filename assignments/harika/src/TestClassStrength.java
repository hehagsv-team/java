import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class TestClassStrength {

	
	@BeforeEach
	void setUp() throws Exception {
	}

	/*
	 * @Test void test6() { ClassStrength classstrength = new ClassStrength();
	 * Connection connection = DatabaseConnection.getConnection(); ResultSet rs =
	 * null; String execute=null; QueryClass t=new QueryClass(); ExecuteClass e=new
	 * ExecuteClass(); PreparedStatement ps = null; String result; try { result =
	 * classstrength.classdetails(t, e, ps, connection, 1, rs, execute);
	 * System.out.println("Result =>"+result); Assert.assertEquals(result, "20"); }
	 * catch (Exception e1) { e1.printStackTrace(); } finally { if(null !=
	 * connection) { try { connection.close(); } catch (SQLException e1) {
	 * e1.printStackTrace(); } } } }
	 * 
	 * @Test void test7() { ClassStrength classstrength = new ClassStrength();
	 * Connection connection = DatabaseConnection.getConnection(); ResultSet rs =
	 * null; String execute=null; QueryClass t=new QueryClass(); ExecuteClass e=new
	 * ExecuteClass(); PreparedStatement ps = null; String result; try { result =
	 * classstrength.classdetails(t, e, ps, connection, 2, rs, execute);
	 * System.out.println("Result =>"+result); Assert.assertEquals(result, "20"); }
	 * catch (Exception e1) { e1.printStackTrace(); } finally { if(null !=
	 * connection) { try { connection.close(); } catch (SQLException e1) {
	 * e1.printStackTrace(); } } } }
	 * 
	 * @Test void test8() { ClassStrength classstrength = new ClassStrength();
	 * Connection connection = DatabaseConnection.getConnection(); ResultSet rs =
	 * null; String execute=null; QueryClass t=new QueryClass(); ExecuteClass e=new
	 * ExecuteClass(); PreparedStatement ps = null; String result; try { result =
	 * classstrength.classdetails(t, e, ps, connection, 3, rs, execute);
	 * System.out.println("Result =>"+result); Assert.assertEquals(result, "20"); }
	 * catch (Exception e1) { e1.printStackTrace(); } finally { if(null !=
	 * connection) { try { connection.close(); } catch (SQLException e1) {
	 * e1.printStackTrace(); } } } }
	 */
	@Test
	void test9() {
		ClassStrength classstrength = new ClassStrength();
		Connection connection = DatabaseConnection.getConnection();
		ResultSet rs = null;
		String execute=null;
		QueryClass t=new QueryClass();
		ExecuteClass e=new ExecuteClass();
		PreparedStatement ps = null;
		String result;
		String input = "1";
		Scanner scan=new Scanner(input);
		try {
			result=	classstrength.classdetails(t, e, ps, connection, scan, rs, execute, true);
			
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
