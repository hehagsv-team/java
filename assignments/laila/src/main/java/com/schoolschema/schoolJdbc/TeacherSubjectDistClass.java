

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class TeacherSubjectDistClass {
	public static String teacherSubDis() {
		  String sql;
		return sql = "select t.name,count(*) as no_subject\r\n" + 
			 		"from subject s\r\n" + 
			 		"join teacher t\r\n" + 
			 		"on s.teacher_id=t.id\r\n" + 
			 		"group by t.name\r\n";
		}
	public static void subjectDistMethod(Scanner sc, Connection conn) throws SQLException {
		System.out.println("\nTeacher to subject distribution is:");
	    String sql=teacherSubDis();
	    PreparedStatement  stmt=conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
  	    System.out.print("Teacher name: ,\t No. of subjects: \n");
        while(rs.next()) {
      	  System.out.print("\t"+rs.getString("name")+"\t"+rs.getInt("no_subject")+"\n");
        }

		
	}

}