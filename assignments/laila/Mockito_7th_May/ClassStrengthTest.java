import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class ClassStrengthTest {
	@Mock
	private Connection connection;
	@Mock
	private PreparedStatement prestat;

	@Mock
	private ResultSet resultset;


	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		when(connection.prepareStatement(any(String.class))).thenReturn(prestat);
		when(prestat.executeQuery()).thenReturn(resultset);	
	}

	@Test
	public void test6() throws Exception {
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
			assertEquals(result, "20");
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
	void test7() {
		ClassStrength classstrength = new ClassStrength();
		Connection connection = DatabaseConnection.getConnection();
		ResultSet resultset = null;
		String execute=null;
		QueryClass queclass=new QueryClass();
		ExecuteClass execlass=new ExecuteClass();
		PreparedStatement prestat = null;
		String result;
		try {
			result = classstrength.classdetails(queclass, execlass, prestat, connection, 2, resultset, execute);
			System.out.println("Result =>"+result);
			assertEquals(result, "20");
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
	void test8() {
		ClassStrength classstrength = new ClassStrength();
		Connection connection = DatabaseConnection.getConnection();
		ResultSet resultset = null;
		String execute=null;
		QueryClass queclass=new QueryClass();
		ExecuteClass execlass=new ExecuteClass();
		PreparedStatement prestat = null;
		String result;
		try {
			result = classstrength.classdetails(queclass, execlass, prestat, connection, 3, resultset, execute);
			System.out.println("Result =>"+result);
			assertEquals(result, "20");
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
	void test9() {
		ClassStrength classstrength = new ClassStrength();
		Connection connection = DatabaseConnection.getConnection();
		ResultSet resultset = null;
		String execute=null;
		QueryClass queclass=new QueryClass();
		ExecuteClass execlass=new ExecuteClass();
		PreparedStatement prestat = null;
		String result;
		try {
			result = classstrength.classdetails(queclass, execlass, prestat, connection, 4, resultset, execute);
			System.out.println("Result =>"+result);
			assertEquals(result, "20");
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
	void test10() {
		ClassStrength classstrength = new ClassStrength();
		Connection connection = DatabaseConnection.getConnection();
		ResultSet resultset = null;
		String execute=null;
		QueryClass queclass=new QueryClass();
		ExecuteClass execlass=new ExecuteClass();
		PreparedStatement prestat = null;
		String result;
		try {
			result = classstrength.classdetails(queclass, execlass, prestat, connection, 5, resultset, execute);
			System.out.println("Result =>"+result);
			assertEquals(result, "20");
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
