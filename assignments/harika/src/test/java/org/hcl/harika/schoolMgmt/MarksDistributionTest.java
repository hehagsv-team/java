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

import src.main.java.org.hcl.harika.schoolMgmt.ExecuteClass;
import src.main.java.org.hcl.harika.schoolMgmt.MarksDistribution;
import src.main.java.org.hcl.harika.schoolMgmt.QueryClass;

@RunWith(MockitoJUnitRunner.class)
public class MarksDistributionTest {

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
	public void testMarksDistributionWhilefalse() throws Exception {
		MarksDistribution marksdistribution = new MarksDistribution();
		Scanner scan1 = new Scanner("11");
		String result = marksdistribution.classdetails(queryClass, e, conn, "false", scan1, true);
		System.out.println(result);
		assertEquals("false",result);
	}
	@Test
	public void testMarksDistributionCaseOne() throws SQLException {
		MarksDistribution marksdistribution = new MarksDistribution();
		Scanner scan1 = new Scanner("1");
		when(e.execute3rdquery(rs,"PHYSICS")).thenReturn("20");		
		String result = marksdistribution.classdetails(queryClass, e,conn, "20", scan1, true);	
		System.out.println(result);
		assertEquals("20",result);
	}
	@Test
	public void testMarksDistributionCaseTwo() throws SQLException {
		MarksDistribution marksdistribution = new MarksDistribution();
		Scanner scan1 = new Scanner("2");
		when(e.execute3rdquery(rs,"CHEMISTRY")).thenReturn("20");		
		String result = marksdistribution.classdetails(queryClass, e, conn, "20",scan1, true);	
		System.out.println(result);
		assertEquals("20",result);
	}
	@Test
	public void testMarksDistributionCaseThree() throws SQLException {
		MarksDistribution marksdistribution = new MarksDistribution();
		Scanner scan1 = new Scanner("3");
		when(e.execute3rdquery(rs,"BIOLOGY")).thenReturn("20");		
		String result = marksdistribution.classdetails(queryClass, e,conn,  "20",scan1, true);	
		System.out.println(result);
		assertEquals("20",result);
	}
	@Test
	public void testMarksDistributionCaseFour() throws SQLException {
		MarksDistribution marksdistribution = new MarksDistribution();
		Scanner scan1 = new Scanner("4");
		when(e.execute3rdquery(rs,"HISTORY")).thenReturn("20");		
		String result = marksdistribution.classdetails(queryClass, e, conn, "20", scan1, true);	
		System.out.println(result);
		assertEquals("20",result);
	}
	@Test
	public void testMarksDistributionCaseFive() throws SQLException {
		MarksDistribution marksdistribution = new MarksDistribution();
		Scanner scan1 = new Scanner("5");
		when(e.execute3rdquery(rs,"GEOGRAPHY")).thenReturn("20");		
		String result = marksdistribution.classdetails(queryClass, e,conn,"20",  scan1, true);	
		System.out.println(result);
		assertEquals("20",result);
	}
	@Test 
	public void testMarksDistributionCaseSix() throws SQLException {
		MarksDistribution marksdistribution = new MarksDistribution();
		Scanner scan1 = new Scanner("6");
		when(e.execute3rdquery(rs,"POLITICAL SCIENCE")).thenReturn("20");		
		String result = marksdistribution.classdetails(queryClass, e,  conn,  "20",scan1, true);	
		System.out.println(result);
		assertEquals("20",result);
	}
	@Test
	public void testMarksDistributionCaseSeven() throws SQLException {
		MarksDistribution marksdistribution = new MarksDistribution();
		Scanner scan1 = new Scanner("7");
		when(e.execute3rdquery(rs,"ECONOMICS")).thenReturn("20");		
		String result = marksdistribution.classdetails(queryClass, e,  conn, "20", scan1, true);	
		System.out.println(result);
		assertEquals("20",result);
	}
	@Test
	public void testMarksDistributionCaseEight() throws SQLException {
		MarksDistribution marksdistribution = new MarksDistribution();
		Scanner scan1 = new Scanner("8");
		when(e.execute3rdquery(rs,"ENGLISH")).thenReturn("20");		
		String result = marksdistribution.classdetails(queryClass, e, conn, "20", scan1, true);	
		System.out.println(result);
		assertEquals("20",result);
	}
	@Test
	public void testMarksDistributionCaseNine() throws SQLException {
		MarksDistribution marksdistribution = new MarksDistribution();
		Scanner scan1 = new Scanner("9");
		when(e.execute3rdquery(rs,"HINDI")).thenReturn("20");		
		String result = marksdistribution.classdetails(queryClass, e, conn,"20", scan1,  true);	
		System.out.println(result);
		assertEquals("20",result);
	}
	@Test
	public void testMarksDistributionCaseTen() throws SQLException {
		MarksDistribution marksdistribution = new MarksDistribution();
		Scanner scan1 = new Scanner("10");
		when(e.execute3rdquery(rs,"MATHS")).thenReturn("20");		
		String result = marksdistribution.classdetails(queryClass, e,conn,"20", scan1,  true);	
		System.out.println(result);
		assertEquals("20",result);
	}
}
