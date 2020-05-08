package jdbc.schoolschema;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentTopperClass {
	static String sql;
	public static String classTopper() {
		 return sql = "select StudentName,marks from(\r\n" + 
		   	 		"select  c.name as ClassName,s.name as StudentName,sum(marks) as marks, dense_rank() over( partition by c.name order by sum(marks) desc) Topper\r\n" + 
		   	 		"from marks m\r\n" + 
		   	 		"join student s\r\n" + 
		   	 		"on m.student_id=s.id\r\n" + 
		   	 		"join class c\r\n" + 
		   	 		"on s.class_name=c.name\r\n" + 
		   	 	    "where c.name=?\r\n"+
		   	 		"group by c.name,s.name)a  where topper=1\r\n" + 
		   	 		"\r\n";}

	public static void studentTopperMethod(Scanner sc, Connection conn) throws SQLException {
		while(true) {
  	      System.out.println("\nTopper student in each class");
  		  Menu.classMenu();
  		  int ch=sc.nextInt();
  		  sql=classTopper(); 
  		  ResultSet rs=null;
  	      PreparedStatement stmt=conn.prepareStatement(sql);
  		  subStudentMethod(stmt,ch,rs);
  		  if(ch==12) {
  			  break;
  		    }
  	       }
		
	}

	private static void subStudentMethod(PreparedStatement stmt, int ch, ResultSet rs) throws SQLException {
		switch(ch) {
		case 1:stmt.setInt(1,6);
	          rs = stmt.executeQuery();
	          getClassTopper(rs,6);break;
		case 2:stmt.setInt(1,7);
	          rs = stmt.executeQuery();
	          getClassTopper(rs,7);break;
		case 3:stmt.setInt(1,8);
	          rs = stmt.executeQuery();
	          getClassTopper(rs,8);break;
		 case 4:stmt.setInt(1,9);
	          rs = stmt.executeQuery();
	          getClassTopper(rs,9);break;
		 case 5:stmt.setInt(1,10);
	          rs = stmt.executeQuery();
	          getClassTopper(rs,10);break;
	      default:break;
		  }
	}

	private static void getClassTopper(ResultSet rs, int i) throws SQLException {
	System.out.println("The topper in the class name "+i+" is:");
	while(rs.next()) {
		    System.out.print("Student name: "+rs.getString("StudentName")+", Marks: "+rs.getInt("marks"));
		    System.out.println();
		}
	}
}
