package com.schoolschema.Testjunit.schoolschema;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class TeacherClass {
	static Logger log=Logger.getLogger("TeacherClass");
	public static String teacherClass() {
	    String sql;
		return sql = "select t.name\r\n" + 
	 	 		"from class c\r\n" + 
	 	 		"join teacher t\r\n" + 
	 	 		"on t.id=c.teacher_id\r\n" + 
	 	 		"where c.name=?";
	}

public static String teacherClassMethod(Scanner sc, Connection conn) throws SQLException {
	String res="";
	while(true) {
  	  log.info("\nName of the teacher in  particular class is: ");
	  Menu.classMenu();
	  int ch= sc.nextInt();	  
  	  String sql=teacherClass(); 
  	  PreparedStatement stmt=conn.prepareStatement(sql);
	  subTeacherClassMethod(ch,stmt); 
		  if(ch==12) {
			  res="exit";
			  break;
		   }
       }
	return res;
	
	}

public static String subTeacherClassMethod(int ch, PreparedStatement stmt) throws SQLException {
	String res="";
	ResultSet rs=null;
	switch(ch) {
	  case 1: stmt.setInt(1,6);
              rs = stmt.executeQuery();
              res=getTeacherClass(rs,6); break;
	  case 2: stmt.setInt(1,7);
              rs = stmt.executeQuery();
              res=getTeacherClass(rs,7);break;
	  case 3: stmt.setInt(1,8);
              rs = stmt.executeQuery();
              res=getTeacherClass(rs,8);
              res="valid";break;
	  case 4: stmt.setInt(1,9);
              rs = stmt.executeQuery();
              res=getTeacherClass(rs,9); 
              break;
	  case 5: stmt.setInt(1,10);
              rs = stmt.executeQuery();
              res=getTeacherClass(rs,10); break;
     default: res="invalid";
              break;  
	  }
	return res;
}

public static String getTeacherClass(ResultSet rs, int i) throws SQLException {
	String res="";
	while(rs.next()) {
	    log.debug("The name of the teacher in the particular class "+i+" is: "+rs.getString("name")+"\n");
	    res=rs.getString("name");
	    break;
	}
	return res;


}	
}