import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;
import javax.net.ssl.SSLServerSocketFactory;
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
	 System.setProperty("javax.net.ssl.keyStore","C:\\Users\\HP\\myKeyStore.jks");
       
     System.setProperty("javax.net.ssl.keyStorePassword","123456");
     
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
