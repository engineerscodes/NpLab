/**
 * 
 */
package Lab7;

import java.util.*;
import java.io.*;
import java.net.*;
import javax.net.ssl.*;

/**
 * @author M.NAVEEN
 * RANDOM CODER'S
 *
 */
public class ThreadClientSSL {

	
	public static int port=5001;
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		long start=System.nanoTime();
		Scanner nav=new Scanner(System.in);
		System.setProperty("javax.net.ssl.trustStore","C:\\myTrustStore.jts");
		SSLSocketFactory sslSocketfactory = (SSLSocketFactory)SSLSocketFactory.getDefault();
		
		System.out.println(Arrays.toString(sslSocketfactory.getSupportedCipherSuites()));
		
		Socket s=sslSocketfactory.createSocket("localhost",port );	
		
        System.out.println("---".repeat(20)+" CONNECTED "+"---".repeat(20));
        
        DataOutputStream dout=new DataOutputStream(s.getOutputStream());
        
        dout.writeUTF("NAVEEN !!  ");;
        
		 
		

	}

}
