/**
 * 
 */
package Lab8;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @author M.NAVEEN
 * RANDOM CODER'S
 *
 */
public class UdpServer {

	
	public static void main(String[] args) throws IOException {
		
		DatagramSocket ds=new DatagramSocket(5000);
		
		byte rev[]=new byte[1024];
		DatagramPacket dp2=new DatagramPacket(rev,rev.length);
        ds.receive(dp2);
        String str=new String(rev);
        System.out.println("Received text :"+str.trim());
        String msg="I am Thanos !!!";
		InetAddress in=InetAddress.getLocalHost();
		DatagramPacket dp=new DatagramPacket(msg.getBytes(),msg.getBytes().length,in,dp2.getPort());
		ds.send(dp);
		System.out.println("Send text :"+msg);
           
	}

}
