import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class TeacherTeachesSubjects {
	protected void classdetails(QueryClass queclass,ExecuteClass execlass, PreparedStatement prestat,Connection connection,Scanner scan,ResultSet resultset, String execute) throws SQLException {
		String method;
		MenuClass m=new MenuClass();
		
			 System.out.println("Subject distribution for teacher:");
    	      method=queclass.query8();
    	      prestat=connection.prepareStatement(method);
             resultset = prestat.executeQuery();
             while(resultset.next()) {
           	  System.out.print("Name of The Teacher: "+resultset.getString("name")+", Number of subjects: "+resultset.getInt("subject_count")+"\n");
             }
             System.out.println("11: for Back to main menu:");
 			 
             
             prestat.close();
	}
}
