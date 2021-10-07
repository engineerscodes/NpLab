/**
 * 
 */
package RMI_DEMO.ADDS;
import java.util.*;
import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.UnicastRemoteObject;
/**
 * @author M.NAVEEN
 * RANDOM CODER'S
 *
 */
public class Server  extends UnicastRemoteObject implements clientInterface {
  

	//private static final long serialVersionUID = 1L;

	protected Server() throws RemoteException {
		super();
	}

	@Override
	public String Fibonacci(int max) {
		
		StringBuilder str=new StringBuilder();
	   int n1=0,n2=1;
	   str.append(n1+" \n");
	   str.append(n2+" \n");
	   int n3=0;
	   for(int i=2;i<max;i++) {
		  n3=n1+n2;
		  str.append(n3+" \n");
		  n1=n2;
		  n2=n3;
	   }
		return str.toString();
	}

	public static void main(String[] args) throws RemoteException, AlreadyBoundException {
	     System.out.println("RMI SERVER STARTED !!!!!!!!!!!");
		  Registry reg=LocateRegistry.createRegistry(5099);
			
	       reg.bind("adder",new  Server());
		
	}


}
