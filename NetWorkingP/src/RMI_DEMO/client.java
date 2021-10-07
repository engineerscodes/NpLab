/**
 * 
 */
package RMI_DEMO;
import java.rmi.*;
/**
 * @author M.NAVEEN
 * RANDOM CODER'S
 *
 */
public interface client extends Remote{  
  
	public String print(String text) throws RemoteException;
	
}  