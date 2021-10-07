/**
 * 
 */
package ThreadDemo;
import java.util.*;
import java.util.Random;
/**
 * @author M.NAVEEN
 * RANDOM CODER'S
 *
 */
public class Workersdemo {

	 ArrayList<Integer>  l1=new ArrayList<Integer>();
	 ArrayList<Integer>  l2=new ArrayList<Integer>();
	public static void main(String[] args) throws InterruptedException {
		 System.out.println("Starting .................");
		 long start=System.currentTimeMillis();
		 
		 new Workersdemo().process();
		 
		 long end=System.currentTimeMillis();
         
		 System.out.println("TIME TAKEN IS : "+(end-start));
	}
   
	public void stageone() throws InterruptedException {
		Thread.sleep(1);
		l1.add(new Random().nextInt(100));
	}
	public void stagetwo() throws InterruptedException {
		Thread.sleep(1);
		l2.add(new Random().nextInt(100));
	}
	
	public  void process() throws InterruptedException {
		for(int i=0;i<1000;i++)
		{
			stageone();
			stagetwo();
		}
	}
}
