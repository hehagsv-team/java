package assignments.hemadri;

public class MyGenericClass {

	String variable;
	
	MyGenericClass () {
		this.variable = "";
	}
	
	
	public static void main(String[] args) {
		MyGenericClass<String> obj = new MyGenericClass<String>();
	}

}
