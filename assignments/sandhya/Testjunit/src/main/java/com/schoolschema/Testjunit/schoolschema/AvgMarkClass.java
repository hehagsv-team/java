package com.schoolschema.Testjunit.schoolschema;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class AvgMarkClass {
	static Logger log=Logger.getLogger(AvgMarkClass.class);
	
	public static String averageMarks() {
	    String sql;
		return sql = "select avg(marks) as Average\r\n" + 
		 		"from marks m\r\n" + 
		 		"join subject s\r\n" + 
		 		"on m.subject_id=s.id\r\n" + 
		 		"where s.class_name=?";
	      
	}
	public static String averageMarkClassMethod(Scanner sc, Connection conn) throws SQLException {
		String res="";
		 while(true) {
	   	  		log.info("\nAverage marks in each class:");
	   	  		Menu.classMenu();
	   	  		int ch= sc.nextInt();    
	   	  		String sql=averageMarks(); 
	   	  		PreparedStatement stmt=conn.prepareStatement(sql);
	   	  		subAvgMarksMethod(ch,stmt);
	   	  		if(ch==12) {
	   	  		  res="exit";
				  break;
			    }
	         }
		 return res;
		}

	public static int subAvgMarksMethod(int ch, PreparedStatement stmt) throws SQLException {
		int res;
		ResultSet rs;
		  switch(ch) {
		  case 1:stmt.setInt(1,6);
	      		rs = stmt.executeQuery();
	      		res=getAverageMarks(rs,6);break;
		  case 2:stmt.setInt(1,7);
	      		rs = stmt.executeQuery();
	      		res=getAverageMarks(rs,7); break;
		  case 3:stmt.setInt(1,8);
	      		rs = stmt.executeQuery();
	      		res=getAverageMarks(rs,8);break; 
		  case 4:stmt.setInt(1,9);
	             rs = stmt.executeQuery();
	             res=getAverageMarks(rs,9);break; 
	      case 5:stmt.setInt(1,10);
	             rs = stmt.executeQuery();
	             res=getAverageMarks(rs,10);
	             res=1;break; 
	      default:res=0;break; 
	     }
		return res;
	}
	public static int getAverageMarks(ResultSet rs, int i) throws SQLException {
	 int res=0;
	 while(rs.next()) {
     log.debug("Average marks in class "+i+" is: "+rs.getInt("Average")+"\n");
     res=rs.getInt("Average");
     break;
	 }
	 return res;
}	

}
