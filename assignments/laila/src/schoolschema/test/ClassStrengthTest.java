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

public class ClassStrengthTest {
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
public void subClassMethod_Case1() throws Exception{
	ClassStrength cs=new ClassStrength();
	int ch=1;
	when(rs.next()).thenReturn(true);
	when(rs.getInt("count(*)")).thenReturn(20);
	int result=ClassStrength.subClassMethod(stmt, ch);
	assertEquals(20,result);
}
@Test
public void subClassMethod_Case2() throws Exception{
	ClassStrength cs=new ClassStrength();
	int ch=2;
	when(rs.next()).thenReturn(true);
	when(rs.getInt("count(*)")).thenReturn(30);
	int result=ClassStrength.subClassMethod(stmt, ch);
	assertEquals(30,result);
}
@Test
public void subClassMethod_Case3() throws Exception{
	ClassStrength cs=new ClassStrength();
	int ch=3;
	when(rs.next()).thenReturn(true);
	when(rs.getInt("count(*)")).thenReturn(22);
	int result=ClassStrength.subClassMethod(stmt, ch);
	assertEquals(22,result);
}
@Test
public void subClassMethod_Case4() throws Exception{
	ClassStrength cs=new ClassStrength();
	int ch=4;
	when(rs.next()).thenReturn(true);
	when(rs.getInt("count(*)")).thenReturn(20);
	int result=ClassStrength.subClassMethod(stmt, ch);
	assertEquals(20,result);
}
@Test
public void invalidBoundaryTest() throws Exception{
	ClassStrength cs=new ClassStrength();
	int ch=0;
	int result=ClassStrength.subClassMethod(stmt, ch);
	assertEquals(0,result);
	}
@Test
public void testWhileExit() throws Exception{
	ClassStrength cs=new ClassStrength();
	Scanner sc=new Scanner("12");
	String result=ClassStrength.classStrengthMethod(sc, conn);
	assertEquals("exit",result);
}
@Test
public void validBoundaryTest() throws Exception{
	ClassStrength cs=new ClassStrength();
	int ch=5;
	int result=ClassStrength.subClassMethod(stmt, ch);
	assertEquals(1,result);
	}
}
