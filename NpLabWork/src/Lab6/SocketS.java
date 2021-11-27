/**
 * 
 */
package Lab6;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.*;


import java.util.*;

public class SocketS {

	
	public static void main(String[] args) throws UnknownHostException, IOException {
		
        long start=System.nanoTime();
                       
		String Add="localhost";
		int port=5001;
		
		Socket s=new Socket(Add,port);
		System.out.println("------------"+" CONNECTED "+"-----------------------");
		
		File f=new File("C:\\Users\\HP\\Pictures\\lab.png");
		byte content[]=new byte[(int)f.length()];
		FileInputStream fil=new FileInputStream(f);
		//content=fil.readAllBytes();
                fil.read(content);
		FileTranfer ft=new FileTranfer(f.getName(),(int)f.length(),content);
		
		//send output to socket
		ObjectOutputStream output=new ObjectOutputStream(s.getOutputStream());
		
		output.writeObject(ft);
		
		System.out.println("SEND THE FILE ");
		
		output.close();
		fil.close();
		s.close();
		
                System.out.println("RunTime for Client :"+(int)(System.nanoTime() -start));
		

	}

}



