package com.schoolschema.Testjunit.schoolschema;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class ClassStrength {
	static Logger log=Logger.getLogger("ClassStrength");
	static String sql;
public static String classStrength() {
	return sql = "select count(*)\r\n" + 
 	 		"from student s\r\n" + 
 	 		"join class c\r\n" + 
 	 		"on s.class_name=c.name\r\n" +
 	 	    "where c.name=?\r\n";
}
public static String classStrengthMethod(Scanner sc, Connection conn) throws SQLException {
	String res="";
	while(true) {
	  	  log.info("\nClass strength");
	  	  Menu.classMenu();
	  	int ch= sc.nextInt();
  	      sql=classStrength(); 
	      PreparedStatement stmt=conn.prepareStatement(sql);
		  subClassMethod(stmt,ch);
		  if(ch==12) {
			  res="exit";
			  break;
		    }
         }
	return res;
}
public static int subClassMethod(PreparedStatement stmt, int ch) throws SQLException {
	int res=0;
	ResultSet rs=null;
	switch(ch) {
	  case 1:stmt.setInt(1,6);
             rs = stmt.executeQuery();
             res=getClassStrength(rs,6); break;
      case 2:stmt.setInt(1,7);
      		rs = stmt.executeQuery();
            res=getClassStrength(rs,7); break;
	  case 3:stmt.setInt(1,8);
            rs = stmt.executeQuery();
            res=getClassStrength(rs,8); break;
	  case 4:stmt.setInt(1,9);
             rs = stmt.executeQuery();
             res=getClassStrength(rs,9); break;
	  case 5:stmt.setInt(1,10);
            rs = stmt.executeQuery();
            res=getClassStrength(rs,10);
            res=1;break;
      default: res=0;break;
	  }
	return res;
	
}
private static int getClassStrength(ResultSet rs, int i) throws SQLException {
	int res=0;
	while(rs.next()) {
	log.debug("The strength of the class "+i+" is "+rs.getInt("count(*)")+"\n");
	res=rs.getInt("count(*)");
	break;
	}
	return res;
	
	}

}