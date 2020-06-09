package assignments.hemadri;

import java.util.Scanner;

interface Shape
{
	float getArea(float[] parameters);
	float getperimeter(float[]parameters);
}

class Rectangle implements Shape {

	@Override
	public float getArea(float[] parameters) {
		return parameters[0]*parameters[1];
	}

	@Override
	public float getperimeter(float[] parameters) {
		return 2f*(parameters[0]+parameters[1]);
	}
	
}

public class TestShape
{

	public static void main(String[] args)
	{
		
		Shape rect = new Rectangle();
//		Shape circle = new Circle();
//		Shape sq = new Square();
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
		  case 1:System.out.println("enter the parameters for rectangle:");
		          for(p=0;p<2;p++)
                   {
	                  par[p]=sc.nextFloat();
                   } 
//                 k=getArea_Rec(par);
//                 n=getperimeter_Rec(par);
               	System.out.println("area of the rectangle is"+ rect.getArea(par));
                System.out.println("perimeter of the rectangle is"+rect.getperimeter(par));
		  			
		          break;
		  case 2:System.out.println("enter the parameters for square:");
		          break;
		  case 3:System.out.println("enter the parameters for circle:");
			     par[p]=sc.nextFloat();
			     k=getarea_circle(par);
			     System.out.println("area of the circle is"+ k);
			     break;
		  case 4:System.out.println("enter the parameters for parrallelogram:");
		               for(p=0;p<2;p++)
			           {
				            par[p]=sc.nextFloat();
			           } 
		            k=getarea_parrallelogram(par);
		         	System.out.println("area of the parallelogram is"+ k);
		         break;            
		}
		for(p=0;p<2;p++)
		{
			par[p]=sc.nextFloat();
		}
		if(par[p]==par[p+1])
		{
			 k=getArea_square(par);
				System.out.println("area of the square is"+ k);
		}
		n=getperimeter_square(par);
		System.out.println("perimeter of the square"+n);
	
	}

	/*
	 * public static float getArea_Rec(float[] parameters) {
	 * 
	 * }
	 */
		
	public static float getArea_square(float[]parameters)
	{
		int i=0,j=1;
		return parameters[i]*parameters[j];
		
	}
	public static float getarea_circle(float[]parameters)
	{
		int i=0;
		return 3.14f*parameters[i]*parameters[i];
	}
	public static float getarea_parrallelogram(float[]parameters)
	{
		int i=0,j=1;
		return parameters[i]*parameters[j];
	}

	/*
	 * public static float getperimeter_Rec(float[] parameters) { int i=0,j=1;
	 * return }
	 */
    public static float getperimeter_square(float [] parameters)
    {
    	int i=0,j=1;
    	return 4f*parameters[i];
    }
}

