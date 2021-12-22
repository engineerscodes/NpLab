/**
 * 
 */
package CAT3;
import java.util.*;
import java.io.IOException;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
/**
 * @author M.NAVEEN
 * RANDOM CODER'S
 *
 */
public class EchoServer {
    
	
	 public final static int DEFAULT_PORT = 7070;
	  public final static int MAX_PACKET_SIZE = 65507;

	  public static void main(String[] args) {

	    int port = DEFAULT_PORT;
	    try {
	      port = Integer.parseInt(args[0]);
	    }
	    catch (Exception ex) {
	    }
	    
	    try {
	      DatagramChannel channel = DatagramChannel.open();
	      DatagramSocket socket = channel.socket();
	      SocketAddress address = new InetSocketAddress(port);
	      socket.bind(address);
	      ByteBuffer buffer = ByteBuffer.allocateDirect(MAX_PACKET_SIZE);
	      while (true) {
	        SocketAddress client = channel.receive(buffer);
	        buffer.flip();
	        channel.send(buffer, client);
	        buffer.clear();
	      } // end while
	    }  // end try
	    catch (IOException ex) {
	      System.err.println(ex);
	    }  // end catch

	  }  // end main

}
