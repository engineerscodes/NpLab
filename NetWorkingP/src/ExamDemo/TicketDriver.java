/**
 * 
 */
package ExamDemo;

/**
 * @author M.NAVEEN
 * RANDOM CODER'S
 *
 */
public class TicketDriver {

	
	public static void main(String ...strings) {
		
		BookTicket bt=new BookTicket();
		Thread t1=new Thread(bt);
		Thread t2=new Thread(bt);
		Thread t3=new Thread(bt);
		Thread t4=new Thread(bt);
		Thread t5=new Thread(bt);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		
	}

}

class BookTicket implements Runnable {
	
	static int MaxSeat=4;
	static int curSeat=0;
	
	
	public static synchronized void bookseats() {
		
		System.out.println("Entered Booking !!");
		
		if(curSeat<MaxSeat) {
			System.out.println("Waiting for PayMents !");
			try {
				Thread.sleep(2000);
				System.out.println("Ticket Confirmed at  : "+curSeat +" - "+Thread.currentThread().getName());
				curSeat++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("NO SEAT AVAILABLE " +Thread.currentThread().getName());
		}
		  
		System.out.println("DONE");
	}


	@Override
	public void run() {
		
		bookseats();
		
	}
	
	
	
	
	
}
