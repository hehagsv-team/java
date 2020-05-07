import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class SchoolSchema {
	static final String JDBC_DRIVER = "org.h2.Driver";  
	public static void main(String[] args) { 
		Connection connection = null; 
		PreparedStatement ps = null;
		String method;
		Scanner scan = new Scanner(System.in);
		MenuClass m=new MenuClass();
		ResultSet resultset = null;
		String execute=null;			
		try { 
			System.out.println("Connecting to database..."); 
			connection = DatabaseConnection.getConnection();
			QueryClass queclass=new QueryClass();
			ExecuteClass execlass=new ExecuteClass();
			while(true) {	        	
				m.schooljdbc();
				int choice = scan.nextInt();
				switch(choice) {
				case 1:
					ClassTeacher ct=new ClassTeacher();
					ct.classdetails(queclass, execlass, ps, connection, scan.nextInt(), resultset, execute);
					break;
				case 2:
					AverageMarks am=new AverageMarks();
					am.classdetails(queclass, execlass, ps, connection, scan.nextInt(), resultset, execute);
					break;	            	      
				case 3: 
					MarksDistribution md=new MarksDistribution();
					md.classdetails(queclass, execlass, ps, connection, scan, resultset, execute);
					break;
				case 4:
					BestTeacher bt=new BestTeacher();
					bt.classdetails(queclass, execlass, ps, connection, scan.nextInt(), resultset);
					break; 
				case 5:
					StudentTopper st=new StudentTopper();
					st.classdetails(queclass, execlass, ps, connection, scan.nextInt(), resultset, execute);
					break;
				case 6:
					StudentTopperInSubjects sts= new StudentTopperInSubjects();
					sts.classdetails(queclass, execlass, ps, connection, scan, resultset, execute);
					break;
				case 7:
					AllSubjects as=new AllSubjects();
					as.classdetails(queclass, execlass, ps, connection, scan, resultset, execute);
					break;
				case 8:
					TeacherTeachesSubjects tts= new TeacherTeachesSubjects();
					tts.classdetails(queclass, execlass, ps, connection, scan, resultset, execute);
					break;
				case 9:
					ClassStrength cs=new ClassStrength();
					cs.classdetails(queclass, execlass, ps, connection, scan.nextInt(), resultset, execute);
					break;
				case 11:
					break;
				default:
					System.out.println("wrong entry");
					break;
				}	  
				if(choice==11)  {
					System.out.println("Schema finished");
					break;
				}	
			}

			connection.close(); 
		} catch(SQLException se) { 
			se.printStackTrace(); 
		} catch(Exception e) { 
			e.printStackTrace(); 
		} 
	}
}

