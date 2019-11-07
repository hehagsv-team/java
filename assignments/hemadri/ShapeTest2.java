package assignments.hemadri;

import java.util.Scanner;

interface Shape2
{
	float getArea(float[] parameters);
	float getperimeter(float[]parameters);
}

class Rectangle2 implements Shape2 {

	@Override
	public float getArea(float[] parameters) {
		return parameters[0]*parameters[1];
	}

	@Override
	public float getperimeter(float[] parameters) {
		return 2f*(parameters[0]+parameters[1]);
	}

}
class Square2 implements Shape2 {

	@Override
	public float getArea(float[] parameters) {
		return parameters[0]*parameters[1];
	}

	@Override
	public float getperimeter(float[] parameters) {
		return  4f*parameters[0];
	}

}
class Circle2 implements Shape2 
{

	@Override
	public float getArea(float[] parameters) {
		return 3.14f*parameters[0];
	}
	public float getperimeter(float[] parameters) 
	{
		return 0;
	}
}
class Parallelogram2 implements Shape2 
{
	public float getArea(float [] parameters)
	{
		return parameters[0]*parameters[1];   
	}

	public float getperimeter(float [] parameters)
	{
		return 2f*parameters[0]*parameters[1];
	}
}



public class ShapeTest2
{
	public static void main(String[] args)
	{
		Shape2 rect = new Rectangle2();
		Shape2 cir = new Circle2();
		Shape2 sq = new Square2();
		Shape2 paral =new Parallelogram2();
		int p=0;
		float n=0;
		float k;
		float[] par=new float[10];
		Scanner sc =new Scanner(System.in);
		System.out.printf("menu\n1.rectangle\n2.square\n3.circle\n4.parrallelogram\n");
		System.out.println("enter the shape to find area and perimeter:");
		int c;
		Scanner sc1=new Scanner(System.in);
		c=sc1.nextInt();
		switch(c)
		{
		case 1:
			System.out.println("enter the parameters for rectangle:");
			for(p=0;p<2;p++)
			{
				par[p]=sc.nextFloat();
			} 
			//                 k=getArea_Rect(par);
			//                 n=getperimeter_Rect(par);
			System.out.println("area of the rectangle is"+ rect.getArea(par));
			System.out.println("perimeter of the rectangle is"+rect.getperimeter(par));
			break;
		case 2:
			System.out.println("enter the parameters for square:");
			for(p=0;p<2;p++)
			{
				par[p]=sc.nextFloat();
			}
			// k=getArea_square(par);
			// n=getArea_square(par);
			System.out.println("area of the square is"+sq.getArea(par));
			System.out.println("perimeter of the square is"+sq.getperimeter(par));
			break;
		case 3:
			System.out.println("enter the parameters for circle:");
			par[p]=sc.nextFloat();
			//  k=getarea_circle(par);
			System.out.println("area of the circle is"+cir.getArea(par));
			break;
		case 4:
			System.out.println("enter the parameters for parrallelogram:");
			for(p=0;p<2;p++)
			{
				par[p]=sc.nextFloat();
			} 
			// k=getarea_parrallelogram(par);
			System.out.println("area of the parallelogram is"+ paral.getArea(par));
			System.out.println("perimeter of the parallelogram is"+paral.getperimeter(par));
			break;
		}

	}



}

