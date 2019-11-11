package project1;
 
 class GenericClass1<string> {

	 String variable;
	 public void show()
	 {
		 System.out.println(variable);
	 }
 }

public class GenericClass {

 
	public static void main(String[] args) {


 
		GenericClass1<String> obj = new GenericClass1<String>();
		obj.variable="san";
		obj.show();
	}


} 

