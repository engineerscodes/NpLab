/**
 * 
 */
package Threads;
import java.util.*;
import java.io.*;
/**
 * @author M.NAVEEN
 * RANDOM CODER'S
 *
 */
public class Main {

	public static void main(String ...strings) {
		
		X x =new X();
		Thread t2=new Thread(x);
		Thread t1=new Thread(x);
		t1.start();
		t2.start();
	}
	
	
}

class X implements Runnable{
	Hashtable<String,Integer> tb=new Hashtable<String,Integer>();
	public void run() {
		String temp="naveen";
		for(int i=0;i<20;i++) {
			tb.put(temp+i, i);
		}
		try {
			read(tb);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public void read(Hashtable<String,Integer> tb) throws InterruptedException {
		System.out.println("NAME "+Thread.currentThread().getName());
	    synchronized(tb) {
	    	
	    	for(Map.Entry<String, Integer> e:tb.entrySet()) {
	    		System.out.println(e.getKey() +"  "+e.getValue() +" Thread "+Thread.currentThread().getName());
	    		//wait();
	    		
	    	}
	    	//notifyAll();
	    }  	
	    
	}
}
