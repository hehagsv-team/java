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

public class AvgMarkClassTest {

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
public void subAvgMarksMethod_Case1() throws Exception{
	AvgMarkClass avg=new AvgMarkClass();
	int ch=1;
	when(rs.next()).thenReturn(true);
	when(rs.getInt("Average")).thenReturn(74);
	int result=AvgMarkClass.subAvgMarksMethod(ch, stmt);
	assertEquals(74,result);
}
@Test
public void subAvgMarksMethod_Case2() throws Exception{
	AvgMarkClass avg=new AvgMarkClass();
	int ch=2;
	when(rs.next()).thenReturn(true);
	when(rs.getInt("Average")).thenReturn(73);
	int result=AvgMarkClass.subAvgMarksMethod(ch, stmt);
	assertEquals(73,result);
}
@Test
public void subAvgMarksMethod_Case3() throws Exception{
	AvgMarkClass avg=new AvgMarkClass();
	int ch=3;
	when(rs.next()).thenReturn(true);
	when(rs.getInt("Average")).thenReturn(72);
	int result=AvgMarkClass.subAvgMarksMethod(ch, stmt);
	assertEquals(72,result);
}
@Test
public void subAvgMarksMethod_Case4() throws Exception{
	AvgMarkClass avg=new AvgMarkClass();
	int ch=4;
	when(rs.next()).thenReturn(true);
	when(rs.getInt("Average")).thenReturn(74);
	int result=AvgMarkClass.subAvgMarksMethod(ch, stmt);
	assertEquals(74,result);
}
@Test
public void invalidBoundaryTest() throws Exception{
	AvgMarkClass avg=new AvgMarkClass();
	int ch=0;
	int result=AvgMarkClass.subAvgMarksMethod(ch, stmt);
	System.out.println("False represents 0");
	assertEquals(0,result);
	}

@Test
public void validBoundaryTest() throws Exception{
	AvgMarkClass avg=new AvgMarkClass();
	int ch=5;
	int result=AvgMarkClass.subAvgMarksMethod(ch, stmt);
	System.out.println("True represents 1");
	assertEquals(1,result);
	}
@Test
public void testWhileExit() throws Exception{
	AvgMarkClass avg=new AvgMarkClass();
	Scanner sc=new Scanner("12");
	String result=AvgMarkClass.averageMarkClassMethod(sc, conn);
	assertEquals("exit",result);
}

}

