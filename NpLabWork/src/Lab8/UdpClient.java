/**
 * 
 */
package Lab8;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.*;
/**
 * @author M.NAVEEN
 * RANDOM CODER'S
 *
 */
public class UdpClient {

	public static void main(String[] args) throws IOException {
	 
		DatagramSocket ds=new DatagramSocket();
		
		Scanner nav=new Scanner(System.in);
		InetAddress in=InetAddress.getLocalHost();
		
		while(true) {
		System.out.println("Enter Message :");
		String msg=nav.nextLine();
		DatagramPacket dp=new DatagramPacket(msg.getBytes(),msg.getBytes().length,in,5000);
		ds.send(dp);
		System.out.println("Send text :"+msg);
		byte rev[]=new byte[1024];
		DatagramPacket dp2=new DatagramPacket(rev,rev.length);
        ds.receive(dp2);
        
        System.out.println("Received text :"+new String(rev).trim());
		}
	}

}
