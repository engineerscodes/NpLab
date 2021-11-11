/**
 * 
 */
package SslSocket;

/**
 * @author M.NAVEEN
 * RANDOM CODER'S
 *
 */
import java.util.*;


import javax.net.ssl.SSLSocketFactory;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
public class SSLClient {

	public static int port=5000;
	public static void main(String[] args) throws UnknownHostException, IOException {
		Scanner nav=new Scanner(System.in);
		System.setProperty("javax.net.ssl.trustStore","C:\\Users\\HP\\myTrustStore.jts");
		SSLSocketFactory sslSocketfactory = (SSLSocketFactory)SSLSocketFactory.getDefault();
		Socket s=sslSocketfactory.createSocket("localhost",port );
		
		DataInputStream din=new DataInputStream(s.getInputStream());
		DataOutputStream dout=new DataOutputStream(s.getOutputStream());
		//BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		String input="";
		
		while(!input.equalsIgnoreCase("STOP")) {
			input=nav.nextLine();
			dout.writeUTF(input);
			dout.flush();
			System.out.println(" SERVER SAYS :"+din.readUTF());
			
		}
		dout.close();
		din.close();
		s.close();
		  

	}

}

/*
 * 
1 - First Generate the server Certificate and public/private key and store it in keystore file
keytool -genkey -keyalg RSA -keysize 2048 -validity 360 -alias mykey -keystore myKeyStore.jks
2 - Export the certficate and the public key that should be send to the client.
keytool -export -alias mykey -keystore myKeyStore.jks -file mykey.cert
3 - Add the key at the client side to a TrustedStore to trust the server
keytool -import -file mykey.cert -alias mykey -keystore myTrustStore.jts
 * */
