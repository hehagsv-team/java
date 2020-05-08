package jdbc.schoolschema;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class TeacherClass {
	public static String teacherClass() {
	     String sql;
		return sql = "select t.name\r\n" + 
	 	 		"from class c\r\n" + 
	 	 		"join teacher t\r\n" + 
	 	 		"on t.id=c.teacher_id\r\n" + 
	 	 		"where c.name=?";
	}

	public static void teacherClassMethod(Scanner sc, Connection conn) throws SQLException {
	while(true) {
  	  System.out.println("\nName of the teacher in  particular class is: ");
	  Menu.classMenu();
	  ResultSet rs = null;
  	  int ch=sc.nextInt();
  	  String sql=teacherClass(); 
  	  PreparedStatement stmt=conn.prepareStatement(sql);
	  subTeacherClassMethod(ch,stmt,rs); 
		  if(ch==12) {
			  break;
		   }
       }
	}

private static void subTeacherClassMethod(int ch, PreparedStatement stmt, ResultSet rs) throws SQLException {
	switch(ch) {
	  case 1: stmt.setInt(1,6);
              rs = stmt.executeQuery();
              getTeacherClass(rs,6); break;
	  case 2: stmt.setInt(1,7);
              rs = stmt.executeQuery();
              getTeacherClass(rs,7); break;
	  case 3: stmt.setInt(1,8);
              rs = stmt.executeQuery();
              getTeacherClass(rs,8); break;
	  case 4: stmt.setInt(1,9);
              rs = stmt.executeQuery();
              getTeacherClass(rs,9); break;
	  case 5: stmt.setInt(1,10);
              rs = stmt.executeQuery();
              getTeacherClass(rs,10); break;
     default:  break;  
	  }
}

private static void getTeacherClass(ResultSet rs, int i) throws SQLException {
	while(rs.next()) {
	    System.out.print("The name of the teacher in the particular class "+i+" is: "+rs.getString("name")+"\n");
	}

}	
}
