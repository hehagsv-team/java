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

public class ClassTeacherClassTest {

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
public void subClassTeacher_Case1() throws Exception{
	ClassTeacherClass tc=new ClassTeacherClass();
	int ch=1;
	when(rs.next()).thenReturn(true);
	when(rs.getString("name")).thenReturn("rebecca");
	when(rs.getString("no_subject")).thenReturn("Biology");
	String result=ClassTeacherClass.subClassTeacher(ch,stmt);
	assertEquals("rebecca-Biology",result);
}
@Test
public void subClassTeacher_Case2() throws Exception{
	ClassTeacherClass tc=new ClassTeacherClass();
	int ch=2;
	when(rs.next()).thenReturn(true);
	when(rs.getString("name")).thenReturn("tahira");
	when(rs.getString("no_subject")).thenReturn("History");
	String result=ClassTeacherClass.subClassTeacher(ch,stmt);
	assertEquals("tahira-History",result);
}
@Test
public void subClassTeacher_Case3() throws Exception{
	ClassTeacherClass tc=new ClassTeacherClass();
	int ch=3;
	when(rs.next()).thenReturn(true);
	when(rs.getString("name")).thenReturn("tanvi");
	when(rs.getString("no_subject")).thenReturn("Chemistry");
	String result=ClassTeacherClass.subClassTeacher(ch,stmt);
	assertEquals("tanvi-Chemistry",result);
}
@Test
public void subClassTeacher_Case4() throws Exception{
	ClassTeacherClass tc=new ClassTeacherClass();
	int ch=4;
	when(rs.next()).thenReturn(true);
	when(rs.getString("name")).thenReturn("taara");
	when(rs.getString("no_subject")).thenReturn("Physics");
	String result=ClassTeacherClass.subClassTeacher(ch,stmt);
	assertEquals("taara-Physics",result);
}
@Test
public void invalidBoundaryTest() throws Exception{
	ClassTeacherClass tc=new ClassTeacherClass();
	int ch=0;
	String result=ClassTeacherClass.subClassTeacher(ch,stmt);
	assertEquals("invalid",result);
	
	}

@Test
public void validBoundaryTest() throws Exception{
	ClassTeacherClass tc=new ClassTeacherClass();
	int ch=5;
	String result=ClassTeacherClass.subClassTeacher(ch,stmt);
	assertEquals("valid",result);
	}
@Test
public void testWhileExit() throws Exception{
	ClassTeacherClass ctc=new ClassTeacherClass();
	Scanner sc=new Scanner("12");
	String result=ClassTeacherClass.classTeacherMethod(sc, conn);
	assertEquals("exit",result);
}

}

