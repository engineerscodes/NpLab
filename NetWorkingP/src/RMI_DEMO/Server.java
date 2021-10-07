/**
 * 
 */
package RMI_DEMO;
import java.util.*;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author M.NAVEEN
 * RANDOM CODER'S
 *
 */
public class Server extends UnicastRemoteObject implements client  {

	
	 Server() throws RemoteException{
		 super();
	 }

	@Override
	public String print(String text) throws RemoteException {
		
		return "Frome Sever : "+text;
	}
	
	public static void main(String[] args) throws RemoteException, AlreadyBoundException {
    
	   Registry reg=LocateRegistry.createRegistry(5099);
		
       reg.bind("hello",new  Server());

	}

}
