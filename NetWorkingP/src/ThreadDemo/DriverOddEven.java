/**
 * 
 */
package ThreadDemo;

/**
 * @author M.NAVEEN
 * RANDOM CODER'S
 *
 */
/**
 * 
 * The wait() is called, so that the thread can wait for some 
 * condition to occur when this wait() call happens, 
 * the thread is forced to give up its lock.
 * To give up something, you need to own it first.
 * Thread needs to own the lock first. 
 * Hence the need to call it inside a synchronized method/block
 * 
 * */

public class DriverOddEven {

	public static void main(String[] args) throws InterruptedException {
		
		 PrintOddEven poe=new PrintOddEven(4);
		 Thread t1=new Thread(poe,"Even");
		 Thread t2=new Thread(poe,"ODD");
		 t1.start();
		 t2.start();
		 t1.join();
		 t2.join();
		 System.out.println("ENDDED !!!!");
		
	}

}

class PrintOddEven implements Runnable{
    int count =0;
    int max;
    PrintOddEven(int max){
    	this.max=max;
    }
	@Override
	public void run() {
		synchronized(this) {
		 while(count <=max) {	
				if(count % 2 ==0)
				{	
					System.out.println(Thread.currentThread().getName()+ " --> "+count);
					count++;
					try {
						wait(); 
						//System.out.println("Remused !!!!!!! "+Thread.currentThread().getName() +" cur "+count);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					notify();
				}else {
					System.out.println(Thread.currentThread().getName()+ " --> "+count);
					count++;
					notify();
					try {
						wait();
						//System.out.println("Remused !!!!!!! "+Thread.currentThread().getName() +" cur "+count);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			
		   }
		 notifyAll();
		}
		
	}
	
	

	
}



