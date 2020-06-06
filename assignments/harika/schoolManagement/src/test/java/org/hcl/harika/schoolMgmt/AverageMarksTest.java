package src.test.java.org.hcl.harika.schoolMgmt;
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

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.OngoingStubbing;

import src.main.java.org.hcl.harika.schoolMgmt.AverageMarks;
import src.main.java.org.hcl.harika.schoolMgmt.ExecuteClass;
import src.main.java.org.hcl.harika.schoolMgmt.QueryClass;

@RunWith(MockitoJUnitRunner.class)
public class AverageMarksTest {

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
	public void setUp1() throws Exception {
		assertNotNull(conn);
		when(conn.prepareStatement(any(String.class))).thenReturn(ps);
		when(ps.executeQuery()).thenReturn(rs);		
	}
	@Test
	public void test_AverageMarks_WhileTrue() throws Exception {
		AverageMarks averagemarks = new AverageMarks();
		Scanner scan1 = new Scanner("6");
		String result = averagemarks.classdetails(queryClass, e,conn, "true", scan1, true);
		System.out.println(result);
		assertEquals("true",result);
	}	
	@Test
	public void test_AverageMarks_Whilefalse() throws Exception {
		AverageMarks averagemarks = new AverageMarks();
		Scanner scan1 = new Scanner("11");
		String result = averagemarks.classdetails(queryClass, e, conn,"false", scan1,  true);
		System.out.println(result);
		assertEquals("false",result);
	}
	@Test
	public void test_AverageMarks_Case1() throws SQLException {
		AverageMarks averagemarks = new AverageMarks();
		Scanner scan1 = new Scanner("1");
		when(e.execute2ndquery(rs,6)).thenReturn("74");		
		String result = averagemarks.classdetails(queryClass, e, conn,"74", scan1,true);	
		System.out.println(result);
		assertEquals("74",result);
	}
	@Test
	public void test_AverageMarks_Case2() throws SQLException {
		AverageMarks averagemarks = new AverageMarks();
		Scanner scan1 = new Scanner("2");
		when(e.execute2ndquery(rs,7)).thenReturn("73");		
		String result = averagemarks.classdetails(queryClass, e, conn,"73",  scan1,true);	
		System.out.println(result);
		assertEquals("73",result);
	}
	@Test
	public void test_AverageMarks_Case3() throws SQLException {
		AverageMarks averagemarks = new AverageMarks();
		Scanner scan1 = new Scanner("3");
		when(e.execute2ndquery(rs,8)).thenReturn("72");		
		String result = averagemarks.classdetails(queryClass, e, conn,"72", scan1, true);	
		System.out.println(result);
		assertEquals("72",result);
	}
	@Test
	public void test_AverageMarks_Case4() throws SQLException {
		AverageMarks averagemarks = new AverageMarks();
		Scanner scan1 = new Scanner("4");
		when(e.execute2ndquery(rs,9)).thenReturn("74");		
		String result = averagemarks.classdetails(queryClass, e,conn,"74", scan1,  true);	
		System.out.println(result);
		assertEquals("74",result);
	}
	@Test
	public void test_AverageMarks_Case5() throws SQLException {
		AverageMarks averagemarks = new AverageMarks();
		Scanner scan1 = new Scanner("5");
		when(e.execute2ndquery(rs,10)).thenReturn("0");		
		String result = averagemarks.classdetails(queryClass, e, conn, "0",scan1,true);	
		System.out.println(result);
		assertEquals("0",result);
	}
}
