import java.util.*;


class Node
{
	protected int data;
	protected Node link;
		
	public Node(int d,Node n)
	{
		data=d;
		link=n;
	}
	
	public void setlink(Node n)
	{
		link=n;
	}
	
	public void setdata(int d)
	{
		data=d;
	}
	
	public Node getlink()
	{
		return link;
	}
	
	public int getdata()
	{
		return data;
	}
	
}

class LinkedStackImplement {
	protected Node top;
	protected int size;
	public LinkedStackImplement()
	{
	top=null;
	size=0;
	}
	public boolean isEmpty()
	{
		return top==null;
	}
	public int getsize()
	{
		return size;
	}
	public void push(int data)
	{
		Node hr=new Node(data,null);
		if(top==null)
			top=hr;
		else
		{
			hr.setlink(top);
			top=hr;
		}
		size++;
	}
	
	public int pop()
	{
		if(isEmpty())
			throw new NoSuchElementException("Underflow Exception");
		Node rh=top;
		top=rh.getlink();
		size--;
		return rh.getdata();
	}
	public int peek()
	{
		if(isEmpty())
			throw new NoSuchElementException("Underflow Exception");
		return top.getdata();
	}
	public void display()
	{
		System.out.println("\nStack=");
		if(size==0)
		{
			System.out.println("Empty\n");
			return;
		}
		Node rh=top;
		while(rh!=null)
		{
			System.out.println(rh.getdata()+" ");
			rh=rh.getlink();	
		}
		System.out.println();
		
	}
}
public class LinkedStack
{
	public static void main(String[] args)
	{
		Scanner scan=new Scanner(System.in);
		LinkedStackImplement ls=new LinkedStackImplement();
		System.out.println("linked stack test\n");
		char ch;
		do
		{
			System.out.println("\nlinked stack Operations");
			System.out.println("1. push");
			System.out.println("2. pop");
			System.out.println("3.peek");
			System.out.println("4.check empty");
			System.out.println("5.size");
			int choice=scan.nextInt();
			switch (choice)
			{
			case 1:
				System.out.println("Enter integer element to push");
				ls.push(scan.nextInt());
				break;
			case 2:
				try
				{
					System.out.println("popped element="+ ls.pop());
				}
				catch(Exception e)
				{
					System.out.println("Error:"+ e.getMessage());
				}
				break;
			case 3:
				try
				{
					System.out.println("peek element="+ ls.peek());
				}
				catch(Exception e)
				{
					System.out.println("Error:"+ e.getMessage());
				}
				break;
			case 4:
				System.out.println("Empty status="+ls.isEmpty());
			break;
			case 5:
				System.out.println("size="+ ls.getsize());
				break;
			case 6:
				System.out.println("stack=" );
				ls.display();
				break;
			default:
				System.out.println("Wrong entry\n");
				break;
			}
			ls.display();
			System.out.println("\n do you want to continue(type y or n)\n");
			ch=scan.next().charAt(0);
		}while(ch=='y' || ch=='Y');
			
	}
	
}

