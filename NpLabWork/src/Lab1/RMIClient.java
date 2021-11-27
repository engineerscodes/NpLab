/**
 * 
 */
package Lab1;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * @author M.NAVEEN
 * RANDOM CODER'S
 *
 */
public class RMIClient {
   
	public static void main(String ...strings) throws MalformedURLException, RemoteException, NotBoundException {
		String port="5080";
		String name="adder";
		String add="rmi://localhost:";
		String url=add+port+"/"+name;
		System.out.println(url);
		clientInterface client=(clientInterface)Naming.lookup(url);
		System.out.println("Sum of Numbers : "+client.add(100, 500));
		System.out.println("MUL of Numbers : "+client.mul(155, 500));
		System.out.println("DIV of Numbers : "+client.div(155, 500));
		System.out.println("SUB of Numbers : "+client.sub(155, 100));
		
	
		
	}
	  
}
