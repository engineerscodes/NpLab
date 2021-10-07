/**
 * 
 */
package ExamDemo;

import java.util.Random;
import java.util.Scanner;

/**
 * @author M.NAVEEN
 * RANDOM CODER'S
 *
 */
public class MovieTicket {

	
	
	public static void main(String ...strings) throws InterruptedException {
		
		Movie m1=new Movie(2,true);
		Movie m2=new Movie(4,true);
		Movie m3=new Movie(2,false);
		Movie m4=new Movie(5,true);
		
		Thread t1=new Thread(m1);
		Thread t2=new Thread(m2);
		Thread t3=new Thread(m3);
		Thread t4=new Thread(m4);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		t1.join();
		t2.join();
		t3.join();
		t4.join();
		System.out.println(m1.AMaxSeat);
		
		System.out.println((byte)295.04);
		
		
	}

}


class Movie implements Runnable{
	volatile static int AMaxSeat=10;
	int NoofSeats;
	boolean payment;
	Movie(int NoofSeats,boolean pay){
		this.NoofSeats=NoofSeats;
		this.payment=pay;
	}
	
	public boolean checkpayemt() {
		return this.payment;
	}
	
	public synchronized void bookTicket(int Seats) {
		
		
			System.out.println("Waiting for Payments  To Confirmation No of seats : "+this.NoofSeats+"  "+AMaxSeat);
		  try {
			   
				 if(this.NoofSeats<=AMaxSeat) {
				  AMaxSeat=AMaxSeat-this.NoofSeats;
				  System.out.println("NEW AVAIL " + AMaxSeat+" THREAD :"+Thread.currentThread().getName());
				  Thread.sleep(1000);
				  //wait(1000);
				  if(this.checkpayemt())
					 {
						 System.out.println("Confirmed Seats  : "+this.NoofSeats);
					 }
				  else {
						 AMaxSeat=AMaxSeat+this.NoofSeats;
						 System.out.println("PAYMENT FAILED !"); 
					 }
			      }else {
			    	  System.out.println("SOLD OUT "+Thread.currentThread().getName());
			      }
			   
			 
			 
			
			//check payments method after waiting for 500milli second
			
			 
		} catch (Exception e) {
			
			e.printStackTrace();
		}
			
		
		
		System.out.println("-----------------------DONE -------------------------------------");
	}

	@Override
	public void run() {
		this.bookTicket(this.NoofSeats);
	}
	
}