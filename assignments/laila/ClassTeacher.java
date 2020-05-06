import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class ClassTeacher {
	protected String classdetails(QueryClass queclass,ExecuteClass execlass, PreparedStatement prestat,Connection connection,int number,ResultSet rs, String execute) throws SQLException {
		String method;
		MenuClass m=new MenuClass();
		while(number <= 11) {
			m.classname();
			 System.out.println("11: Back to main menu:");
			method=queclass.TeacherParicularClass(); 
			prestat=connection.prepareStatement(method);
			switch(number) {
			case 1: 

				prestat.setInt(1,6);
				rs = prestat.executeQuery();
				execute=execlass.execute1stquery(rs,6);
				break;
			case 2:
				prestat.setInt(1,7);
				rs = prestat.executeQuery();
				execute=execlass.execute1stquery(rs,7);
				break;
			case 3:
				prestat.setInt(1,8);
				rs = prestat.executeQuery();
				execute=execlass.execute1stquery(rs,8);
				break;
			case 4:
				prestat.setInt(1,9);
				rs = prestat.executeQuery();
				execute=execlass.execute1stquery(rs,9);
				break;
			case 5:
				prestat.setInt(1,10);
				rs = prestat.executeQuery();
				execute=execlass.execute1stquery(rs,10);
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
			break;
		}
		return execute;

	}

}
