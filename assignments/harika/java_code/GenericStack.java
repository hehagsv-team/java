import java.util.Vector;
import java.util.Scanner;

class LinkedStack1<T>
{
	int top;
	int size;

	Vector<T> astack = new Vector<T>();
	public LinkedStack1()
	{
		this.astack= (Vector<T>) new Vector<Integer>();
		this.top=0;
		this.size=0;
	}
	
	public void push(T obj)
	{
		if(top+1==size) 
			System.out.println("push not possible");
		else
			astack.add(obj);
		top++;
		size++ ;
	}

	public boolean isEmpty()
	{
		if(top==0)
		{
			return true;
		}
    	else
		{
			return false;
		}
	}
		
	public T pop()
	{
		if(isEmpty())
		{
			return null;
		}
		return astack.get(top--);				
	}		
	
	public int getSize()
	{
     	return size;
	}

	public T peek() {

		if(isEmpty())
		{
			return null;
		}
		return astack.get(top-1);
	}
	
	public void display()
	{
		System.out.println("Stack:");
		if (size == 0)
		{
			System.out.print("Empty\n");
			return ;
		}
		else
		{
			
			for(int i=top;i>0;i--)
				System.out.print(astack.get(i-1)+" ");
			System.out.println();
		}
	}
}

public class GenericStack {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		LinkedStack1<Integer> obj =new LinkedStack1<Integer>();
		System.out.println("Linked Stack Test\n");      
		char ch;
		do{
			System.out.println("\nStack Operations");
			System.out.println("1. push");
			System.out.println("2. pop");
			System.out.println("3. peek");
			System.out.println("4. check empty");
			System.out.println("5. size");
			int choice = scan.nextInt();
			switch (choice)
			{
			case 1 : 
				System.out.println("Enter integer element to push");
				obj.push( scan.nextInt());
				break;                         
			case 2 : 
				try
				{
					System.out.println("pop Element = "+obj.pop());
				}
				catch(Exception e)
				{
					System.out.println("Error : " +e.getMessage());
				}
				break;                         
			case 3 : 
				try
				{
					System.out.println("Peek Element = "+obj.peek());
				}
				catch(Exception e)
				{
					System.out.println("Error : "+e.getMessage());
				}
				break;                            
			case 4 : 
				System.out.println("Empty status = "+obj.isEmpty());
				break;                
			case 5 : 
				System.out.println("Size = "+ obj.getSize());
				break;                         
			default : System.out.println("Wrong Entry \n ");
			break;
			}
			obj.display();            
			System.out.println("\nDo you want to continue (Type y or n) \n");
			ch = scan.next().charAt(0);
		} while (ch == 'Y'|| ch == 'y');  
	}    
}
