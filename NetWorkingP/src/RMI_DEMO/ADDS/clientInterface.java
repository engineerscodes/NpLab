/**
 * 
 */
package RMI_DEMO.ADDS;
import java.rmi.*;
/**
 * @author M.NAVEEN
 * RANDOM CODER'S
 *
 */
public interface clientInterface extends Remote{
   
	//public int add(int x,int y)  throws RemoteException;
	public String Fibonacci(int max)  throws RemoteException;
}
