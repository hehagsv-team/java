package src.main.java.org.hcl.harika.schoolMgmt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ClassStrength {
	public String classdetails(QueryClass queryClass,ExecuteClass e,Connection connection,String execute,Scanner scan,boolean isTest) throws SQLException {
		String str;
		PreparedStatement ps;
		ResultSet rs;				
		MenuClass m=new MenuClass();
		while(true) {
			m.classname();
			int number = 11;
			if(isTest) {
				if(!scan.hasNext()) {
					scan = new Scanner("11");
				}
				number=Integer.valueOf(scan.nextLine()).intValue();
			} else {
				number = scan.nextInt();
			}
			
			str=queryClass.ClassStrengthQuery(); 
			ps=connection.prepareStatement(str);
			switch(number) {
			case 1:  
				ps.setInt(1,6);
				rs = ps.executeQuery();
				execute=e.execute9thquery(rs,6);
				break;
			case 2:
				ps.setInt(1,7);
				rs = ps.executeQuery();
				execute=e.execute9thquery(rs,7);
				break;
			case 3:
				ps.setInt(1,8);
				rs = ps.executeQuery();
				execute=e.execute9thquery(rs,8);
				break;
			case 4:
				ps.setInt(1,9);
				rs = ps.executeQuery();
				execute=e.execute9thquery(rs,9);
				break;
			case 5:
				ps.setInt(1,10);
				rs = ps.executeQuery();
				execute=e.execute9thquery(rs,10);
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