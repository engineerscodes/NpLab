/**
 * 
 */
package Lab9;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * @author M.NAVEEN
 * RANDOM CODER'S
 *
 */
public class Server {
    
	public static void main(String ...strings) throws IOException {
		
		System.out.println("Server Started !!!!");

		String group="226.44.5.1";
		InetAddress in=InetAddress.getByName(group);
		MulticastSocket ms=new MulticastSocket(5000);
		
	    ms.joinGroup(in);
	    while(true) {
	    byte buf[]=new byte[1024];
	    
	    DatagramPacket dp=new DatagramPacket(buf,1024);
	    
	    ms.receive(dp);
	    System.out.println("Received : "+new String(dp.getData()));
	    }
	   // ms.leaveGroup(in);
	    //ms.close();
	}
	
}
