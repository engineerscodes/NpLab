/**
 * 
 */
package Lab7;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;
import javax.net.ssl.SSLServerSocketFactory;
import Lab6.FileTranfer;
/**
 * @author M.NAVEEN
 * RANDOM CODER'S
 *
 */
public class ServersSocketSSL {
	
	
	public static int port=5000;
	
	public static void main(String ...strings) throws IOException, ClassNotFoundException {
	 long start=System.nanoTime();
     Scanner nav=new Scanner(System.in);
	 System.setProperty("javax.net.ssl.keyStore","C:\\myKeyStore.jks");
       
     System.setProperty("javax.net.ssl.keyStorePassword","123456789");
     
     SSLServerSocketFactory sslServerSocketfactory = (SSLServerSocketFactory)SSLServerSocketFactory.getDefault();
     
     ServerSocket ss=sslServerSocketfactory.createServerSocket(port);
     
     System.out.println("------------------- SERVER ----------------------------------------");
     
     Socket s=ss.accept();
     
     System.out.println("-------------------  CONNECTED  -------------------------------------");
		
     ObjectInputStream Objinput=new ObjectInputStream(s.getInputStream());
		
		FileTranfer ft=(FileTranfer)Objinput.readObject();
		String name=ft.name;
		int length=ft.length;
		String extenstion=name.split("\\.")[1];
		Random r=new Random();
		 //File filepath = new File("/some/absolute/path/myfile.ext");
		//OutputStream out = new FileOutputStream(file);
		FileOutputStream file=new FileOutputStream(name.split("\\.")[0]+r.nextInt(50)+"."+extenstion);
		file.write(ft.content);
		System.out.println(ft);
		System.out.println("GOT THE FILE :"+ft.name);
		System.out.println(new String(ft.content));
		Objinput.close();
		s.close();
		ss.close();
		
		System.out.println("RUN TIME :"+(int)(System.nanoTime()-start));
		
	}

}



/*

1 - First Generate the server Certificate and public/private key and store it in keystore file

keytool -genkey -keyalg RSA -keysize 2048 -validity 360 -alias mykey -keystore myKeyStore.jks

2 - Export the certficate and the public key that should be send to the client.

keytool -export -alias mykey -keystore myKeyStore.jks -file mykey.cert

3 - Add the key at the client side to a TrustedStore to trust the server

keytool -import -file mykey.cert -alias mykey -keystore myTrustStore.jts



*/