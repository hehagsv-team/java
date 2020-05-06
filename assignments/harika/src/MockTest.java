import static org.junit.Assert.*;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MockTest {

	@Mock
	private Connection conn;

	@Mock
	private PreparedStatement ps;

	@Mock
	private ResultSet rs;

	@Mock
	private QueryClass queryClass;

	@Mock 
	private ExecuteClass e;

	@Before
	public void setUp() throws Exception {
		assertNotNull(conn);
		when(conn.prepareStatement(any(String.class))).thenReturn(ps);
		when(ps.executeQuery()).thenReturn(rs);		
	}
	@Test
	public void testWhileTrue() throws Exception {
		ClassStrength classstrength = new ClassStrength();
		Scanner scan1 = new Scanner("6");
		String result = classstrength.classdetails(queryClass, e, ps, conn, scan1,rs, "true", true);
		System.out.println(result);
		assertEquals("true",result);
	}	
	@Test
	public void testWhilefalse() throws Exception {
		ClassStrength classstrength = new ClassStrength();
		Scanner scan1 = new Scanner("11");
//		when(rs.next()).thenReturn(true);
		String result = classstrength.classdetails(queryClass, e, ps, conn, scan1,rs, "false", true);
		System.out.println(result);
		assertEquals("false",result);
	}	
	@Test
	public void test() throws Exception {
		ClassStrength classstrength = new ClassStrength();	
		Scanner scan1 = new Scanner("6");
		String result = classstrength.classdetails(queryClass, e, ps, conn, scan1,rs, "46", true);
		when(e.execute9thquery(anyObject(),anyInt())).thenReturn("46");
		System.out.println(result);
		assertEquals("46",result);
	}
	@Test
	public void TestAcrossBoundariesWrongEntryClassNames() throws Exception {
		ClassStrength classstrength = new ClassStrength();
		when(e.execute9thquery(anyObject(),anyInt())).thenReturn("54");
		Scanner scan1 = new Scanner("0");
		String result = classstrength.classdetails(queryClass, e, ps, conn, scan1,rs, "", true);
		System.out.println(result);
		assertEquals("54",result);
	}

}
