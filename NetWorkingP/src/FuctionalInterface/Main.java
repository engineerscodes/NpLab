/**
 * 
 */
package FuctionalInterface;

/**
 * @author M.NAVEEN
 * RANDOM CODER'S
 *
 */

interface book {
	
	void display(String mes);
	
}

interface sendmsg{
	
	boolean send(String text,int offset);
	
}

// there are various way of implementing interface

//1) using Class 
class Booker implements book{
	
	public void display(String msg) {
		System.out.println("Hello "+msg);
	}
	
}


public class Main {

	
	public static void main(String[] args) {
		
		Booker b=new Booker();
		b.display("NAVEEN".toLowerCase());
        
		
		//2rd using Anonymous Class 
		book b1=new book() {

			@Override
			public void display(String msg) {
			
				System.out.println("Hello "+msg);
				
			}
			
		};
		
		b1.display("VIRAT !");
		
		//3rd using Lambda functions 
		// msg is parameter to the abract method 
		// is there is no parameter than ()->{};
		book b3=(msg)->System.out.println("Hello "+msg);
		b3.display("Rohit");
		
		//or 
		
		book b4=(msg)->{
			System.out.println("Hello "+msg);
			};
		b4.display("James");
		
		sendmsg obj=(text,time)->{
			System.out.println("Send text : "+text);
			System.out.println("WithIn sec : "+time);
			return true;
		};
		
		System.out.println("Send msg : "+obj.send("I AM IRONMAN", 2));
	}

}
