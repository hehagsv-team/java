package com.schoolschema.Testjunit.schoolschema;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class MarkDistClass {
	static Logger log=Logger.getLogger("MarkDistClass");
	static String sql;
	public static String markDistClass() {
		 return sql = "select count(*),\r\n" + 
		 		"(case \r\n" + 
		 		"          when marks between 50 and 59 then '50-59'\r\n" + 
		 		"          when marks between 60 and 69 then '60-69'\r\n" + 
		 		"          when marks between 70 and 79 then '70-79'\r\n" + 
		 		"          when marks between 80 and 89 then '80-89'\r\n" + 
		 		"         else 'above 90'\r\n" + 
		 		"end)marks\r\n" + 
		 		"from marks m\r\n" + 
		 		"join subject s\r\n" + 
		 		"on m.subject_id=s.id\r\n" + 
		 		"where name=?"+
		 		"group by marks";
	} 
	public static String markDistMethod(Scanner sc, Connection conn) throws SQLException {
		String res="";
		while(true) {
   	      log.info( "\nMark distribution for each subject ");
       	  Menu.subjectMenu();
       	  System.out.println("12: To return main menu:");
       	  int ch= sc.nextInt();
       	  sql = markDistClass(); 
   	      PreparedStatement stmt=conn.prepareStatement(sql);
       	  ResultSet rs=null;
		  subMarkDistMethod(ch,stmt);
   		  if(ch==12) {
   			  res="exit";
   			  break;
   		     }
             }
		return res;
	}
	public static String subMarkDistMethod(int ch, PreparedStatement stmt) throws SQLException {
		ResultSet rs=null;
		String res = "";
		switch(ch) {
     	  case 1:stmt.setString(1,"PHYSICS");
         	     res=markDistSubj(rs,stmt);break;
     	  case 2:stmt.setString(1,"CHEMISTRY");         		  
     	         res=markDistSubj(rs,stmt);break;
     	  case 3:stmt.setString(1,"BIOLOGY");
	             res=markDistSubj(rs,stmt);break;
     	  case 4:stmt.setString(1,"HISTORY");
                 res=markDistSubj(rs,stmt);break;
     	  case 5:stmt.setString(1,"GEOGRAPHY");
                 res=markDistSubj(rs,stmt);break;
     	  case 6:stmt.setString(1,"POLITICAL SCIENCE");
                 res=markDistSubj(rs,stmt);break;
     	  case 7:stmt.setString(1,"ECONOMICS");
                 res=markDistSubj(rs,stmt);break;
     	  case 8:stmt.setString(1,"ENGLISH");
                 res=markDistSubj(rs,stmt);break;
     	  case 9:stmt.setString(1,"HINDI");
                 res=markDistSubj(rs,stmt);break;
     	  case 10:stmt.setString(1,"MATHS");
                 res=markDistSubj(rs,stmt);
                 res="valid";break;
          default:res="invalid";break;
 		  }
		return res;
	}
	private static String markDistSubj(ResultSet rs, PreparedStatement stmt) throws SQLException {
	  String res="";
		rs = stmt.executeQuery();
   	  return res=getMarkDist(rs);
		
	}
	private static String getMarkDist(ResultSet rs) throws SQLException {
		String res="";
		log.info("The mark distribution of a subject  is\n");		
	    while(rs.next()) {
	          log.debug("Count:"+rs.getInt("count(*)")+" ,"+"Marks-range:"+rs.getString("marks"));
	          int r1=rs.getInt("count(*)");
	          String r2=rs.getString("marks");
	          res=r2+","+r1;
	          break;
	       }
		return res; 
	}
}
