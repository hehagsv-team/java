import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class MarksDistribution {
	protected void classdetails(QueryClass queclass,ExecuteClass execlass, PreparedStatement prestat,Connection connection,Scanner scan,ResultSet resultset, String execute) throws SQLException {
		String method;
		MenuClass m=new MenuClass();
		while(true) {
			m.classname();
          	  System.out.println("11: Back to main menu:");
          	  int number=scan.nextInt();
          	  method=queclass.query3(); 
      	      prestat=connection.prepareStatement(method);
          	  switch(number) {
          	  case 1:
	            	  prestat.setString(1,"PHYSICS");
	            	  resultset = prestat.executeQuery();
                    execute=execlass.execute3rdquery(resultset,"PHYSICS");
	            	  break;
          	  case 2:           		  
	            	  prestat.setString(1,"CHEMISTRY");
	            	  resultset = prestat.executeQuery();
                    execute=execlass.execute3rdquery(resultset,"CHEMISTRY");
	            	  break;
          	  case 3:
	            	  prestat.setString(1,"BIOLOGY");
	            	  resultset = prestat.executeQuery();
                    execute=execlass.execute3rdquery(resultset,"BIOLOGY");
	            	  break;
          	  case 4:
	            	  prestat.setString(1,"HISTORY");
	            	  resultset = prestat.executeQuery();
                    execute=execlass.execute3rdquery(resultset,"HISTORY");
	            	  break;
          	  case 5:
	            	  prestat.setString(1,"GEOGRAPHY");
	            	  resultset = prestat.executeQuery();
                    execute=execlass.execute3rdquery(resultset,"GEOGRAPHY");
	            	  break;
          	  case 6:
	            	  prestat.setString(1,"POLITICAL SCIENCE");
	            	  resultset = prestat.executeQuery();
                    execute=execlass.execute3rdquery(resultset,"POLITICAL SCIENCE");
	            	  break;
          	  case 7:
	            	  prestat.setString(1,"ECONOMICS");
	            	  resultset = prestat.executeQuery();
                    execute=execlass.execute3rdquery(resultset,"ECONOMICS");
	            	  break;
          	  case 8:
	            	  prestat.setString(1,"ENGLISH");
	            	  resultset = prestat.executeQuery();
                    execute=execlass.execute3rdquery(resultset,"ENGLISH");
	            	  break;
          	  case 9:
	            	  prestat.setString(1,"HINDI");
	            	  resultset = prestat.executeQuery();
                    execute=execlass.execute3rdquery(resultset,"HINDI");
	            	  break;
          	  case 10:
	            	  prestat.setString(1,"MATHS");
	            	  resultset = prestat.executeQuery();
                    execute=execlass.execute3rdquery(resultset,"MATHS");
	            	  break;
          	  case 11:
      			  break;
	              default:
	            	  System.out.println("Invalid option");
	            	  break;
      		  }
      		  if(number==11) {
      			 prestat.close();
      			  break;
      		     }
                }
		}
	}