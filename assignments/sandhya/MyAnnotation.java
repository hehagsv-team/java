import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface MpsTrainee  
{
	String name();
	int num();
}
@MpsTrainee(name = "java", num = 1)
class Team{
	String task;
	int days;
	public Team(String str, int i) {
		this.task=str;
		this.days=i;
	}
}
public class MyAnnotation {
	public static void main(String[] args) {
		Team obj=new Team("log4j",1);
		System.out.println(obj.task);
		Class c=obj.getClass();
		Annotation ann=c.getAnnotation(MpsTrainee.class);
		MpsTrainee t=(MpsTrainee) ann;
		System.out.println(t.name());
		System.out.println(t.num());
	}
}
