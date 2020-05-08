package jdbc.schoolschema;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SchoolSchema {	
	public static void main(String[] args) throws SQLException, ClassNotFoundException { 
		  Connection conn = null; 
		  PreparedStatement stmt=null;
	      Class.forName("org.h2.Driver"); 
	       conn = DriverManager.getConnection("jdbc:h2:~/test","sa",""); 
		   Scanner sc = new Scanner(System.in);
	        while(true) {   
	        	 Menu.menu();
		         int ch = sc.nextInt();
	             switch(ch) {
	             case 1: TeacherClass.teacherClassMethod(sc,conn);
	            	     break;
	              case 2: AvgMarkClass.averageMarkClassMethod(sc,conn);
	            	      break;
	              case 3: MarkDistClass.markDistMethod(sc,conn);
	            	  	  break;
	              case 4:TeacherSubjClass.teacherSubjMethod(sc,conn);
	            	      break; 
	              case 5:StudentTopperClass.studentTopperMethod(sc,conn);
	            	       break;
	              case 6:SubjectTopperClass.subjectTopperMethod(sc,conn);
	            	      break;
	              case 7:ClassTeacherClass.classTeacherMethod(sc,conn);
	            	      break;
	              case 8:TeacherSubjectDistClass.subjectDistMethod(sc,conn);
                          break;
	              case 9:ClassStrength.classStrengthMethod(sc,conn);
	            	       break;
	 	          default: break;
	              }	  
	              if(ch==11)  {
	            	  System.out.println("program is ended");
	            	  break;
	              }	
	        }
	        stmt.close(); 
		    conn.close(); 
	}
}
	
	
	
