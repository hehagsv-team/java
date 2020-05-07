

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ClassStrength {	
	static String sql;
public static String classStrength() {
	return sql = "select count(*)\r\n" + 
 	 		"from student s\r\n" + 
 	 		"join class c\r\n" + 
 	 		"on s.class_name=c.name\r\n" +
 	 	    "where c.name=?\r\n";
}
public static void classStrengthMethod(Scanner sc, Connection conn) throws SQLException {
	while(true) {
	  	  System.out.println("\nClass strength");
		  Menu.classMenu();
  	      int ch=sc.nextInt();
  	      sql=classStrength(); 
  	      ResultSet rs=null;
	      PreparedStatement stmt=conn.prepareStatement(sql);
		  subClassMethod(rs,stmt,ch);
		  if(ch==12) {
			  break;
		    }
         }
}
private static void subClassMethod(ResultSet rs, PreparedStatement stmt, int ch) throws SQLException {
	switch(ch) {
	  case 1:stmt.setInt(1,6);
             rs = stmt.executeQuery();
             getClassStrength(rs,6); break;
      case 2:stmt.setInt(1,7);
      		rs = stmt.executeQuery();
            getClassStrength(rs,7); break;
	  case 3:stmt.setInt(1,8);
            rs = stmt.executeQuery();
            getClassStrength(rs,8); break;
	  case 4:stmt.setInt(1,9);
             rs = stmt.executeQuery();
             getClassStrength(rs,9); break;
	  case 5:stmt.setInt(1,10);
            rs = stmt.executeQuery();
            getClassStrength(rs,10); break;
      default: break;
	  }
	
}
private static void getClassStrength(ResultSet rs, int i) throws SQLException {
	while(rs.next()) {
	    System.out.print("The strength of the class "+i+" is "+rs.getInt("count(*)")+"\n");
	}
	}

}