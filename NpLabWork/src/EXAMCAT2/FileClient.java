/**
 * 
 */
package EXAMCAT2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * @author M.NAVEEN
 * RANDOM CODER'S
 *
 */
public class FileClient {

	
	public static int PORT=5067;
	public static Scanner nav=new Scanner(System.in);
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		String Add="localhost";
		
		Socket s=new Socket(Add,PORT);
		System.out.println("------------"+" CONNECTED "+"-----------------------");
		
		DataInputStream din=new DataInputStream(s.getInputStream());
		DataOutputStream dout=new DataOutputStream(s.getOutputStream());
		String exit=" ";
		while(!exit.equalsIgnoreCase("YES")) {
			
			
			String Mes=din.readUTF();
			System.out.println("Client Has Selected : "+Mes);
			char ch=nav.next().charAt(0);
			dout.writeUTF(ch+"");
			
			if(ch=='1')
				{ 
				 GetFilesfromServer(din,dout);
				}
			if(ch =='2') {
				 uploadfile(din,dout);
			}
			
			System.out.println("DO YOU WANT TO EXIT ----> ENTER YES :");
			
			exit=nav.next();
			
			dout.writeUTF(exit);
			
			
			
		}
		
		
		din.close();
		dout.close();
		s.close();

	}
   
	
	public static void GetFilesfromServer(DataInputStream din,DataOutputStream dout) throws IOException {
		  System.out.println(din.readUTF());
		  System.out.println("Enter the FileName to GET :");
		  String name=nav.next();
		  dout.writeUTF(name);
		  System.out.println("ASKING file : "+name);
		  boolean status=din.readBoolean();
		  if(status) {
			  int len= din.readInt();
			  byte content[]=new byte[len];
			  System.out.println(len);
			  din.read(content);
			  FileOutputStream file=new FileOutputStream("C:\\Users\\HP\\Pictures\\Feedback\\"+name);
			  file.write(content);
			  System.out.println("!!!! GOT THE FILE FROM SERVER !!!");
			  file.close();
		  }else {
			  System.out.println("FILE NOT FOUNT !!");
		  }
	}
	
	public static void uploadfile(DataInputStream din,DataOutputStream dout) throws IOException {
		 System.out.println("Enter FIle name to Upload :");
		 String name=nav.next();
		 dout.writeUTF(name);
		 byte content[]=getfile(name);
		 dout.writeInt(content.length);
		 dout.write(content);
	}
	
	
	public static byte[] getfile(String name) {
		File file=new File("C:\\Users\\HP\\Downloads\\"+name);
		System.out.print(name);
		byte content[]=new byte[(int)file.length()];
		
		FileInputStream fil;
		try {
			fil = new FileInputStream(file);
			//fil.read(content);
			content=fil.readAllBytes();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
      return content;
	}
	 
	
}
