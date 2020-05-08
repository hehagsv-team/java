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
public void beforeEachTest_Method() throws Exception {
	MockitoAnnotations.initMocks(this);
	when(conn.prepareStatement(any(String.class))).thenReturn(stmt);
	when(stmt.executeQuery()).thenReturn(rs);	
}
@Test
public void subjectTopper_Case1() throws Exception{
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
public void subjectTopper_Case2() throws Exception{
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
public void subjectTopper_Case3() throws Exception{
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
public void subjectTopper_Case4() throws Exception{
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
public void subjectTopper_Case5() throws Exception{
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
public void subjectTopper_Case6() throws Exception{
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
public void subjectTopper_Case7() throws Exception{
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
public void subjectTopper_Case8() throws Exception{
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
public void subjectTopper_Case9() throws Exception{
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
public void invalidBoundaryTest_subjectTopper() throws Exception{
	SubjectTopperClass stc=new SubjectTopperClass();
	int ch=0;
	String result=SubjectTopperClass.subjectTopper(stmt, ch);
	assertEquals("invalid",result);
	}

@Test
public void validBoundaryTest_subjectTopper() throws Exception{
	SubjectTopperClass stc=new SubjectTopperClass();
	int ch=10;
	String result=SubjectTopperClass.subjectTopper(stmt, ch);
	assertEquals("valid",result);
	}
@Test
public void whileExitMain() throws Exception{
	SubjectTopperClass stc=new SubjectTopperClass();
	Scanner sc=new Scanner("12");
	String result=SubjectTopperClass.subjectTopperMethod(sc,conn);
	assertEquals("exit",result);
}
@Test
public void whileExit_subTopperMethod() throws Exception{
	SubjectTopperClass stc=new SubjectTopperClass();
	Scanner sc=new Scanner("11");
	int ch=2;
	String result=SubjectTopperClass.subTopperMethod(ch,stmt,sc);
	assertEquals("exit",result);
	Scanner sc1=new Scanner("11");
	String result1=SubjectTopperClass.subTopperMethod(3,stmt,sc1);
	assertEquals("exit",result1);
	Scanner sc2=new Scanner("11");
	String result2=SubjectTopperClass.subTopperMethod(4,stmt,sc2);
	assertEquals("exit",result2);
	Scanner sc3=new Scanner("11");
	String result3=SubjectTopperClass.subTopperMethod(5,stmt,sc3);
	assertEquals("exit",result3);

}
@Test
public void validBoundaryCondition_SubTopperMethod() throws Exception{
	SubjectTopperClass stc=new SubjectTopperClass();
	Scanner sc=new Scanner("11");
	int ch=1;
	String result=SubjectTopperClass.subTopperMethod(ch,stmt,sc);
	assertEquals("valid",result);
}
@Test
public void invalidBoundaryCondition_SubTopperMethod() throws Exception{
	SubjectTopperClass stc=new SubjectTopperClass();
	Scanner sc=new Scanner("11");
	int ch=11;
	String result=SubjectTopperClass.subTopperMethod(ch,stmt,sc);
	assertEquals("invalid",result);
}
}

