package jdbc.schoolschema;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SubjectTopperClass {
	static String sql;
	public static String subjectTopper() {
		return sql = "select subjectName,name,marks from(\r\n" + 
				"select  c.name as ClassName,s.name as subjectName,t.name as name,marks, dense_rank() over( partition by s.name order by marks desc) Topper\r\n" + 
				"from marks m\r\n" + 
				"join subject s\r\n" + 
				"on m.subject_id=s.id\r\n" + 
				"join class c\r\n" + 
				"on s.class_name=c.name\r\n" + 
				"join student t\r\n" + 
				"on t.id=m.student_id\r\n" + 
				"where c.name=? and s.name=?)a  where topper=1";
	}	
	public static void subjectTopperMethod(Scanner sc, Connection conn) throws SQLException {
		while(true) {
      	  System.out.println("\nTopper student in each subject for each class");
  		  Menu.classMenu();
  		  int ch=sc.nextInt();
  		  sql=subjectTopper();
  		  ResultSet rs=null;
  	      PreparedStatement stmt=conn.prepareStatement(sql);
  		  subTopperMethod(ch,stmt,rs,sc);
  		  if(ch==12) {
  			  break;
  		     }
  	      }
		
	}
	private static void subTopperMethod(int ch, PreparedStatement stmt, ResultSet rs, Scanner sc) throws SQLException {
		switch(ch) {
		  case 1:while(true) {
			  ch=subjectMethod(sc);
			  stmt.setInt(1,6);
			  subjectTopper(stmt,ch,rs);
			  if(ch==11) break;
			  }break;
		  case 2:while(true) {
			  ch=subjectMethod(sc);
			  stmt.setInt(1,7);
			  subjectTopper(stmt,ch,rs);
			  if(ch==11) break;
			  }break;
		  case 3:while(true) {
			  ch=subjectMethod(sc);
			  stmt.setInt(1,8);
			  subjectTopper(stmt,ch,rs);
			  if(ch==11) break;
			  }break;
		  case 4:while(true) {
			  ch=subjectMethod(sc);
			  stmt.setInt(1,9);
			  subjectTopper(stmt,ch,rs);
			  if(ch==11) break;
			  }break;
		  case 5:while(true) {
			  ch=subjectMethod(sc);
			  stmt.setInt(1,10);
			  subjectTopper(stmt,ch,rs);
			  if(ch==11) break;
		       }break;
	      default:break;
		}
		  }
	
	private static int subjectMethod(Scanner sc) {
			  Menu.subjectMenu();
			  System.out.println("11: To return main menu:");
			  int ch=sc.nextInt();
			  return ch;
			}
	
	private static void subjectTopper(PreparedStatement stmt, int ch, ResultSet rs) throws SQLException {
	  	  switch(ch) {
	  	  case 1:stmt.setString(2,"PHYSICS");
	      	  	getSubjectTopper(stmt,rs);break;
	  	  case 2:stmt.setString(2,"CHEMISTRY");
	  	  		 getSubjectTopper(stmt,rs);break;
	  	  case 3:stmt.setString(2,"BIOLOGY");
	  	         getSubjectTopper(stmt,rs);break; 
	  	  case 4:stmt.setString(2,"HISTORY");
	  	         getSubjectTopper(stmt,rs);break; 
	  	  case 5:stmt.setString(2,"GEOGRAPHY");
	  	         getSubjectTopper(stmt,rs);break;
	  	  case 6:stmt.setString(2,"POLITICAL SCIENCE");
	  	         getSubjectTopper(stmt,rs);break; 
	  	  case 7:stmt.setString(2,"ECONOMICS");
	  	         getSubjectTopper(stmt,rs);break; 
	  	  case 8:stmt.setString(2,"ENGLISH");
	         	 getSubjectTopper(stmt,rs);break;
	  	  case 9:stmt.setString(2,"HINDI");
	  	         getSubjectTopper(stmt,rs);break;
	   	  case 10:stmt.setString(2,"MATHS");
	           	 getSubjectTopper(stmt,rs);break;
	      default: break;
	  	  }  
	  }
	
	private static void getSubjectTopper(PreparedStatement stmt, ResultSet rs) throws SQLException {
		rs = stmt.executeQuery();
		getSubjectTopperClass(rs);
	}
	
	private static void getSubjectTopperClass(ResultSet rs) throws SQLException {
		System.out.println("The topper in the subject  is:");
		while(rs.next()) {
			    System.out.print("Subject name: "+rs.getString("subjectName")+", Student name: "+rs.getString("name")+", Marks: "+rs.getInt("marks"));
			    System.out.println();
			}		
		}


}
