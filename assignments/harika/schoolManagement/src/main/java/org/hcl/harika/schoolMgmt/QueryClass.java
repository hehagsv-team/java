package src.main.java.org.hcl.harika.schoolMgmt;
public class QueryClass { 
	String sql;
public String MarksDistributionQuery() {
  	 return sql = "select count(*),\r\n" + 
 	 		"(case \r\n" + 
 	 		"          when marks between 50 and 59 then '50-59'\r\n" + 
 	 		"          when marks between 60 and 69 then '60-69'\r\n" + 
 	 		"          when marks between 70 and 79 then '70-79'\r\n" + 
 	 		"          when marks between 80 and 89 then '80-89'\r\n" + 
 	 		"         else 'above 90'\r\n" + 
 	 		"end)marks from marks \r\n" + 
 	 		"inner join subject on marks.subject_id=subject.id\r\n" + 
 	 		"where name=?"+
 	 		"group by marks";
} 

public String BestTeacherQuery() {
	return sql = "select class, Average,teacher from(\r\n" + 
			"select subject.class_name as class,avg(marks) as Average,subject.name ,teacher.name as teacher,dense_rank() over( partition by subject.name order by avg(marks) desc) top\r\n" + 
			"from marks\r\n" + "inner join subject on marks.subject_id=subject.id \r\n" + 
			"inner join teacher on subject.teacher_id=teacher.id\r\n" +
			"where subject.name=?"+
			"group by subject.class_name,subject.name,teacher.name)a where top=1";
}
public String StudentTopperQuery() {
	 return sql = "select NameofTheStudent,Totalmarks from(\r\n" + 
	 		"select  class.name as ClassName,student.name as NameofTheStudent,sum(marks) as Totalmarks, dense_rank()\r\n" + 
	 		"over( partition by class.name order by sum(marks) desc) Topper from marks \r\n" + 
	 		"inner join student  on marks.student_id=student.id\r\n" + 
	 		"inner join class  on student.class_name=class.name\r\n" + 
	 		"where class.name=?\r\n" + 
	 		"group by class.name,student.name)a  where topper=1";
	 }
public String StudentTopperInSubjectQuery() {
	return sql = "select subjectname,studentname,highestmarks\r\n" + 
			"from (select  class.name as ClassName,subject.name as SubjectName,student.name as studentname,marks as highestmarks, dense_rank() \r\n" + 
			"over( partition by subject.name order by marks desc) Topper from marks\r\n" + 
			"inner join subject on marks.subject_id=subject.id \r\n" + 
			"inner join student  on student.id=marks.student_id \r\n" + 
			"inner join class on subject.class_name=class.name\r\n" + 
			"where class.name=? and subject.name=? )a  where topper=1";
}

public String AllSubjectsQuery() {
	return sql = "select teacher.name,subject.name as subject_count from  teacher\r\n" + 
			"join class on class.teacher_id=teacher.id\r\n" + 
			"join subject  on teacher.id=subject.teacher_id\r\n" + 
			"where class.name=?\r\n" + 
			"group by teacher.name,subject.name\r\n";
}
public String TeacherTeachesSubjectQuery() {
    return sql = "select teacher.name,count(teacher_id) as subject_count from subject \r\n" + 
    		"join teacher on subject.teacher_id=teacher.id\r\n" + 
    		"group by teacher.name";
}
public String ClassStrengthQuery() {
	return sql = "select count(id) from student\r\n" + 
			"join class  on student.class_name=class.name\r\n" + 
			"where class.name=?\r\n";
}
public String ClassTeacherQuery() {
	return sql = "select teacher.name\r\n" + 
       		"from class \r\n" + 
       		"join teacher \r\n" + 
       		"on teacher.id=class.teacher_id\r\n" + 
       		"where class.name=?";
}
public String AverageMarksQuery() {
	return sql = "select avg(marks) as average from marks\r\n" + 
	   		"inner join student on marks.subject_id=student.id\r\n" + 
	   		"inner join subject on student.id=subject.id\r\n" + 
	   		"inner join class on subject.teacher_id=class.teacher_id\r\n" + 
	   		"where class.name=?";
}



} 
