/**
 * 
 */
package Lab7;
/**
 * @author M.NAVEEN
 * RANDOM CODER'S
 *
 */

import java.util.*;
import javax.net.ssl.SSLServerSocketFactory;
import java.net.*  ;
import java.io.*;

public class ThreadSSLServer {

	public static int port=5001;
	
	public static void main(String ...strings) throws IOException {
		
       	new ThreadSSLServer().createnewserver();
		
	}
	
	public void createnewserver() throws IOException {
		    System.out.println(" Servering is Running ");
			
			System.setProperty("javax.net.ssl.keyStore","C:\\myKeyStore.jks");
		       
		    System.setProperty("javax.net.ssl.keyStorePassword","123456789");
		    
		    SSLServerSocketFactory sslerver=(SSLServerSocketFactory)SSLServerSocketFactory.getDefault();
		    
		    //create server socket
		    
		    ServerSocket ss=sslerver.createServerSocket(port);
		    
		    System.out.println("------------------- SERVER ----------------------------------------");
		    Socket s=null;
		    while(true)
		    { 
		    s=ss.accept();
		    
		    new ThreadServer(s).start();
		    }
		    
	}
	
}


class ThreadServer extends Thread
{
	
	
	public Socket socket;
	
	ThreadServer(Socket s){
		socket =s;
	}
	
	public void run() {
		
		System.out.println("CURRENT THREAD : "+Thread.currentThread().getId());
		
		String msg=null;
		
		try {
			//BufferedReader buff=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			DataInputStream din=new DataInputStream(socket.getInputStream());
			msg=din.readUTF();
			System.out.println(msg);
	
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		try {
			socket.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	
	
}


