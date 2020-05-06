import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ExecuteClass {
	public String execute1stquery(ResultSet resultset, int number) throws SQLException {
		String result = "";
		while(resultset.next()) {
			System.out.print("The name of the teacher in the particular class "+number+" "+resultset.getString("name")+"\n");
			result = resultset.getString("name");
		}
		return result;
	}	
	public String execute2ndquery(ResultSet rs, int number) throws SQLException {
		String result="";
		while(rs.next()) {
			System.out.print("Average marks in class "+number+"  "+rs.getInt("Average")+"\n"); 
			result = rs.getString("Average");
		}
		return result;
	} 
	public String execute3rdquery(ResultSet rs, String str) throws SQLException {
		System.out.print("The mark distribution of a subject "+str+" \n");		
		while(rs.next()) {
			System.out.println("count:"+rs.getInt("count(*)")+" "+"marks-range:"+rs.getString("marks"));
		}
		return str; 
	}
	public Map<String, Object> execute4thquery(ResultSet rs, String str) throws SQLException {
		System.out.print("TeacherName who teaches the SubjectName "+str+" better \n");	
		Map<String, Object> map = new HashMap<>();
		while(rs.next()) {
			System.out.println("class:"+rs.getInt("class")+"  "+"Average:"+rs.getInt("Average")+"  "+"Teachers-name: "+rs.getString("teacher"));
			map.put("class", rs.getInt("class"));
			map.put("average", rs.getInt("Average"));
			map.put("teacher", rs.getString("teacher"));
		}
		return map; 
	}
	public String execute5thquery(ResultSet rs, int number) throws SQLException {
		System.out.println("The topper in the class "+number+" :");
		while(rs.next()) {
			System.out.print("Name of the student: "+rs.getString("NameofTheStudent")+"   Number of Marks: "+rs.getInt("Totalmarks"));
		}
		return null;
	}
	public String execute6thquery(ResultSet rs, String method) throws SQLException {
		System.out.println("The topper of the subject "+method+" :");
		while(rs.next()) {
			System.out.print("Name of the student: "+rs.getString("studentname")+"   Number of Marks: "+rs.getInt("highestmarks"));
			System.out.println();
		}
		return method;		
	}
	public String execute7thquery(ResultSet rs, int number) throws SQLException {
		System.out.println("class teacher of the class  "+number+":");
		while(rs.next()) {
			System.out.print("Name of the Classteache: "+rs.getString("name")+"  Number of subjects: "+rs.getString("subject_count"));
			System.out.println();
		}
		return null;
	}
	public String execute9thquery(ResultSet rs, int number) throws SQLException {
		String result="";
		while(rs.next()) {
			System.out.print("count(id)"+number+"   "+rs.getInt("count(id)")+"\n");
			result = rs.getString("count(id)");
		}
		return result;
	}

}
