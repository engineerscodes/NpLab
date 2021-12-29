/**
 * 
 */
package Lab7;

/**
 * @author M.NAVEEN
 * RANDOM CODER'S
 *
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketImpl;
import java.net.UnknownHostException;
import java.nio.channels.SocketChannel;
import java.util.Arrays;
import java.util.Scanner;
import javax.net.ssl.SSLSocketFactory;
import Lab6.FileTranfer;
import sun.security.util.SecurityConstants;

public class ClientSSL {
	     
	public static int port=5000;
	
	public static void main(String ...strings) throws UnknownHostException, IOException {
		long start=System.nanoTime();
		Scanner nav=new Scanner(System.in);
		System.setProperty("javax.net.ssl.trustStore","C:\\myTrustStore.jts");
		SSLSocketFactory sslSocketfactory = (SSLSocketFactory)SSLSocketFactory.getDefault();
		
		System.out.println(Arrays.toString(sslSocketfactory.getSupportedCipherSuites()));
		
		
		
		Socket s=sslSocketfactory.createSocket("localhost",port );	
		
        System.out.println("---".repeat(20)+" CONNECTED "+"---".repeat(20));
		File f=new File("C:\\Users\\HP\\Downloads\\Lab 7a.png");
		byte content[]=new byte[(int)f.length()];
		FileInputStream fil=new FileInputStream(f);
		content=fil.readAllBytes();
		FileTranfer ft=new FileTranfer(f.getName(),(int)f.length(),content);
		//send output to socket
		ObjectOutputStream output=new ObjectOutputStream(s.getOutputStream());
		output.writeObject(ft);
		System.out.println("SEND THE FILE ");
		output.close();
		fil.close();
		s.close();
		System.out.println("RUN TIME :"+(int)(System.nanoTime()-start));
	}
	
	
}

 