/**
 * 
 */
package Lab1;

import java.nio.channels.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author M.NAVEEN
 * RANDOM CODER'S
 *
 */
public class Server  extends UnicastRemoteObject implements clientInterface {
	  

	

	protected Server() throws RemoteException {
		super();
	}

	@Override
	public int add(int n1,int n2) {
		
		return n1+n2;
	}

	public static void main(String[] args) throws RemoteException, AlreadyBoundException, java.rmi.AlreadyBoundException {
	     System.out.println("RMI SERVER STARTED !!!!!!!!!!!");
		  Registry reg=LocateRegistry.createRegistry(5080);
			
	       reg.bind("adder",new  Server());
		
	}

	@Override
	public int sub(int x, int y) throws RemoteException {
		
		return x-y;
	}

	@Override
	public double div(double  x, double  y) throws RemoteException {
		return (double)(x/y);
	}

	@Override
	public int mul(int x, int y) throws RemoteException {
		
		return x*y;
	}

	


}