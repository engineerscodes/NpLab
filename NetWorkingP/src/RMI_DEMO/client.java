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
  
	public int add(int n1,int n2) throws RemoteException;
	
}  