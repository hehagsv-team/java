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
import src.main.java.org.hcl.harika.schoolMgmt.StudentTopper;

@RunWith(MockitoJUnitRunner.class)
public class StudentTopperTest {

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
	public void test_StudentTopper_Whilefalse() throws Exception {
		MarksDistribution marksdistribution = new MarksDistribution();
		Scanner scan1 = new Scanner("11");
		String result = marksdistribution.classdetails(queryClass, e, conn,"false", scan1,  true);
		System.out.println(result);
		assertEquals("false",result);
	}
	@Test
	public void test_StudentTopper_Case1() throws SQLException {
		StudentTopper studenttopper = new StudentTopper();
		Scanner scan1 = new Scanner("1");
		when(e.execute5thquery(rs,6)).thenReturn("1029");		
		String result = StudentTopper.classdetails(queryClass, e, conn,  "1029",scan1, true);	
		System.out.println(result);
		assertEquals("1029",result);
	}
	@Test
	public void test_StudentTopper_Case2() throws SQLException {
		StudentTopper studenttopper = new StudentTopper();
		Scanner scan1 = new Scanner("2");
		when(e.execute5thquery(rs,7)).thenReturn("1169");		
		String result = StudentTopper.classdetails(queryClass, e,conn, "1169",scan1, true);	
		System.out.println(result);
		assertEquals("1169",result);
	}
	@Test
	public void test_StudentTopper_Case3() throws SQLException {
		StudentTopper studenttopper = new StudentTopper();
		Scanner scan1 = new Scanner("3");
		when(e.execute5thquery(rs,8)).thenReturn("1348");		
		String result = StudentTopper.classdetails(queryClass, e,conn, "1348",scan1, true);	
		System.out.println(result);
		assertEquals("1348",result);
	}
	@Test
	public void test_StudentTopper_Case4() throws SQLException {
		StudentTopper studenttopper = new StudentTopper();
		Scanner scan1 = new Scanner("4");
		when(e.execute5thquery(rs,9)).thenReturn("977");		
		String result = StudentTopper.classdetails(queryClass, e, conn,  "977",scan1, true);	
		System.out.println(result);
		assertEquals("977",result);
	}
	@Test
	public void test_StudentTopper_Case5() throws SQLException {
		StudentTopper studenttopper = new StudentTopper();
		Scanner scan1 = new Scanner("5");
		when(e.execute5thquery(rs,10)).thenReturn("1545");		
		String result = StudentTopper.classdetails(queryClass, e,conn,"1545", scan1,true);	
		System.out.println(result);
		assertEquals("1545",result);
	}
}