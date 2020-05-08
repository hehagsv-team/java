package com.log4j.jdbc.schoolschema;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.log4j.Logger;

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
	public static void markDistMethod(Scanner sc, Connection conn) throws SQLException {
		 while(true) {
   	      log.info( "\nMark distribution for each subject ");
       	  Menu.subjectMenu();
       	  log.info("12: To return main menu:");
       	  int ch=sc.nextInt();
       	  sql = markDistClass(); 
   	      PreparedStatement stmt=conn.prepareStatement(sql);
       	  ResultSet rs=null;
		  subMarkDistMethod(ch,stmt,rs);
   		  if(ch==12) {
   			  break;
   		     }
             }
	}
	private static void subMarkDistMethod(int ch, PreparedStatement stmt, ResultSet rs) throws SQLException {
		switch(ch) {
     	  case 1:stmt.setString(1,"PHYSICS");
         	     markDistSubj(rs,stmt);break;
     	  case 2:stmt.setString(1,"CHEMISTRY");         		  
     	         markDistSubj(rs,stmt);break;
     	  case 3:stmt.setString(1,"BIOLOGY");
	             markDistSubj(rs,stmt);break;
     	  case 4:stmt.setString(1,"HISTORY");
                 markDistSubj(rs,stmt);break;
     	  case 5:stmt.setString(1,"GEOGRAPHY");
                 markDistSubj(rs,stmt);break;
     	  case 6:stmt.setString(1,"POLITICAL SCIENCE");
                 markDistSubj(rs,stmt);break;
     	  case 7:stmt.setString(1,"ECONOMICS");
                 markDistSubj(rs,stmt);break;
     	  case 8:stmt.setString(1,"ENGLISH");
                 markDistSubj(rs,stmt);break;
     	  case 9:stmt.setString(1,"HINDI");
                 markDistSubj(rs,stmt);break;
     	  case 10:stmt.setString(1,"MATHS");
                 markDistSubj(rs,stmt);break;
          default:break;
 		  }
	}
	private static void markDistSubj(ResultSet rs, PreparedStatement stmt) throws SQLException {
	  rs = stmt.executeQuery();
   	  getMarkDist(rs);
		
	}
	private static void getMarkDist(ResultSet rs) throws SQLException {
		log.info("The mark distribution of a subject  is\n");		
	    while(rs.next()) {
	          log.debug("Count:"+rs.getInt("count(*)")+" ,"+"Marks-range:"+rs.getString("marks"));
	       } 
	}
}
