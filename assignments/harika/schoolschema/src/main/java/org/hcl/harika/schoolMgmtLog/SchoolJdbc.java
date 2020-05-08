package org.hcl.harika.schoolMgmtLog;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.log4j.Logger;
public class SchoolJdbc {
	static final String JDBC_DRIVER = "org.h2.Driver"; 
	final static Logger logger=Logger.getLogger(SchoolJdbc.class);
	
	public static void main(String[] args) { 
		Connection connection = null; 
		PreparedStatement ps = null;
		String str; 
		Scanner scan = new Scanner(System.in);
		MenuClass m=new MenuClass();
		ResultSet rs = null;
		String execute=null;			
		try { 
			logger.info("Connecting to database..."); 
			connection = DatabaseConnection.getConnection();
			QueryClass queryClass=new QueryClass();
			ExecuteClass e=new ExecuteClass();
			while(true) {	        	
				m.schooljdbc();
				int choice = scan.nextInt();
				switch(choice) {
				case 1:
					ClassTeacher ct=new ClassTeacher();
					ct.classdetails(queryClass, e,connection,execute,scan,false);
					break;
				case 2:
					AverageMarks am=new AverageMarks();
					am.classdetails(queryClass, e,connection,execute,scan,false);
					break;	            	      
				case 3: 
					MarksDistribution md=new MarksDistribution();
					md.classdetails(queryClass, e, connection,execute,scan,false);
					break;
				case 4:
					BestTeacher bt=new BestTeacher();
					bt.classdetails(queryClass, e, connection,execute,scan,false);
					break; 
				case 5:
					StudentTopper st=new StudentTopper();
					st.classdetails(queryClass, e,connection,execute,scan,false);
					break;
				case 6:
					StudentTopperInSubjects sts= new StudentTopperInSubjects();
					sts.classdetails(queryClass, e,connection,execute,rs,scan,false);
					break;
				case 7:
					AllSubjects as=new AllSubjects();
					as.classdetails(queryClass, e,connection,execute,scan,false);
					break;
				case 8:
					TeacherTeachesSubjects tts= new TeacherTeachesSubjects();
					tts.classdetails(queryClass,e,connection,execute,scan,false);
					break; 
				case 9:
					ClassStrength cs=new ClassStrength();
					cs.classdetails(queryClass, e,connection,execute,scan,false);
					break;
				case 11:
					break;
				default:
					logger.info("wrong entry");
					break;
				}	  
				if(choice==11)  {
					logger.info("Schema finished");
					break;
				}	
			}

			connection.close(); 
		} catch(SQLException se) { 
			se.printStackTrace(); 
		} catch(Exception e) { 
			e.printStackTrace(); 
		} 
	}  
}


