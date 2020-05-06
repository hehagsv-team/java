import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AllSubjects {
	protected void classdetails(QueryClass queclass,ExecuteClass execlass, PreparedStatement prestat,Connection connection,Scanner scan,ResultSet resultset, String execute) throws SQLException {
		String method;
		MenuClass m=new MenuClass();
		while(true) {
			m.classname();
       		  int number=scan.nextInt();
       		  method=queclass.query7(); 
       	      prestat=connection.prepareStatement(method);
       		  switch(number) {
       		  case 1: 
       		      prestat.setInt(1,6);
       	          resultset = prestat.executeQuery();
       	          execute=execlass.execute7thquery(resultset,6);
       	          break;
       		  case 2:
       		      prestat.setInt(1,7);
       	          resultset = prestat.executeQuery();
       	          execute=execlass.execute7thquery(resultset,7);
       	          break;
       		  case 3:
       		      prestat.setInt(1,8);
       	          resultset = prestat.executeQuery();
       	          execute=execlass.execute7thquery(resultset,8);
       	          break;
       		  case 4:
       		      prestat.setInt(1,9);
       	          resultset = prestat.executeQuery();
       	          execute=execlass.execute7thquery(resultset,9);
       	          break;
       		  case 5:
       		      prestat.setInt(1,10);
       	          resultset = prestat.executeQuery();
       	          execute=execlass.execute7thquery(resultset,10);
       	          System.out.println("null");
       	          break;
       		  case 11:
       			  break;
       	      default:
       	    	  System.out.println("wrong entry");
       	    	  break;
       		  }
       		  if(number==11) {
       			 prestat.close();
       			  break;
       		    }
       	      }
		}

}
