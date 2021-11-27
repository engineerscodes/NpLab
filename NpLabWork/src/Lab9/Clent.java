/**
 * 
 */
package Lab9;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * @author M.NAVEEN
 * RANDOM CODER'S
 *
 */
public class Clent {

	
	public static void main(String[] args) throws IOException {
		System.out.println("Client Started !!!!");
		
		String group="226.44.5.1";
		
		MulticastSocket ms=new MulticastSocket();
		String msg="Hi bro I am Naveen !!!!!!!!";
		InetAddress in=InetAddress.getByName(group);
		DatagramPacket dp=new DatagramPacket(msg.getBytes(),msg.getBytes().length,in,5000);
		ms.send(dp);
		System.out.println("Send text :"+msg);

	}

}
