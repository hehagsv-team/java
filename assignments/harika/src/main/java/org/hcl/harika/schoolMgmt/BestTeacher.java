package src.main.java.org.hcl.harika.schoolMgmt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class BestTeacher {
	public String classdetails(QueryClass queryClass,ExecuteClass e,Connection connection,String execute,Scanner scan,boolean isTest) throws SQLException {
		String str;
		 PreparedStatement ps;
		 ResultSet rs;
		MenuClass m=new MenuClass();
		while(true) {
			m.classname();
           	  System.out.println("11: BAck to main menu:");
           	int number=11;
			if(isTest) {
				if(!scan.hasNext()) {
					scan = new Scanner("11");
				}
				number=Integer.valueOf(scan.nextLine()).intValue();
			} else {
				number = scan.nextInt();
			}   	 
           	  str=queryClass.BestTeacherQuery(); 
       	      ps=connection.prepareStatement(str);
           	  switch(number) {
           	  case 1:
	            	  ps.setString(1,"PHYSICS");
	            	  rs = ps.executeQuery();
	            	  execute=e.execute4thquery(rs,"PHYSICS");
	            	  break;
           	  case 2:           		  
	            	  ps.setString(1,"CHEMISTRY");
	            	  rs = ps.executeQuery();
	            	  execute=e.execute4thquery(rs,"CHEMISTRY");
	            	  break;
           	  case 3:
	            	  ps.setString(1,"BIOLOGY");
	            	  rs = ps.executeQuery();
	            	  execute=e.execute4thquery(rs,"BIOLOGY");
	            	  break;
           	  case 4:
	            	  ps.setString(1,"HISTORY");
	            	  rs = ps.executeQuery();
	            	  execute=e.execute4thquery(rs,"HISTORY");
           	  case 5:
	            	  ps.setString(1,"GEOGRAPHY");
	            	  rs = ps.executeQuery();
	            	  execute=e.execute4thquery(rs,"GEOGRAPHY");
	            	  break;
           	  case 6:
	            	  ps.setString(1,"POLITICAL SCIENCE");
	            	  rs = ps.executeQuery();
	            	  execute=e.execute4thquery(rs,"POLITICAL SCIENCE");
	            	  break;
           	  case 7:
	            	  ps.setString(1,"ECONOMICS");
	            	  rs = ps.executeQuery();
	            	  execute=e.execute4thquery(rs,"ECONOMICS");
	            	  break;
           	  case 8:
	            	  ps.setString(1,"ENGLISH");
	            	  rs = ps.executeQuery();
	            	  execute=e.execute4thquery(rs,"ENGLISH");
	            	  break;
           	  case 9:
	            	  ps.setString(1,"HINDI");
	            	  rs = ps.executeQuery();
	            	  execute=e.execute4thquery(rs,"HINDI");
	            	  break;
           	  case 10:
	            	  ps.setString(1,"MATHS");
	            	  rs = ps.executeQuery();
	            	  execute=e.execute4thquery(rs,"MATHS");
	            	  break;
           	  case 11:
       			  break;
	              default:
	            	  System.out.println("wrong entry");
	            	  break;
       		  }
       		  if(number==11) {
       			  break;
       		    }
                  }
		return execute;
		}
	}
