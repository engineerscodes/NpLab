/**
 * 
 */
package SslSocket;
import java.util.*;

import javax.net.ssl.SSLServerSocketFactory;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
/**
 * @author M.NAVEEN
 * RANDOM CODER'S
 *
 */
public class SSLSocket {
    
	
	public static int port=5000;
	
	
	public static void main(String[] args) throws IOException {
	     Scanner nav=new Scanner(System.in);
		 System.setProperty("javax.net.ssl.keyStore","C:\\Users\\HP\\myKeyStore.jks");
	       
	     System.setProperty("javax.net.ssl.keyStorePassword","123456");
	     
	     SSLServerSocketFactory sslServerSocketfactory = (SSLServerSocketFactory)SSLServerSocketFactory.getDefault();
	     
	     ServerSocket ss=sslServerSocketfactory.createServerSocket(port);
	     
	     System.out.println("------------------- SERVER ----------------------------------------");
	     
	     Socket s=ss.accept();
	     
	     System.out.println("-------------------  CONNECTED  -------------------------------------");
	     DataInputStream din=new DataInputStream(s.getInputStream());
			DataOutputStream dout=new DataOutputStream(s.getOutputStream());
			//BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
			String input="";
			
			while(!input.equalsIgnoreCase("STOP")) {
				System.out.println(" CLIENT SAYS :"+din.readUTF());
				input=nav.nextLine();
				dout.writeUTF(input);
				dout.flush();
			}
			
			dout.close();
			din.close();
			s.close();
			ss.close();

	}

}
