package com.schoolschema.Testjunit.schoolschema;

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

	public static String teacherClassMethod(Scanner sc, Connection conn, boolean isTest) throws SQLException {
	String res="";
	while(true) {
  	  System.out.println("\nName of the teacher in  particular class is: ");
	  Menu.classMenu();
	  ResultSet rs = null;
	  int ch;
	  if(isTest) {
			if(!sc.hasNext()) {
				sc = new Scanner("12");
			}
			ch=Integer.valueOf(sc.nextLine()).intValue();
		} 
	  else {
			ch = sc.nextInt();
		}
	  
  	  String sql=teacherClass(); 
  	  PreparedStatement stmt=conn.prepareStatement(sql);
	  res=subTeacherClassMethod(ch,stmt,rs); 
		  if(ch==12) {
			  res="exit";
			  break;
		   }
       }
	return res;
	
	}

public static String subTeacherClassMethod(int ch, PreparedStatement stmt, ResultSet rs) throws SQLException {
	String res="";
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
	String res=rs.getString("name");
	System.out.println(res);
	return res;


}	
}