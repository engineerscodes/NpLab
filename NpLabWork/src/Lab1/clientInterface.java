/**
 * 
 */
package Lab1;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author M.NAVEEN
 * RANDOM CODER'S
 *
 */
public interface clientInterface extends Remote {
     
	public int add(int x,int y)  throws RemoteException;
	public int sub(int x,int y) throws RemoteException;
	
	public double div(double x,double  y) throws RemoteException;
	public int mul(int x,int y) throws RemoteException;
	
	
	
	
}
