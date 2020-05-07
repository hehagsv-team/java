package src.main.java.org.hcl.harika.schoolMgmt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class TeacherTeachesSubjects {
	public static String classdetails(QueryClass queryClass,ExecuteClass e, Connection connection,String execute,Scanner scan,boolean isTest ) throws SQLException {
		String str;
		PreparedStatement ps;
		ResultSet rs;
		MenuClass m=new MenuClass();
		
			 System.out.println("Subject distribution for teacher:");
    	      str=queryClass.TeacherTeachesSubjectQuery();
    	      ps=connection.prepareStatement(str);
             rs = ps.executeQuery();
             while(rs.next()) {
           	  System.out.print("Name of The Teacher: "+rs.getString("name")+", Number of subjects: "+rs.getInt("subject_count")+"\n");
             }
             System.out.println("11: for Back to main menu:");
 			 
             
             ps.close();
			return str;
	}
}
