package com.schoolschema.Testjunit.schoolschema;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class StudentTopperClassTest {

@Mock
private Connection conn;
@Mock
private PreparedStatement stmt;
@Mock
private ResultSet rs;

@Before
public void setUp() throws Exception {
	MockitoAnnotations.initMocks(this);
	when(conn.prepareStatement(any(String.class))).thenReturn(stmt);
	when(stmt.executeQuery()).thenReturn(rs);	
}
@Test
public void test1() throws Exception{
	StudentTopperClass stc=new StudentTopperClass();
	int ch=1;
	when(rs.next()).thenReturn(true);
	when(rs.getString("StudentName")).thenReturn("Anvar");
	when(rs.getInt("marks")).thenReturn(1185);
	String result=StudentTopperClass.subStudentMethod(stmt, ch);
	assertEquals("Anvar-1185",result);
}
@Test
public void test2() throws Exception{
	StudentTopperClass stc=new StudentTopperClass();
	int ch=2;
	when(rs.next()).thenReturn(true);
	when(rs.getString("StudentName")).thenReturn("Anu");
	when(rs.getInt("marks")).thenReturn(1010);
	String result=StudentTopperClass.subStudentMethod(stmt, ch);
	assertEquals("Anu-1010",result);
}
@Test
public void test3() throws Exception{
	StudentTopperClass stc=new StudentTopperClass();
	int ch=3;
	when(rs.next()).thenReturn(true);
	when(rs.getString("StudentName")).thenReturn("Gowthu");
	when(rs.getInt("marks")).thenReturn(900);
	String result=StudentTopperClass.subStudentMethod(stmt, ch);
	assertEquals("Gowthu-900",result);
}
@Test
public void test4() throws Exception{
	StudentTopperClass stc=new StudentTopperClass();
	int ch=4;
	when(rs.next()).thenReturn(true);
	when(rs.getString("StudentName")).thenReturn("Harika");
	when(rs.getInt("marks")).thenReturn(1085);
	String result=StudentTopperClass.subStudentMethod(stmt, ch);
	assertEquals("Harika-1085",result);
}
@Test
public void invalidBoundaryTest() throws Exception{
	StudentTopperClass stc=new StudentTopperClass();
	int ch=0;
	String result=StudentTopperClass.subStudentMethod(stmt, ch);
	assertEquals("invalid",result);
	}

@Test
public void validBoundaryTest() throws Exception{
	StudentTopperClass stc=new StudentTopperClass();
	int ch=5;
	String result=StudentTopperClass.subStudentMethod(stmt, ch);
	assertEquals("valid",result);
	}
@Test
public void testWhileExit() throws Exception{
	StudentTopperClass stc=new StudentTopperClass();
	Scanner sc=new Scanner("12");
	String result=StudentTopperClass.studentTopperMethod(sc,conn);
	assertEquals("exit",result);
}

}

