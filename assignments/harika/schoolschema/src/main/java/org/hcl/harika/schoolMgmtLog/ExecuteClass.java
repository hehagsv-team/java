package org.hcl.harika.schoolMgmtLog;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

public class ExecuteClass {
	final static Logger logger=Logger.getLogger(ExecuteClass.class);
	public String execute1stquery(ResultSet rs, int number) throws SQLException {
		String result="";
		while(rs.next()) {
			logger.debug("The name of the teacher in the particular class "+number+" "+rs.getString("name")+"\n");
			result=rs.getString("name")+"";
		}
		return result;
	}	
	public String execute2ndquery(ResultSet rs, int number) throws SQLException {
		String result="";
		while(rs.next()) {
			logger.debug("Average marks in class "+number+"  "+rs.getInt("Average")+"\n"); 
			result=rs.getInt("Average")+"";
		}
		return result ;
	} 
	public String execute3rdquery(ResultSet rs, String str) throws SQLException {
		logger.debug("The mark distribution of a subject "+str+" \n");	
		String result="";
		while(rs.next()) {
			logger.debug("count:"+rs.getInt("count(*)")+" "+"marks-range:"+rs.getString("marks"));
			result=rs.getInt("count(*)")+"";
			result=rs.getString("marks")+"";
		}
		return result ;
	}
	public String execute4thquery(ResultSet rs, String str) throws SQLException {
		logger.debug("TeacherName who teaches the SubjectName "+str+" better \n");	
		String result="";
		while(rs.next()) {
			logger.debug("class:"+rs.getInt("class")+"  "+"Average:"+rs.getInt("Average")+"  "+"Teachers-name: "+rs.getString("teacher"));
			result=rs.getInt("class")+"";
			result=rs.getInt("Average")+"";
			result=rs.getString("teacher")+"";
		}
		return result ;
	}
	public String execute5thquery(ResultSet rs, int number) throws SQLException {
		logger.debug("The topper in the class "+number+" :");
		String result="";
		while(rs.next()) {
			logger.debug("Name of the student: "+rs.getString("NameofTheStudent")+"   Number of Marks: "+rs.getInt("Totalmarks"));
			result=rs.getString("NameofTheStudent")+"";
			result=rs.getInt("Totalmarks")+"";
		}
		return result ;
	}
	public String execute6thquery(ResultSet rs, String method) throws SQLException {
		logger.debug("The topper of the subject "+method+" :");
		String result="";
		while(rs.next()) {
			logger.debug("Name of the student: "+rs.getString("studentname")+"   Number of Marks: "+rs.getInt("highestmarks"));
			result=rs.getString("studentname")+"";
			result=rs.getInt("highestmarks")+"";
			
		}
		return result ;		
	}
	public String execute7thquery(ResultSet rs, int number) throws SQLException {
		logger.debug("class teacher of the class  "+number+":");
		String result="";
		while(rs.next()) {
			logger.debug("Name of the Classteache: "+rs.getString("name")+"  Number of subjects: "+rs.getString("subject_count"));
			result=rs.getString("name")+"";
			result=rs.getString("subject_count")+"";
			
		}
		return result ;
	}
	public String execute9thquery(ResultSet rs, int number) throws SQLException {
		String result="";
		while(rs.next()) {
			logger.debug("count(id)"+number+"   "+rs.getInt("count(id)")+"\n");
			result=rs.getInt("count(id)")+"";
		}
		return result ;
	}

}

