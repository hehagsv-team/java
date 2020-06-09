class Counter {

	int count=0;

    public void display() {

           // write code

    	System.out.println("after 5 secs-count :  "+ ++count);

    }

}



class Timer {

    // will tell the Counter.display() method to print every 5 sec

	public static void main(String[] args) throws InterruptedException

	{	

		

		Counter counter1=new Counter();

		synchronized (counter1) {

			do

			{

				counter1.wait(5000,5000);

				counter1.display();

			}while(true);

		}

		

	}

}