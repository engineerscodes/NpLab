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

/**
 * @author M.NAVEEN
 * RANDOM CODER'S
 *
 */
public class UdpClient {

	public static void main(String[] args) throws IOException {
	 
		DatagramSocket ds=new DatagramSocket();
		
		String msg="Hi bro";
		InetAddress in=InetAddress.getLocalHost();
		DatagramPacket dp=new DatagramPacket(msg.getBytes(),msg.getBytes().length,in,5000);
		ds.send(dp);
		System.out.println("Send text :"+msg);
		byte rev[]=new byte[1024];
		DatagramPacket dp2=new DatagramPacket(rev,rev.length);
        ds.receive(dp2);
        
        System.out.println("Received text :"+new String(rev));
	}

}
