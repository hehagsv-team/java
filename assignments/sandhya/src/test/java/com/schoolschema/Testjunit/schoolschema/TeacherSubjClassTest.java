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

public class TeacherSubjClassTest {

@Mock
private Connection conn;
@Mock
private PreparedStatement stmt;
@Mock
private ResultSet rs;

@Before
public void beforeEachTest_Method() throws Exception {
	MockitoAnnotations.initMocks(this);
	when(conn.prepareStatement(any(String.class))).thenReturn(stmt);
	when(stmt.executeQuery()).thenReturn(rs);	
}
@Test
public void getTeacherSubjMethod_Case1() throws Exception{
	TeacherSubjClass stc=new TeacherSubjClass();
	int ch=1;
	when(rs.next()).thenReturn(true);
	when(rs.getString("teacher")).thenReturn("anvar");
	when(rs.getInt("class")).thenReturn(6);
	when(rs.getInt("Average")).thenReturn(84);
	String result=TeacherSubjClass.getTeacherSubjMethod(ch, stmt);
	assertEquals("6-84-anvar",result);
}
@Test
public void getTeacherSubjMethod_Case2() throws Exception{
	TeacherSubjClass stc=new TeacherSubjClass();
	int ch=2;
	when(rs.next()).thenReturn(true);
	when(rs.getString("teacher")).thenReturn("Anu");
	when(rs.getInt("class")).thenReturn(8);
	when(rs.getInt("Average")).thenReturn(83);
	String result=TeacherSubjClass.getTeacherSubjMethod(ch, stmt);
	assertEquals("8-83-Anu",result);
}
@Test
public void getTeacherSubjMethod_Case3() throws Exception{
	TeacherSubjClass stc=new TeacherSubjClass();
	int ch=3;
	when(rs.next()).thenReturn(true);
	when(rs.getString("teacher")).thenReturn("ryka");
	when(rs.getInt("class")).thenReturn(7);
	when(rs.getInt("Average")).thenReturn(87);
	String result=TeacherSubjClass.getTeacherSubjMethod(ch, stmt);
	assertEquals("7-87-ryka",result);
}
@Test
public void getTeacherSubjMethod_Case4() throws Exception{
	TeacherSubjClass stc=new TeacherSubjClass();
	int ch=4;
	when(rs.next()).thenReturn(true);
	when(rs.getString("teacher")).thenReturn("taara");
	when(rs.getInt("class")).thenReturn(6);
	when(rs.getInt("Average")).thenReturn(84);
	String result=TeacherSubjClass.getTeacherSubjMethod(ch, stmt);
	assertEquals("6-84-taara",result);
}
@Test
public void getTeacherSubjMethod_Case5() throws Exception{
	TeacherSubjClass stc=new TeacherSubjClass();
	int ch=5;
	when(rs.next()).thenReturn(true);
	when(rs.getString("teacher")).thenReturn("sai");
	when(rs.getInt("class")).thenReturn(10);
	when(rs.getInt("Average")).thenReturn(85);
	String result=TeacherSubjClass.getTeacherSubjMethod(ch, stmt);
	assertEquals("10-85-sai",result);
}
@Test
public void getTeacherSubjMethod_Case6() throws Exception{
	TeacherSubjClass stc=new TeacherSubjClass();
	int ch=6;
	when(rs.next()).thenReturn(true);
	when(rs.getString("teacher")).thenReturn("navya");
	when(rs.getInt("class")).thenReturn(9);
	when(rs.getInt("Average")).thenReturn(81);
	String result=TeacherSubjClass.getTeacherSubjMethod(ch, stmt);
	assertEquals("9-81-navya",result);
}
@Test
public void getTeacherSubjMethod_Case7() throws Exception{
	TeacherSubjClass stc=new TeacherSubjClass();
	int ch=7;
	when(rs.next()).thenReturn(true);
	when(rs.getString("teacher")).thenReturn("taara");
	when(rs.getInt("class")).thenReturn(8);
	when(rs.getInt("Average")).thenReturn(83);
	String result=TeacherSubjClass.getTeacherSubjMethod(ch, stmt);
	assertEquals("8-83-taara",result);
}
@Test
public void getTeacherSubjMethod_Case8() throws Exception{
	TeacherSubjClass stc=new TeacherSubjClass();
	int ch=8;
	when(rs.next()).thenReturn(true);
	when(rs.getString("teacher")).thenReturn("rebecca");
	when(rs.getInt("class")).thenReturn(7);
	when(rs.getInt("Average")).thenReturn(84);
	String result=TeacherSubjClass.getTeacherSubjMethod(ch, stmt);
	assertEquals("7-84-rebecca",result);
}
@Test
public void getTeacherSubjMethod_Case9() throws Exception{
	TeacherSubjClass stc=new TeacherSubjClass();
	int ch=9;
	when(rs.next()).thenReturn(true);
	when(rs.getString("teacher")).thenReturn("tahira");
	when(rs.getInt("class")).thenReturn(6);
	when(rs.getInt("Average")).thenReturn(94);
	String result=TeacherSubjClass.getTeacherSubjMethod(ch, stmt);
	assertEquals("6-94-tahira",result);
}
@Test
public void invalidBoundaryTest() throws Exception{
	TeacherSubjClass stc=new TeacherSubjClass();
	int ch=0;
	String result=TeacherSubjClass.getTeacherSubjMethod(ch, stmt);
	assertEquals("invalid",result);
	}

@Test
public void validBoundaryTest() throws Exception{
	TeacherSubjClass stc=new TeacherSubjClass();
	int ch=10;
	String result=TeacherSubjClass.getTeacherSubjMethod(ch, stmt);
	assertEquals("valid",result);
	}
@Test
public void testWhileExit() throws Exception{
	TeacherSubjClass stc=new TeacherSubjClass();
	Scanner sc=new Scanner("12");
	String result=TeacherSubjClass.teacherSubjMethod(sc, conn);
	assertEquals("exit",result);
}

}

