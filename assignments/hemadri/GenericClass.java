package assignments.hemadri;

public class GenericClass {

	String variable;
	
	GenericClass () {
		this.variable = "";
	}
	
	
	public static void main(String[] args) {
		GenericClass<String> obj = new GenericClass<Integer>();
	}

}
