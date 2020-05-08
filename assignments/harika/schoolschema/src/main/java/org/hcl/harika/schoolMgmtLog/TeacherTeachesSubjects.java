package org.hcl.harika.schoolMgmtLog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class TeacherTeachesSubjects {
	final static Logger logger=Logger.getLogger(TeacherTeachesSubjects.class);
	public static String classdetails(QueryClass queryClass,ExecuteClass e, Connection connection,String execute,Scanner scan,boolean isTest ) throws SQLException {
		String str;
		PreparedStatement ps;
		ResultSet rs;
		MenuClass m=new MenuClass();
		
			 logger.info("Subject distribution for teacher:");
    	      str=queryClass.TeacherTeachesSubjectQuery();
    	      ps=connection.prepareStatement(str);
             rs = ps.executeQuery();
             while(rs.next()) {
           	  logger.debug("Name of The Teacher: "+rs.getString("name")+", Number of subjects: "+rs.getInt("subject_count")+"\n");
             }
             logger.info("11: for Back to main menu:");
 			 
             
             ps.close();
			return str;
	}
}

