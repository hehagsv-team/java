package proj1;

import java.util.Stack;



class ThreadPool {



    	Stack<Integer> stack=new Stack<>();

		String threadName;

       ThreadPool (Stack<Integer> stack, String threadName) {

    	   this.stack=stack;

    	   this.threadName=threadName;



              new ThreadPoolRunner (stack,"Thread-1").start();

              new ThreadPoolRunner (stack,"Thread-2").start();

              new ThreadPoolRunner (stack,"Thread-3").start();

              new ThreadPoolRunner (stack,"Thread-4").start();

              new ThreadPoolRunner (stack,"Thread-5").start();



       }



      



       void queueTask(Task aTask) {

              // TODO: complete

              // add task

       }

}



 



class ThreadPoolRunner extends Thread{

       public ThreadPoolRunner(String string) {

              super (string);

       }

       

   Stack<Integer> stack=new Stack<>();

	String threadName;

       public ThreadPoolRunner(Stack<Integer> stack,String threadName) {

    	   this.stack=stack;

    	   this.threadName=threadName;

	}

       public void run () {

           synchronized(this) {   

           while (true) {

                         // any task to execute?

                         // take a task if there is any and execute

                         // TODO: complete

                	  if(!stack.isEmpty()) {

                		  System.out.println(stack);

                		  int removedValue=stack.pop();

                		  System.out.println(" item : "+removedValue+ " by " +threadName);

                		  

                		  try {

                			  

                			System.out.println(threadName+ " going to wait state after taking one item from stack");

							this.wait(1000);

						} catch (InterruptedException e1) {

							e1.printStackTrace();

						}

                		  try {

							Thread.sleep(2000);

						} catch (InterruptedException e) {

							e.printStackTrace();

						}

                    	 

                	  }

                	  else {

                		  System.out.println(threadName+ " going to wait state as stack is empty");

                		  try {

							this.wait(1000);

						} catch (InterruptedException e) {

							e.printStackTrace();

							

						}

                	  }

                	  

                  }

        	   

           }

       }

}

class Task {



       private static int counter = 0;

       private int id;



       public Task () {

              id = counter++;

       }



       public void execute () {

              System.out.println(Thread.currentThread().getName());



              try {

                     System.out.println("Executing Task #"+id);

                     Thread.sleep(5000);

              } catch (InterruptedException e) {



                     e.printStackTrace();



              }

       }

}



class MainThread{

	public static void main(String[] args) throws InterruptedException {

		Stack<Integer> stack=new Stack<>();

		String threadName = null;

		ThreadPool threadpool=new ThreadPool(stack,threadName);

		int stackCapacity=5;

		int stackValue=0;

		synchronized(threadpool) {

			while(true)

			{

				while(stack.size()==stackCapacity)

					threadpool.wait();

				for(int i=0;i<5;i++) {

				stack.add(stackValue++);}

				threadpool.notifyAll();

				Thread.sleep(3000);

		

			}

		}

	}

}
