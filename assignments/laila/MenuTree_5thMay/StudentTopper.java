import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentTopper {
	protected String classdetails(QueryClass queclass,ExecuteClass execlass, PreparedStatement prestat,Connection connection,int number,ResultSet resultset, String execute) throws SQLException {
		String method;
		MenuClass m=new MenuClass();
		while(true) {
			m.classname();

      		  method=queclass.query5(); 
      	      prestat=connection.prepareStatement(method);
      		  switch(number) {
      		  case 1: 
      		      prestat.setInt(1,6);
      	          resultset = prestat.executeQuery();
      	          execute=execlass.execute5thquery(resultset,6);
      	        break;
      		   case 2:
      		      prestat.setInt(1,7);
      	          resultset = prestat.executeQuery();
      	          execute=execlass.execute5thquery(resultset,7);
      	        break;
      		   case 3:
      		      prestat.setInt(1,8);
      	          resultset = prestat.executeQuery();
      	          execute=execlass.execute5thquery(resultset,8);
      	        break;
      		   case 4:
      		      prestat.setInt(1,9);
      	          resultset = prestat.executeQuery();
      	          execute=execlass.execute5thquery(resultset,9);
      	        break;
      		   case 5:
      		      prestat.setInt(1,10);
      	          resultset = prestat.executeQuery();
      	          execute=execlass.execute5thquery(resultset,10);
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