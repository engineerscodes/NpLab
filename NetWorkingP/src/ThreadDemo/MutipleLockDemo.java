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
public class MutipleLockDemo {

	static ArrayList<Integer>  l1=new ArrayList<Integer>();
	static ArrayList<Integer>  l2=new ArrayList<Integer>();
	public static void main(String[] args) throws InterruptedException {
		 System.out.println("Starting .................");
		 long start=System.currentTimeMillis();
		 
		 Thread t1=new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					process();
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
				
			}
			 
		 });
		 
		 Thread t2=new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					process();
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
				
			}
			 
		 });
		 
		 t1.start();
		 t2.start();
		 t1.join();
		 t2.join();
		 
		 
		 long end=System.currentTimeMillis();
         
		 System.out.println("TIME TAKEN IS : "+(end-start));
		 System.out.println(l1.size() +"  "+l2.size());
	}
   
	public static void stageone() throws InterruptedException {
		Thread.sleep(1);
		l1.add(new Random().nextInt(100));
	}
	public  static synchronized void stagetwo() throws InterruptedException {
		Thread.sleep(1);
		l2.add(new Random().nextInt(100));
	}
	
	public static synchronized void process() throws InterruptedException {
		for(int i=0;i<1000;i++)
		{
			stageone();
			stagetwo();
		}
	}
}
