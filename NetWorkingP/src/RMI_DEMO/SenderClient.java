/**
 * 
 */
package RMI_DEMO;
import java.net.MalformedURLException;
import java.util.*;
import java.rmi.*;
/**
 * @author M.NAVEEN
 * RANDOM CODER'S
 *
 */
public class SenderClient {

	
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
	   
		client c=(client)Naming.lookup("rmi://localhost:5014/add");
		System.out.println("Client listening");
		System.out.println("Enter two number :");
		Scanner nav=new Scanner(System.in);
		int n1=nav.nextInt();
		int n2=nav.nextInt();
		System.out.println("Addition of "+n1+ "+ "+n2 +":"+c.add(n1, n2));

	}

}
