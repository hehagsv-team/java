package com.schoolschema.Testjunit.schoolschema;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class StudentTopperClass {
	static Logger log=Logger.getLogger("StudentTopperClass");
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

	public static String studentTopperMethod(Scanner sc, Connection conn) throws SQLException {
		String res="";
		while(true) {
  	      log.info("\nTopper student in each class");
  		  Menu.classMenu();
  		int ch= sc.nextInt();
  		  sql=classTopper(); 
  		  ResultSet rs=null;
  	      PreparedStatement stmt=conn.prepareStatement(sql);
  		  subStudentMethod(stmt,ch);
  		  if(ch==12) {
  			  res="exit";
  			  break;
  		    }
  	       }
		return res;
		
	}

	public static String subStudentMethod(PreparedStatement stmt, int ch) throws SQLException {
		String res="";
		 ResultSet rs=null;
		switch(ch) {
		case 1:stmt.setInt(1,6);
	          rs = stmt.executeQuery();
	          res=getClassTopper(rs,6);break;
		case 2:stmt.setInt(1,7);
	          rs = stmt.executeQuery();
	          res=getClassTopper(rs,7);break;
		case 3:stmt.setInt(1,8);
	          rs = stmt.executeQuery();
	          res=getClassTopper(rs,8);break;
		 case 4:stmt.setInt(1,9);
	          rs = stmt.executeQuery();
	          res=getClassTopper(rs,9);break;
		 case 5:stmt.setInt(1,10);
	          rs = stmt.executeQuery();
	          res=getClassTopper(rs,10);
	          res="valid";break;
	      default:res="invalid";break;
		  }
		return res;
	}

	private static String getClassTopper(ResultSet rs, int i) throws SQLException {
	log.info("The topper in the class name "+i+" is:");
	String res="";
	while(rs.next()) {
		    log.debug("Student name: "+rs.getString("StudentName")+", Marks: "+rs.getInt("marks"));
		    int r1=rs.getInt("marks");
	        String r2=rs.getString("StudentName");
	        res=r2+"-"+r1;
	        break;
		}
	return res;
	}
}
