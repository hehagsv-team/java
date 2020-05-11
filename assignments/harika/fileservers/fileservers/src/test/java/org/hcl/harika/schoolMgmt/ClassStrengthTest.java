package org.hcl.harika.schoolMgmt;
import static org.junit.Assert.*;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.hcl.harika.schoolMgmt.ClassStrength;
import org.hcl.harika.schoolMgmt.ExecuteClass;
import org.hcl.harika.schoolMgmt.QueryClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;



@RunWith(MockitoJUnitRunner.class)
public class ClassStrengthTest {

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
		when(conn.prepareStatement(Mockito.any(String.class))).thenReturn(ps);
		when(ps.executeQuery()).thenReturn(rs);		
	}
	@Test
	public void test_ClassStrength_WhileTrue() throws Exception {
		ClassStrength classstrength = new ClassStrength();
		Scanner scan1 = new Scanner("6");
		String result = classstrength.classdetails(queryClass, e,conn,"true",scan1, true);
//		when(String.execute).thenReturn("true");
		System.out.println(result);
		assertEquals("true",result);
	}	
	@Test
	public void test_ClassStrength_Whilefalse() throws Exception {
		ClassStrength classstrength = new ClassStrength();
		Scanner scan1 = new Scanner("11");
//		when(rs.next()).thenReturn(true);
		String result = classstrength.classdetails(queryClass, e,conn,"false", scan1,true);
		System.out.println(result);
		assertEquals("false",result);
	}
	@Test
	public void test_ClassStrength_Case1() throws SQLException {
		ClassStrength classstrength = new ClassStrength();
		Scanner scan1 = new Scanner("1");
		when(e.execute9thquery(rs,6)).thenReturn("20");		
		String result = classstrength.classdetails(queryClass, e,conn,"20", scan1,true);	
		System.out.println(result);
		assertEquals("20",result);
	}
	@Test
	public void test_ClassStrength_Case2() throws SQLException { 
		ClassStrength classstrength = new ClassStrength();
		Scanner scan1 = new Scanner("2");
		when(e.execute9thquery(rs,7)).thenReturn("20");		
		String result = classstrength.classdetails(queryClass, e,conn,"20", scan1,true);	
		System.out.println(result);
		assertEquals("20",result);
	}
	@Test
	public void test_ClassStrength_Case3() throws SQLException {
		ClassStrength classstrength = new ClassStrength();
		Scanner scan1 = new Scanner("3");
		when(e.execute9thquery(rs,8)).thenReturn("20");		
		String result = classstrength.classdetails(queryClass, e,conn,"20", scan1,true);	
		System.out.println(result);
		assertEquals("20",result);
	}
	@Test
	public void test_ClassStrength_Case4() throws SQLException {
		ClassStrength classstrength = new ClassStrength();
		Scanner scan1 = new Scanner("4");
		when(e.execute9thquery(rs,9)).thenReturn("20");		
		String result = classstrength.classdetails(queryClass, e,conn,"20", scan1,true);	
		System.out.println(result);
		assertEquals("20",result);
	}
	@Test
	public void test_ClassStrength_Case5() throws SQLException {
		ClassStrength classstrength = new ClassStrength();
		Scanner scan1 = new Scanner("5");
		when(e.execute9thquery(rs,10)).thenReturn("20");		
		String result = classstrength.classdetails(queryClass, e, conn,"20", scan1, true);	
		System.out.println(result);
		assertEquals("20",result);
	}
//	@Test
//	public void tst2() throws SQLException {
//		ClassStrength classstrength = new ClassStrength();
//		Scanner scan1 = new Scanner("5");
//		when(e.execute9thquery(rs,6)).thenReturn("test_string");
//		when(scan.nextInt()).thenReturn(11);
//		String result = classstrength.classdetails(queryClass, e, ps, conn,scan1,rs, "20",false);	
//	
//	}
//	@Test
//	public void TestAcrossBoundariesWrongEntryClassNames() throws Exception {
//		ClassStrength classstrength = new ClassStrength();
//		when(e.execute9thquery(anyObject(),anyInt())).thenReturn("54");
//		Scanner scan1 = new Scanner("0");
//		String result = classstrength.classdetails(queryClass, e, ps, conn, scan1,rs, "", true);
//		System.out.println(result);
//		assertEquals("54",result);
//	}
//	
}
