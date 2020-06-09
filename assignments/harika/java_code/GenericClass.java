import java.io.*;

class MyGenericClass<String> {

	String variable;

	public void show() {
		System.out.println("harika");

	}



}	


public class GenericClass
{
	public static void main(String[] args) {

		MyGenericClass<String> obj = new MyGenericClass<String>();

		obj.show();

	}

}

