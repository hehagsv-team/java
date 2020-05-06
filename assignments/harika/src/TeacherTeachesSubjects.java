import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class TeacherTeachesSubjects {
	protected void classdetails(QueryClass queryClass,ExecuteClass e, PreparedStatement ps,Connection connection,Scanner scan,ResultSet rs, String execute) throws SQLException {
		String str;
		MenuClass m=new MenuClass();
		
			 System.out.println("Subject distribution for teacher:");
    	      str=queryClass.query8();
    	      ps=connection.prepareStatement(str);
             rs = ps.executeQuery();
             while(rs.next()) {
           	  System.out.print("Name of The Teacher: "+rs.getString("name")+", Number of subjects: "+rs.getInt("subject_count")+"\n");
             }
             System.out.println("11: for Back to main menu:");
 			 
             
             ps.close();
	}
}
