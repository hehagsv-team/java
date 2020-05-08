package com.schoolschema.Testjunit.schoolschema;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class ClassTeacherClass {
	static Logger log=Logger.getLogger(ClassTeacherClass.class);
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
	public static String classTeacherMethod(Scanner sc, Connection conn) throws SQLException {
		String res="";
	      while(true) {
	      log.info("\nWhich all subjects does a class teacher teach is");
		  Menu.classMenu();
		  int ch=sc.nextInt();
		  sql=classTeacherSub();
		  ResultSet rs=null;
	      PreparedStatement stmt=conn.prepareStatement(sql);
		  subClassTeacher(ch,stmt);
		  if(ch==12) {
			  res="exit";
			  break;
		    }
	      }
		return res;
	}
	public static String subClassTeacher(int ch, PreparedStatement stmt) throws SQLException {
		String res="";
		ResultSet rs=null;
		 switch(ch) {
		 case 1:stmt.setInt(1,6);
	          rs = stmt.executeQuery();
	          res=getClassTeacher(rs,6);  break;
		  case 2:stmt.setInt(1,7);
	          rs = stmt.executeQuery();
	          res=getClassTeacher(rs,7);  break;
		  case 3:stmt.setInt(1,8);
	          rs = stmt.executeQuery();
	          res=getClassTeacher(rs,8);  break;
		  case 4:stmt.setInt(1,9);
	          rs = stmt.executeQuery();
	          res=getClassTeacher(rs,9);  break;
		  case 5:stmt.setInt(1,10);
	          rs = stmt.executeQuery();
	          res=getClassTeacher(rs,10);
	          System.out.println("null"); 
	          res="valid";break;
	      default: res="invalid"; break;
		  }
		 return res;
	}
	private static String getClassTeacher(ResultSet rs, int i) throws SQLException {
		log.debug("The class teacher of the class name "+i+" is:");
		String res="";
		while(rs.next()) {
			    log.debug("Classteacher name: "+rs.getString("name")+", Subject name: "+rs.getString("no_subject"));
			    res=rs.getString("name")+"-"+rs.getString("no_subject");
			    break;
			}
		
		return res;
		}
}
