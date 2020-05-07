

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ClassTeacherClass {
	static String sql;
	public static String classTeacherSub() {
		return sql = "select t.name,s.name as no_subject\r\n" + 
	 	 		"from subject s\r\n" + 
	 	 		"join teacher t\r\n" + 
	 	 		"on s.teacher_id=t.id\r\n" + 
	 	 		"join class c\r\n" + 
	 	 		"on c.teacher_id=t.id\r\n" + 
	 	 	    "where c.name=?\r\n"+
	 	 		"group by t.name,s.name\r\n";
	}
	public static void classTeacherMethod(Scanner sc, Connection conn) throws SQLException {
	      while(true) {
	      System.out.println("\nWhich all subjects does a class teacher teach is");
		  Menu.classMenu();
		  int ch=sc.nextInt();
		  sql=classTeacherSub();
		  ResultSet rs=null;
	      PreparedStatement stmt=conn.prepareStatement(sql);
		  subClassTeacher(ch,stmt,rs);
		  if(ch==12) {
			  break;
		    }
	      }
	}
	private static void subClassTeacher(int ch, PreparedStatement stmt, ResultSet rs) throws SQLException {
		 switch(ch) {
		 case 1:stmt.setInt(1,6);
	          rs = stmt.executeQuery();
	          getClassTeacher(rs,6);  break;
		  case 2:stmt.setInt(1,7);
	          rs = stmt.executeQuery();
	          getClassTeacher(rs,7);  break;
		  case 3:stmt.setInt(1,8);
	          rs = stmt.executeQuery();
	          getClassTeacher(rs,8);  break;
		  case 4:stmt.setInt(1,9);
	          rs = stmt.executeQuery();
	          getClassTeacher(rs,9);  break;
		  case 5:stmt.setInt(1,10);
	          rs = stmt.executeQuery();
	          getClassTeacher(rs,10);
	          System.out.println("null");  break;
	      default:  break;
		  }
	}
	private static void getClassTeacher(ResultSet rs, int i) throws SQLException {
		System.out.println("The class teacher of the class name "+i+" is:");
		while(rs.next()) {
			    System.out.print("Classteacher name: "+rs.getString("name")+", Subject name: "+rs.getString("no_subject"));
			    System.out.println();
			}
		}
}