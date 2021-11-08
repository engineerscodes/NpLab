/**
 * 
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.*;
/**
 * @author M.NAVEEN
 * RANDOM CODER'S
 *
 */

import java.util.*;

public class SocketS {

	
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		String Add="localhost";
		int port=5000;
		
		Socket s=new Socket(Add,port);
		System.out.println("---".repeat(20)+" CONNECTED "+"---".repeat(20));
		
		File f=new File("C:\\Users\\HP\\Downloads\\file.pdf");
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
		
		

	}

}
