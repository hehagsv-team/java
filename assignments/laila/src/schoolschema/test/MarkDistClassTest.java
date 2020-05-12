package schoolschema.Log4j;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class MarkDistClassTest {
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
public void subMarkDistMethod_Case1() throws Exception{
	MarkDistClass mds=new MarkDistClass();
	int ch=1;
	when(rs.next()).thenReturn(true);
	when(rs.getString("marks")).thenReturn("50-59");
	when(rs.getInt("count(*)")).thenReturn(8);
	String result=MarkDistClass.subMarkDistMethod(ch, stmt);
	assertEquals("50-59,8",result);
}
@Test
public void subMarkDistMethod_Case2() throws Exception{
	MarkDistClass mds=new MarkDistClass();
	int ch=2;
	when(rs.next()).thenReturn(true);
	when(rs.getString("marks")).thenReturn("60-69");
	when(rs.getInt("count(*)")).thenReturn(10);
	String result=MarkDistClass.subMarkDistMethod(ch, stmt);
	assertEquals("60-69,10",result);
}
@Test
public void subMarkDistMethod_Case3() throws Exception{
	MarkDistClass mds=new MarkDistClass();
	int ch=3;
	when(rs.next()).thenReturn(true);
	when(rs.getString("marks")).thenReturn("70-79");
	when(rs.getInt("count(*)")).thenReturn(9);
	String result=MarkDistClass.subMarkDistMethod(ch, stmt);
	assertEquals("70-79,9",result);
}
@Test
public void subMarkDistMethod_Case4() throws Exception{
	MarkDistClass mds=new MarkDistClass();
	int ch=4;
	when(rs.next()).thenReturn(true);
	when(rs.getString("marks")).thenReturn("50-59");
	when(rs.getInt("count(*)")).thenReturn(12);
	String result=MarkDistClass.subMarkDistMethod(ch, stmt);
	assertEquals("50-59,12",result);
}
@Test
public void subMarkDistMethod_Case5() throws Exception{
	MarkDistClass mds=new MarkDistClass();
	int ch=5;
	when(rs.next()).thenReturn(true);
	when(rs.getString("marks")).thenReturn("50-59");
	when(rs.getInt("count(*)")).thenReturn(9);
	String result=MarkDistClass.subMarkDistMethod(ch, stmt);
	assertEquals("50-59,9",result);
}
@Test
public void subMarkDistMethod_Case6() throws Exception{
	MarkDistClass mds=new MarkDistClass();
	int ch=6;
	when(rs.next()).thenReturn(true);
	when(rs.getString("marks")).thenReturn("50-59");
	when(rs.getInt("count(*)")).thenReturn(10);
	String result=MarkDistClass.subMarkDistMethod(ch, stmt);
	assertEquals("50-59,10",result);
}
@Test
public void subMarkDistMethod_Case7() throws Exception{
	MarkDistClass mds=new MarkDistClass();
	int ch=7;
	when(rs.next()).thenReturn(true);
	when(rs.getString("marks")).thenReturn("50-59");
	when(rs.getInt("count(*)")).thenReturn(15);
	String result=MarkDistClass.subMarkDistMethod(ch, stmt);
	assertEquals("50-59,15",result);
}
@Test
public void subMarkDistMethod_Case8() throws Exception{
	MarkDistClass mds=new MarkDistClass();
	int ch=8;
	when(rs.next()).thenReturn(true);
	when(rs.getString("marks")).thenReturn("50-59");
	when(rs.getInt("count(*)")).thenReturn(12);
	String result=MarkDistClass.subMarkDistMethod(ch, stmt);
	assertEquals("50-59,12",result);
}
@Test
public void subMarkDistMethod_Case9() throws Exception{
	MarkDistClass mds=new MarkDistClass();
	int ch=9;
	when(rs.next()).thenReturn(true);
	when(rs.getString("marks")).thenReturn("50-59");
	when(rs.getInt("count(*)")).thenReturn(16);
	String result=MarkDistClass.subMarkDistMethod(ch, stmt);
	assertEquals("50-59,16",result);
}
@Test
public void invalidBoundaryTest() throws Exception{
	MarkDistClass mds=new MarkDistClass();
	int ch=0;
	String result=MarkDistClass.subMarkDistMethod(ch, stmt);
	assertEquals("invalid",result);
	}

@Test
public void validBoundaryTest() throws Exception{
	MarkDistClass mds=new MarkDistClass();
	int ch=10;
	String result=MarkDistClass.subMarkDistMethod(ch, stmt);
	assertEquals("valid",result);
	}
@Test
public void testWhileExit() throws Exception{
	MarkDistClass mds=new MarkDistClass();
	Scanner sc=new Scanner("12");
	String result=MarkDistClass.markDistMethod(sc, conn);
	assertEquals("exit",result);
}

}