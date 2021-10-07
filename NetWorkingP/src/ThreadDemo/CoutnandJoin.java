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
public class CoutnandJoin {
    
	public static Integer count=0;
	
	public static synchronized void readcount() {
		 count++;
	}
      
	public static void main(String[] args) throws InterruptedException {
	
		Runnable r1=new Runnable() {

			@Override
			public void run() {
				
				for(int i=0;i<10000;i++)
				    readcount();
			}
			
		};
		
		Runnable r2=new Runnable() {

			@Override
			public void run() {
				
				for(int i=0;i<10000;i++)
					readcount();
				
			}
			
		};
		
		Thread t1=new Thread(r1);
		Thread t2=new Thread(r2);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println("TOTAL COUNT : "+count);

	}

}

