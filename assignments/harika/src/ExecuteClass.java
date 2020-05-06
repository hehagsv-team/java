import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ExecuteClass {
	public String execute1stquery(ResultSet rs, int number) throws SQLException {
		String result="";
		while(rs.next()) {
			System.out.print("The name of the teacher in the particular class "+number+" "+rs.getString("name")+"\n");
			result=rs.getString("name")+"";
		}
		return result;
	}	
	public String execute2ndquery(ResultSet rs, int number) throws SQLException {
		String result="";
		while(rs.next()) {
			System.out.print("Average marks in class "+number+"  "+rs.getInt("Average")+"\n"); 
			result=rs.getInt("Average")+"";
		}
		return result ;
	} 
	public String execute3rdquery(ResultSet rs, String str) throws SQLException {
		System.out.print("The mark distribution of a subject "+str+" \n");	
		String result="";
		while(rs.next()) {
			System.out.println("count:"+rs.getInt("count(*)")+" "+"marks-range:"+rs.getString("marks"));
			result=rs.getInt("count(*)")+"";
			result=rs.getString("marks")+"";
		}
		return result ;
	}
	public String execute4thquery(ResultSet rs, String str) throws SQLException {
		System.out.print("TeacherName who teaches the SubjectName "+str+" better \n");	
		String result="";
		while(rs.next()) {
			System.out.println("class:"+rs.getInt("class")+"  "+"Average:"+rs.getInt("Average")+"  "+"Teachers-name: "+rs.getString("teacher"));
			result=rs.getInt("class")+"";
			result=rs.getInt("Average")+"";
			result=rs.getString("teacher")+"";
		}
		return result ;
	}
	public String execute5thquery(ResultSet rs, int number) throws SQLException {
		System.out.println("The topper in the class "+number+" :");
		String result="";
		while(rs.next()) {
			System.out.print("Name of the student: "+rs.getString("NameofTheStudent")+"   Number of Marks: "+rs.getInt("Totalmarks"));
			result=rs.getString("NameofTheStudent")+"";
			result=rs.getInt("Totalmarks")+"";
		}
		return result ;
	}
	public String execute6thquery(ResultSet rs, String method) throws SQLException {
		System.out.println("The topper of the subject "+method+" :");
		String result="";
		while(rs.next()) {
			System.out.print("Name of the student: "+rs.getString("studentname")+"   Number of Marks: "+rs.getInt("highestmarks"));
			result=rs.getString("studentname")+"";
			result=rs.getInt("highestmarks")+"";
			System.out.println();
		}
		return result ;		
	}
	public String execute7thquery(ResultSet rs, int number) throws SQLException {
		System.out.println("class teacher of the class  "+number+":");
		String result="";
		while(rs.next()) {
			System.out.print("Name of the Classteache: "+rs.getString("name")+"  Number of subjects: "+rs.getString("subject_count"));
			result=rs.getString("name")+"";
			result=rs.getString("subject_count")+"";
			System.out.println();
		}
		return result ;
	}
	public String execute9thquery(ResultSet rs, int number) throws SQLException {
		String result="";
		while(rs.next()) {
			System.out.print("count(id)"+number+"   "+rs.getInt("count(id)")+"\n");
			result=rs.getInt("count(id)")+"";
		}
		return result ;
	}

}
