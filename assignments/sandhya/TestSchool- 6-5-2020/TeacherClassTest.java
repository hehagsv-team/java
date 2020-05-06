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

public class TeacherClassTest {

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
public void test5() throws Exception{
	TeacherClass tc=new TeacherClass();
	int ch=5;
	when(rs.getString("name")).thenReturn("rebecca");
	String result=TeacherClass.subTeacherClassMethod(ch, stmt);
	assertEquals("rebecca",result);
}
@Test
public void test1() throws Exception{
	TeacherClass tc=new TeacherClass();
	int ch=1;
	when(rs.getString("name")).thenReturn("tahira");
	String result=TeacherClass.subTeacherClassMethod(ch, stmt);
	assertEquals("tahira",result);
}
@Test
public void test2() throws Exception{
	TeacherClass tc=new TeacherClass();
	int ch=2;
	when(rs.getString("name")).thenReturn("tanvi");
	String result=TeacherClass.subTeacherClassMethod(ch, stmt);
	assertEquals("tanvi",result);
}
@Test
public void test4() throws Exception{
	TeacherClass tc=new TeacherClass();
	int ch=4;
	when(rs.getString("name")).thenReturn("taara");
	String result=TeacherClass.subTeacherClassMethod(ch, stmt);
	assertEquals("taara",result);
}
@Test
public void invalidBoundaryTest() throws Exception{
	TeacherClass tc=new TeacherClass();
	int ch=0;
	String result=TeacherClass.subTeacherClassMethod(ch, stmt);
	assertEquals("invalid",result);
	}

@Test
public void validBoundaryTest() throws Exception{
	TeacherClass tc=new TeacherClass();
	int ch=3;
	String result=TeacherClass.subTeacherClassMethod(ch, stmt);
	assertEquals("valid",result);
	}
@Test
public void testWhileExit() throws Exception{
	TeacherClass tc=new TeacherClass();
	Scanner sc=new Scanner("12");
	String result=TeacherClass.teacherClassMethod(sc, conn);
	assertEquals("exit",result);
}

}

