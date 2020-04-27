package jdbc.schoolschema;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AvgMarkClass {
	public static String averageMarks() {
	    String sql;
		return sql = "select avg(marks) as Average\r\n" + 
		 		"from marks m\r\n" + 
		 		"join subject s\r\n" + 
		 		"on m.subject_id=s.id\r\n" + 
		 		"where s.class_name=?";
	      
	}
	public static void averageMarkClassMethod(Scanner sc, Connection conn) throws SQLException {
		 while(true) {
	   	  		System.out.println("\nAverage marks in each class:");
	   	  		Menu.classMenu();
	   	  		ResultSet rs = null;
	   	  		int ch=sc.nextInt();
	   	  		String sql=averageMarks(); 
	   	  		PreparedStatement stmt=conn.prepareStatement(sql);
	   	  		subAvgMarksMethod(ch,stmt,rs);
	   	  		if(ch==12) {
				  break;
			    }
	         }
			
		}

	private static void subAvgMarksMethod(int ch, PreparedStatement stmt, ResultSet rs) throws SQLException {
		  switch(ch) {
		  case 1:stmt.setInt(1,6);
	      		rs = stmt.executeQuery();
	      		getAverageMarks(rs,6);break;
		  case 2:stmt.setInt(1,7);
	      		rs = stmt.executeQuery();
	      		getAverageMarks(rs,7); break;
		  case 3:stmt.setInt(1,8);
	      		rs = stmt.executeQuery();
	      		getAverageMarks(rs,8);break; 
		  case 4:stmt.setInt(1,9);
	             rs = stmt.executeQuery();
	             getAverageMarks(rs,9);break; 
	      case 5:stmt.setInt(1,10);
	             rs = stmt.executeQuery();
	             getAverageMarks(rs,10);break; 
	      default: break; 
	     }
	}
	private static void getAverageMarks(ResultSet rs, int i) throws SQLException {
	 while(rs.next()) {
        System.out.print("Average marks in class "+i+" is: "+rs.getInt("Average")+"\n"); 
       }
}	

}
