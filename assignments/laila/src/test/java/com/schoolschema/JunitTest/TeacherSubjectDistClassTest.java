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

public class TeacherSubjectDistClassTest {

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
public void subjectDistMethod() throws Exception{
	TeacherSubjectDistClass tc=new TeacherSubjectDistClass();
	int ch=5;
	when(rs.next()).thenReturn(true);
	when(rs.getString("name")).thenReturn("rebecca");
	when(rs.getInt("no_subject")).thenReturn(3);
	String result=TeacherSubjectDistClass.subjectDistMethod(conn);
	assertEquals("rebecca-3",result);
}

}
