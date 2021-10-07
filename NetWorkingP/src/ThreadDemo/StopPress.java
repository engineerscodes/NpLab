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
public class StopPress {



	public static void main(String[] args) {
		
		Xs x=new Xs();
		
		Thread t1=new Thread(x);
		//Thread t2=new Thread(x);
		t1.start();
		
		System.out.println("TO STOP PRESS ANY KEY ");
		new Scanner(System.in).nextLine();
		x.stop();
		System.out.println(" STOPPED  ");

	}

}

class Xs implements Runnable{
	
	public volatile boolean running=true;  // volatile to prevent thread caching varibles 
	
	public void run() {
		
		while(running) {
			
			System.out.println("HELLO");
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		
	}
	
	public void stop() {
		running=false;
	}
	
}