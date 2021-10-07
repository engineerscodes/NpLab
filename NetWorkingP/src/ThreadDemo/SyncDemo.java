/**
 * 
 */
package ThreadDemo;
import java.util.*;

/**
 * @author M.NAVEEN
 * RANDOM CODER'S
 *
 */
public class SyncDemo {

	
	public static void main(String[] args) throws InterruptedException {
		
		sent s=new sent();
		
		ThreadSent t1=new ThreadSent("Naveen",s);
		ThreadSent t2=new ThreadSent("BALA",s);
		
		t1.start();
		t2.start();
		t1.join(); // java thread join method can be use to pause the current thread from executing until unless the specified 
		// is thread is dead  and the current thread is = main thread  and  specified is thread is =t1
		t2.join();
		 // java thread join method can be use to pause the current thread from executing until unless the specified 
		// is thread is dead  and the current thread is = main thread  and  specified is thread is =t2
      System.out.println("WAITS TILL J1 AND J2 IS OVER BECAUSE OF JOIN  ");
      // if not join then main thread will execute before t1 and t2
	}

}
 
class sent{
	
	public void send(String text) {
		
		System.out.println("Sending :- "+text);
		try {
			Thread.sleep(1000);
		}
		catch(Exception e) {
			System.out.println("Thread interrupted ");
			
		}
		System.out.println(text +" send !!!!!!!!!!!!!");
	}
	
}

class ThreadSent  extends Thread
{    private String msg; 
     sent sender; 

	ThreadSent(String m, sent obj) 
	{ 
		msg = m; 
		sender = obj; 
	 } 

	public void run() {
		sender.send(msg);
	}
}
