/**
 * 
 */
package RMI_DEMO.ADDS;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * @author M.NAVEEN
 * RANDOM CODER'S
 *
 */
public class RMIClient  {
   
	public static void main(String ...strings) throws MalformedURLException, RemoteException, NotBoundException {
		String port="5099";
		String name="adder";
		String add="rmi://localhost:";
		String url=add+port+"/"+name;
		System.out.println(url);
		clientInterface client=(clientInterface)Naming.lookup(url);
		//System.out.println("Sum of Numbers : "+client.add(100, 500));
		//System.out.println("Sum of Numbers : "+client.add(155, 500));
		//Fibonacci
	   System.out.println("Sum of Numbers : "+client.Fibonacci(10));
	   System.out.println("Sum of Numbers : "+client.Fibonacci(3));
		
	}	
}
