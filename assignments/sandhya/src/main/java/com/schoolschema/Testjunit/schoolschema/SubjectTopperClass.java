package com.schoolschema.Testjunit.schoolschema;

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
	public static String subjectTopperMethod(Scanner sc, Connection conn) throws SQLException {
		String res="";
		while(true) {
      	  System.out.println("\nTopper student in each subject for each class");
  		  Menu.classMenu();
  		  int ch=sc.nextInt();
  		  System.out.println(ch);
  		  sql=subjectTopper();
  	      PreparedStatement stmt=conn.prepareStatement(sql);
  		  subTopperMethod(ch,stmt,sc);
  		  if(ch==12) {
  			  res="exit";
  			  break;
  		     }
  	      }
		return res;
		
	}
	private static void subTopperMethod(int ch, PreparedStatement stmt, Scanner sc) throws SQLException {
		String res="";
		switch(ch) {
		  case 1:while(true) {
			  ch=subjectMethod(sc);
			  stmt.setInt(1,6);
			  res=subjectTopper(stmt,ch);
			  if(ch==11) break;
			  }break;
		  case 2:while(true) {
			  ch=subjectMethod(sc);
			  stmt.setInt(1,7);
			  subjectTopper(stmt,ch);
			  if(ch==11) break;
			  }break;
		  case 3:while(true) {
			  ch=subjectMethod(sc);
			  stmt.setInt(1,8);
			  subjectTopper(stmt,ch);
			  if(ch==11) break;
			  }break;
		  case 4:while(true) {
			  ch=subjectMethod(sc);
			  stmt.setInt(1,9);
			  subjectTopper(stmt,ch);
			  if(ch==11) break;
			  }break;
		  case 5:while(true) {
			  ch=subjectMethod(sc);
			  stmt.setInt(1,10);
			  subjectTopper(stmt,ch);
			  if(ch==11) break;
		       }break;
	      default:break;
		}
		  }
	
	private static int subjectMethod(Scanner sc) {
			  Menu.subjectMenu();
			  System.out.println("11: To return main menu:");
			  int ch;
	  		  if(sc.hasNext()) {
		  	    	ch=Integer.valueOf(sc.nextLine()).intValue();
				
		  	    } 
		  	    else {
		  	    	ch = sc.nextInt();
		  	    }
			  return ch;
			}
	
	public static String subjectTopper(PreparedStatement stmt, int ch) throws SQLException {
		String res="";
		ResultSet rs=null;
	  	  switch(ch) {
	  	  case 1:stmt.setString(2,"PHYSICS");
	      	  	res=getSubjectTopper(stmt,rs);break;
	  	  case 2:stmt.setString(2,"CHEMISTRY");
	  	  		 res=getSubjectTopper(stmt,rs);break;
	  	  case 3:stmt.setString(2,"BIOLOGY");
	  	         res=getSubjectTopper(stmt,rs);break; 
	  	  case 4:stmt.setString(2,"HISTORY");
	  	         res=getSubjectTopper(stmt,rs);break; 
	  	  case 5:stmt.setString(2,"GEOGRAPHY");
	  	         res=getSubjectTopper(stmt,rs);break;
	  	  case 6:stmt.setString(2,"POLITICAL SCIENCE");
	  	         res=getSubjectTopper(stmt,rs);break; 
	  	  case 7:stmt.setString(2,"ECONOMICS");
	  	         res=getSubjectTopper(stmt,rs);break; 
	  	  case 8:stmt.setString(2,"ENGLISH");
	         	 res=getSubjectTopper(stmt,rs);break;
	  	  case 9:stmt.setString(2,"HINDI");
	  	         res=getSubjectTopper(stmt,rs);break;
	   	  case 10:stmt.setString(2,"MATHS");
	           	 res=getSubjectTopper(stmt,rs);
	           	 res="valid";break;
	      default: res="invalid";break;
	  	  }
		return res;  
	  }
	
	private static String getSubjectTopper(PreparedStatement stmt, ResultSet rs) throws SQLException {
		String res="";
		rs = stmt.executeQuery();
		return res=getSubjectTopperClass(rs);
	}
	
	private static String getSubjectTopperClass(ResultSet rs) throws SQLException {
		String res="";
		System.out.println("The topper in the subject  is:");
		while(rs.next()) {
			    System.out.print("Subject name: "+rs.getString("subjectName")+", Student name: "+rs.getString("name")+", Marks: "+rs.getInt("marks"));
			    System.out.println();
			    int r1=rs.getInt("marks");
			    res=rs.getString("subjectName")+"-"+rs.getString("name")+"-"+r1;
			    break;
			}
		return res;		
		}


}
