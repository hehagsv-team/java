package assignment.sandhya.queue;


import java.util.Scanner;
import java.util.Vector;

class LinkedList1<T>
{
	 int front;
	 int rear;
	 int size;
	 Vector<T> q = new Vector<T>();
	
	public LinkedList1()
	{
		this.q= (Vector<T>) new Vector<Integer>();
		this.front=0;
		this.rear=-1;
		this.size=0;
	}
	
	public void insert(T obj)
	{
		q.add(obj);
		rear++;
		size++;
	}
	
	public boolean isEmpty()
	{
		if(front>rear)
		{
			return true;
		}
		else{
			return false;
		}
	}
	public T remove()
	{
		if(isEmpty())
		{
			return null;
		}
		return q.get(front++);				
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
		return q.get(front);
	}
	public void display()
	{
		System.out.println("Queue:");
		if (size == 0)
		{
			System.out.print("Empty\n");
			return ;
		}
		else
		{
			for(int i=front;i<=rear;i++)
				System.out.print(q.get(i)+" ");
			
		}
	}
}
public class GenericQueue {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		LinkedList1<Integer> obj =new LinkedList1<Integer>();
		System.out.println("Linked Queue Test\n");      
		char ch;
		do{
			System.out.println("\nQueue Operations");
			System.out.println("1. insert");
			System.out.println("2. remove");
			System.out.println("3. peek");
			System.out.println("4. check empty");
			System.out.println("5. size");
			int choice = scan.nextInt();
			switch (choice)
			{
			case 1 : 
				System.out.println("Enter integer element to insert");
				try
				{
					obj.insert( scan.nextInt() );
				}
				catch(Exception e)
				{
					System.out.println("Error : " +e.getMessage());
				}                         
				break;                         
			case 2 : 
				try
				{
					System.out.println("Removed Element = "+obj.remove());
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
