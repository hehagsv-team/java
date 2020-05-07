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

public class SubjectTopperClassTest {

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
	SubjectTopperClass stc=new SubjectTopperClass();
	int ch=1;
	when(rs.next()).thenReturn(true);
	when(rs.getString("name")).thenReturn("Anu");
	when(rs.getString("subjectName")).thenReturn("Physics");
	when(rs.getInt("marks")).thenReturn(96);
	String result=SubjectTopperClass.subjectTopper(stmt, ch);
	assertEquals("Physics-Anu-96",result);
}
@Test
public void test2() throws Exception{
	SubjectTopperClass stc=new SubjectTopperClass();
	int ch=2;
	when(rs.next()).thenReturn(true);
	when(rs.getString("name")).thenReturn("laila");
	when(rs.getString("subjectName")).thenReturn("Chemistry");
	when(rs.getInt("marks")).thenReturn(93);
	String result=SubjectTopperClass.subjectTopper(stmt, ch);
	assertEquals("Chemistry-laila-93",result);
}
@Test
public void test3() throws Exception{
	SubjectTopperClass stc=new SubjectTopperClass();
	int ch=3;
	when(rs.next()).thenReturn(true);
	when(rs.getString("name")).thenReturn("san");
	when(rs.getString("subjectName")).thenReturn("BIOLOGY");
	when(rs.getInt("marks")).thenReturn(90);
	String result=SubjectTopperClass.subjectTopper(stmt, ch);
	assertEquals("BIOLOGY-san-90",result);
}
@Test
public void test4() throws Exception{
	SubjectTopperClass stc=new SubjectTopperClass();
	int ch=4;
	when(rs.next()).thenReturn(true);
	when(rs.getString("name")).thenReturn("hemadri");
	when(rs.getString("subjectName")).thenReturn("HISTORY");
	when(rs.getInt("marks")).thenReturn(94);
	String result=SubjectTopperClass.subjectTopper(stmt, ch);
	assertEquals("HISTORY-hemadri-94",result);
}
@Test
public void test5() throws Exception{
	SubjectTopperClass stc=new SubjectTopperClass();
	int ch=5;
	when(rs.next()).thenReturn(true);
	when(rs.getString("name")).thenReturn("Varun");
	when(rs.getString("subjectName")).thenReturn("GEOGRAPHY");
	when(rs.getInt("marks")).thenReturn(92);
	String result=SubjectTopperClass.subjectTopper(stmt, ch);
	assertEquals("GEOGRAPHY-Varun-92",result);
}
@Test
public void test6() throws Exception{
	SubjectTopperClass stc=new SubjectTopperClass();
	int ch=6;
	when(rs.next()).thenReturn(true);
	when(rs.getString("name")).thenReturn("Harika");
	when(rs.getString("subjectName")).thenReturn("POLITICAL SCIENCE");
	when(rs.getInt("marks")).thenReturn(93);
	String result=SubjectTopperClass.subjectTopper(stmt, ch);
	assertEquals("POLITICAL SCIENCE-Harika-93",result);
}
@Test
public void test7() throws Exception{
	SubjectTopperClass stc=new SubjectTopperClass();
	int ch=7;
	when(rs.next()).thenReturn(true);
	when(rs.getString("name")).thenReturn("Sony");
	when(rs.getString("subjectName")).thenReturn("ECONOMICS");
	when(rs.getInt("marks")).thenReturn(90);
	String result=SubjectTopperClass.subjectTopper(stmt, ch);
	assertEquals("ECONOMICS-Sony-90",result);
}
@Test
public void test8() throws Exception{
	SubjectTopperClass stc=new SubjectTopperClass();
	int ch=8;
	when(rs.next()).thenReturn(true);
	when(rs.getString("name")).thenReturn("Gowthu");
	when(rs.getString("subjectName")).thenReturn("ENGLISH");
	when(rs.getInt("marks")).thenReturn(91);
	String result=SubjectTopperClass.subjectTopper(stmt, ch);
	assertEquals("ENGLISH-Gowthu-91",result);
}
@Test
public void test9() throws Exception{
	SubjectTopperClass stc=new SubjectTopperClass();
	int ch=9;
	when(rs.next()).thenReturn(true);
	when(rs.getString("name")).thenReturn("Anvar");
	when(rs.getString("subjectName")).thenReturn("HINDI");
	when(rs.getInt("marks")).thenReturn(85);
	String result=SubjectTopperClass.subjectTopper(stmt, ch);
	assertEquals("HINDI-Anvar-85",result);
}
@Test
public void invalidBoundaryTestSubject() throws Exception{
	SubjectTopperClass stc=new SubjectTopperClass();
	int ch=0;
	String result=SubjectTopperClass.subjectTopper(stmt, ch);
	assertEquals("invalid",result);
	}

@Test
public void validBoundaryTestSubject() throws Exception{
	SubjectTopperClass stc=new SubjectTopperClass();
	int ch=10;
	String result=SubjectTopperClass.subjectTopper(stmt, ch);
	assertEquals("valid",result);
	}
@Test
public void testWhileExitMain() throws Exception{
	SubjectTopperClass stc=new SubjectTopperClass();
	Scanner sc=new Scanner("12");
	String result=SubjectTopperClass.subjectTopperMethod(sc,conn);
	assertEquals("exit",result);
}

}

