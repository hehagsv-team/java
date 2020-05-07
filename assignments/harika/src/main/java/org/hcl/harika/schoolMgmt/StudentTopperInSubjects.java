package src.main.java.org.hcl.harika.schoolMgmt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentTopperInSubjects {
	public void classdetails(QueryClass queryClass,ExecuteClass e,Connection connection,String execute,ResultSet rs,Scanner scan,boolean isTest) throws SQLException {
		String str;
		 PreparedStatement ps;
		MenuClass m=new MenuClass();
			while(true) {
      		 m.classname();
      		int number=11;
			if(isTest) {
				if(!scan.hasNext()) {
					scan = new Scanner("11");
				}
				number=Integer.valueOf(scan.nextLine()).intValue();
			} else {
				number = scan.nextInt();
			}   	 
      		  str=queryClass.StudentTopperInSubjectQuery(); 
      	      ps=connection.prepareStatement(str);
      		  switch(number) {
      		  case 1: 
      			  while(true) {
      			  m.subjects();
      			  number=scan.nextInt();
      			  ps.setInt(1,6);
      			  SubjectsSelection(ps,number,rs);
      			  System.out.println("11: for Back to main menu:");
      			  if(number==11) {
          			  break;
          		    }
      			  }
      	          break;
      		  case 2:
      			  while(true) {
      				m.subjects();
          			  number=scan.nextInt();
          			  ps.setInt(1,7);
          			  SubjectsSelection(ps,number,rs);
          			  System.out.println("11: for Back to main menu:");
          			  if(number==11) {
	            			  break;
	            		    }
          			  }
          	          break;
      		  case 3:
      			  while(true) {
      				m.subjects();
          			  number=scan.nextInt();
          			  ps.setInt(1,8);
          			  SubjectsSelection(ps,number,rs);
          			  System.out.println("11: for Back to main menu::");
          			  if(number==11) {
	            			  break;
	            		    }
          			  }
          	          break;
      		  case 4:
      			  while(true) {
      				m.subjects();
          			  number=scan.nextInt();
          			  ps.setInt(1,9);
          			  SubjectsSelection(ps,number,rs);
          			  System.out.println("11:  for Back to main menu:");
          			  if(number==11) {
	            			  break;
	            		    }
          			  }
          	          break;
      		  case 5:
      			  while(true) {
      				m.subjects();
          			  number=scan.nextInt();
          			  ps.setInt(1,10);
          			  SubjectsSelection(ps,number,rs);
          			  System.out.println("11:  for Back to main menu:");
          			  if(number==11) {
	            			  break;
	            		    }
          			  }
          	          break;
      		  case 11:
      			  break;
      	      default:
      	    	  System.out.println("wrong entry");
      	    	  break;
      		  }
      		  if(number==11) {
      			 ps.close(); 
      			  break;
      		     }
      	      }
		}
	
			private static void SubjectsSelection(PreparedStatement ps, int number, ResultSet rs) throws SQLException {
				 ExecuteClass e=new ExecuteClass();
				 String execute;
					switch(number) {
				  	  case 1: 
				  		  
				      	  ps.setString(2,"PHYSICS");
				      	  rs = ps.executeQuery();
						execute = e.execute6thquery(rs,"PHYSICS");
				      	  break;
				  	  case 2:
				  		  
				      	  ps.setString(2,"CHEMISTRY");
				      	  rs = ps.executeQuery();
				      execute = e.execute6thquery(rs,"CHEMISTRY");
				      	  break;
				  	  case 3:
				  		  
				      	  ps.setString(2,"BIOLOGY");
				      	  rs = ps.executeQuery();
				      	execute = e.execute6thquery(rs,"BIOLOGY");
				      	  break;
				  	  case 4:
				  		 
				      	  ps.setString(2,"HISTORY");
				      	  rs = ps.executeQuery();
				      	execute = e.execute6thquery(rs,"HISTORY");
				      	  break;
				  	  case 5:
				      	  ps.setString(2,"GEOGRAPHY");
				      	  rs = ps.executeQuery();
				      	execute = e.execute6thquery(rs,"GEOGRAPHY");
				      	  break;
				  	  case 6:
				      	  ps.setString(2,"POLITICAL SCIENCE");
				      	  rs = ps.executeQuery();
				      	execute = e.execute6thquery(rs,"POLITICAL SCIENCE");
				      	  break;
				  	  case 7:
				      	 ps.setString(2,"ECONOMICS");
				      	  rs = ps.executeQuery();
				      	execute = e.execute6thquery(rs,"ECONOMICS");
				      	  break;
				  	  case 8:
				      	  ps.setString(2,"ENGLISH");
				      	  rs = ps.executeQuery();
				      	execute = e.execute6thquery(rs,"ENGLISH");
				      	  break;
				  	  case 9:
				      	  ps.setString(2,"HINDI");
				      	  rs = ps.executeQuery();
				      	execute = e.execute6thquery(rs,"HINDI");
				      	  break;
				  	  case 10:
				      	  ps.setString(2,"MATHS");
				      	  rs = ps.executeQuery();
				      	execute = e.execute6thquery(rs,"MATHS");
				      	  break;
				  	  case 11:
							  break;
				       default:
				      	  System.out.println("wrong entry");
				      	 ps.close();
				      	  break;
						  }
						  
				        }

		}
	


	