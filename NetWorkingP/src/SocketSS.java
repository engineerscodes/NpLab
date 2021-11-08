import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Random;

/**
 * 
 */

/**
 * @author M.NAVEEN
 * RANDOM CODER'S
 *
 */
public class SocketSS {
	
	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
		int port=5000;
		System.out.println("---".repeat(20)+" SERVER "+"---".repeat(20));
		ServerSocket ss=new ServerSocket(port);
		Socket s=ss.accept();
		
		ObjectInputStream Objinput=new ObjectInputStream(s.getInputStream());
		
		FileTranfer ft=(FileTranfer)Objinput.readObject();
		String name=ft.name;
		int length=ft.length;
		String extenstion=name.split("\\.")[1];
		Random r=new Random();
		FileOutputStream file=new FileOutputStream(name.split("\\.")[0]+r.nextInt(50)+"."+extenstion);
		file.write(ft.content);
		System.out.println(ft);
		System.out.println(new String(ft.content));
		Objinput.close();
		s.close();
		ss.close();
		
		
	}

}
