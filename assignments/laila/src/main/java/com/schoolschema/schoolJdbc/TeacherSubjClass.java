

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class TeacherSubjClass {
	static String sql;
	public static String teacherSubject() {
		return sql = "select class, Average,teacher from(\r\n" + 
				"select s.class_name as class,avg(marks) as Average,s.name ,t.name as teacher,dense_rank() over( partition by s.name order by avg(marks) desc) top\r\n" + 
				"from marks m \r\n" + 
				" join subject s \r\n" + 
				"on m.subject_id=s.id \r\n" + 
				"join teacher t\r\n" + 
				"on s.teacher_id=t.id\r\n" +
				"where s.name=?"+
				"group by s.class_name,s.name,t.name\r\n" + 
				")a where top=1";
	}

	public static  void teacherSubjMethod(Scanner sc, Connection conn) throws SQLException {
		while(true) {
  	      System.out.println("\nWhich teacher teaches a subject better");
      	  Menu.subjectMenu();
      	  System.out.println("12: To return main menu:");
      	  int ch=sc.nextInt();
      	  sql=teacherSubject(); 
      	  ResultSet rs = null;
  	      PreparedStatement stmt=conn.prepareStatement(sql);
  	      getTeacherSubjMethod(ch,stmt,rs);
 		  if(ch==12) {
 			  break;
 		     }
           }
	}
	private static void getTeacherSubjMethod(int ch, PreparedStatement stmt, ResultSet rs) throws SQLException {
		switch(ch) {
	   	  case 1:stmt.setString(1,"PHYSICS");
	       	     subTeacherMethod(rs,stmt);break;
	   	  case 2:stmt.setString(1,"CHEMISTRY");         		  
	   	         subTeacherMethod(rs,stmt);break;
	   	  case 3:stmt.setString(1,"BIOLOGY");
		         subTeacherMethod(rs,stmt);break;
	   	  case 4:stmt.setString(1,"HISTORY");
	             subTeacherMethod(rs,stmt);break;
	   	  case 5:stmt.setString(1,"GEOGRAPHY");
	             subTeacherMethod(rs,stmt);break;
	   	  case 6:stmt.setString(1,"POLITICAL SCIENCE");
	             subTeacherMethod(rs,stmt);break;
	   	  case 7:stmt.setString(1,"ECONOMICS");
	             subTeacherMethod(rs,stmt);break;
	   	  case 8:stmt.setString(1,"ENGLISH");
	             subTeacherMethod(rs,stmt);break;
	   	  case 9:stmt.setString(1,"HINDI");
	             subTeacherMethod(rs,stmt);break;
	   	  case 10:stmt.setString(1,"MATHS");
	              subTeacherMethod(rs,stmt);break;
	        default:break;
			  }
		}
	private static void subTeacherMethod(ResultSet rs, PreparedStatement stmt) throws SQLException {
		 rs = stmt.executeQuery();
		 getTeacherSubject(rs);
	}

	private static void getTeacherSubject(ResultSet rs) throws SQLException {
		System.out.print("The teacher who teaches the subject better is\n");		
	    while(rs.next()) {
	          System.out.println("Class:"+rs.getInt("class")+","+"Average:"+rs.getInt("Average")+","+"Teachers-name: "+rs.getString("teacher"));
	       } 
		}


}