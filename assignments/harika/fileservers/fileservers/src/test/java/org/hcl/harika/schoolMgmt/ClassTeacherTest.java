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
import org.hcl.harika.schoolMgmt.ClassTeacher;
import org.hcl.harika.schoolMgmt.ExecuteClass;
import org.hcl.harika.schoolMgmt.QueryClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.OngoingStubbing;


@RunWith(MockitoJUnitRunner.class)
public class ClassTeacherTest {

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
		when(conn.prepareStatement(Mockito.any(String.class))).thenReturn(ps);
		when(ps.executeQuery()).thenReturn(rs);		
	}
	@Test
	public void test_ClassTeacher_WhileTrue() throws Exception {
		ClassTeacher classteacher = new ClassTeacher();
		Scanner scan1 = new Scanner("6");
		String result = classteacher.classdetails(queryClass, e,  conn,  "true",scan1, true);
		System.out.println(result);
		assertEquals("true",result);
	}	
	@Test
	public void test_ClassTeacher_Whilefalse() throws Exception {
		ClassTeacher classteacher = new ClassTeacher();
		Scanner scan1 = new Scanner("11");
		String result = classteacher.classdetails(queryClass, e, conn,"false", scan1,  true);
		System.out.println(result);
		assertEquals("false",result);
	}
	@Test
	public void test_ClassTeacher_Case1() throws SQLException {
		ClassTeacher classteacher = new ClassTeacher();
		Scanner scan1 = new Scanner("1");
		when(e.execute1stquery(rs,6)).thenReturn("Taahira");		
		String result = classteacher.classdetails(queryClass, e,  conn,"Taahira", scan1,  true);	
		System.out.println(result);
		assertEquals("Taahira",result);
	}
	@Test
	public void test_ClassTeacher_Case2() throws SQLException {
		ClassTeacher classteacher = new ClassTeacher();
		Scanner scan1 = new Scanner("2");
		when(e.execute1stquery(rs,7)).thenReturn("Viti");		
		String result = classteacher.classdetails(queryClass, e, conn,"Viti", scan1,  true);	
		System.out.println(result);
		assertEquals("Viti",result);
	}
	@Test
	public void test_ClassTeacher_Case3() throws SQLException {
		ClassTeacher classteacher = new ClassTeacher();
		Scanner scan1 = new Scanner("3");
		when(e.execute1stquery(rs,8)).thenReturn("Pavati");		
		String result = classteacher.classdetails(queryClass, e, conn,"Pavati", scan1,  true);	
		System.out.println(result);
		assertEquals("Pavati",result);
	}
	@Test
	public void test_ClassTeacher_Case4() throws SQLException {
		ClassTeacher classteacher = new ClassTeacher();
		Scanner scan1 = new Scanner("4");
		when(e.execute1stquery(rs,9)).thenReturn("taara");		
		String result = classteacher.classdetails(queryClass, e, conn, "taara",scan1,  true);	
		System.out.println(result);
		assertEquals("taara",result);
	}
	@Test
	public void test_ClassTeacher_Case5() throws SQLException {
		ClassTeacher classteacher = new ClassTeacher();
		Scanner scan1 = new Scanner("5");
		when(e.execute1stquery(rs,10)).thenReturn("Rebecca");		
		String result = classteacher.classdetails(queryClass, e, conn, "Rebecca",scan1,  true);	
		System.out.println(result);
		assertEquals("Rebecca",result);
	}


}
