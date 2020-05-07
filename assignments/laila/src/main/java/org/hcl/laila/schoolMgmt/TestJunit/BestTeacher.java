import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BestTeacher {
	protected Map<String, Object> classdetails(QueryClass queclass,ExecuteClass execlass, PreparedStatement prestat,Connection connection,int number,ResultSet resultset) throws SQLException {
		String method;
		MenuClass m=new MenuClass();
		Map<String, Object> execute = new HashMap<String, Object>();
		while(true) {
			m.classname();
			System.out.println("11: BAck to main menu:");
			//int number=scan.nextInt();
			method=queclass.query4(); 
			prestat=connection.prepareStatement(method);
			switch(number) {
			case 1:
				prestat.setString(1,"PHYSICS");
				resultset = prestat.executeQuery();
				execute=execlass.execute4thquery(resultset,"PHYSICS");
				break;
			case 2:           		  
				prestat.setString(1,"CHEMISTRY");
				resultset = prestat.executeQuery();
				execute=execlass.execute4thquery(resultset,"CHEMISTRY");
				break;
			case 3:
				prestat.setString(1,"BIOLOGY");
				resultset = prestat.executeQuery();
				execute=execlass.execute4thquery(resultset,"BIOLOGY");
				break;
			case 4:
				prestat.setString(1,"HISTORY");
				resultset = prestat.executeQuery();
				execute=execlass.execute4thquery(resultset,"HISTORY");
			case 5:
				prestat.setString(1,"GEOGRAPHY");
				resultset = prestat.executeQuery();
				execute=execlass.execute4thquery(resultset,"GEOGRAPHY");
				break;
			case 6:
				prestat.setString(1,"POLITICAL SCIENCE");
				resultset = prestat.executeQuery();
				execute=execlass.execute4thquery(resultset,"POLITICAL SCIENCE");
				break;
			case 7:
				prestat.setString(1,"ECONOMICS");
				resultset = prestat.executeQuery();
				execute=execlass.execute4thquery(resultset,"ECONOMICS");
				break;
			case 8:
				prestat.setString(1,"ENGLISH");
				resultset = prestat.executeQuery();
				execute=execlass.execute4thquery(resultset,"ENGLISH");
				break;
			case 9:
				prestat.setString(1,"HINDI");
				resultset = prestat.executeQuery();
				execute=execlass.execute4thquery(resultset,"HINDI");
				break;
			case 10:
				prestat.setString(1,"MATHS");
				resultset = prestat.executeQuery();
				execute=execlass.execute4thquery(resultset,"MATHS");
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
