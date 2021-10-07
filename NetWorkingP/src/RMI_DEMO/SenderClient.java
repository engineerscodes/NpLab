/**
 * 
 */
package RMI_DEMO;
import java.net.MalformedURLException;
import java.rmi.*;
/**
 * @author M.NAVEEN
 * RANDOM CODER'S
 *
 */
public class SenderClient {

	
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
	   
		client c=(client)Naming.lookup("rmi://localhost:5099/hello");
		System.out.println(c.print("MY NAME IS BILLA !!!!!!!!!!"));

	}

}
