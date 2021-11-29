/**
 * 
 */
package EXAMCAT2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

/**
 * @author M.NAVEEN
 * RANDOM CODER'S
 *
 */
public class FileServer {
  
	public static int PORT=5067;
	
	public static String FilesList() {
		
		File folder=new File("C:\\Users\\HP\\Desktop\\SEM_5\\3) Network Programming\\CAT2");
		File files[]=folder.listFiles();
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<files.length;i++) {
			if (files[i].isFile())
			 sb.append("Name : "+files[i].getName()+"\n");//"Last Modified : "+files[i].lastModified()+
		}
		
		return sb.toString();
		
	}
	
	public static boolean CheckFile(String name) {
		
		File file=new File("C:\\Users\\HP\\Desktop\\SEM_5\\3) Network Programming\\CAT2\\"+name);
		return file.exists();
		
	}
	
	public static byte[] getFile(String name) {
		
		File file=new File("C:\\Users\\HP\\Desktop\\SEM_5\\3) Network Programming\\CAT2\\"+name);
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
	
	
	public static boolean writeFile(byte content[],String name) {
		
		FileOutputStream file;
		try {
			file = new FileOutputStream("C:\\Users\\HP\\Desktop\\SEM_5\\3) Network Programming\\CAT2\\"+name);
			file.write(content);
			  System.out.println("File written");
			  file.close();
			  return true;
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		 
		return false;
		
	}
	
	
	public static void main(String ...strings) throws IOException {
		System.out.println("-------------------------"+" SERVER "+"-----------------------");
		ServerSocket ss=new ServerSocket(PORT);
	
		Socket s=ss.accept();
		System.out.println("CONNECTING "+"...............");
		String Mes="\n1)GET FILE FROM SERVER \n2) POST FILE TO SERVER";
		String exit=" ";
		DataInputStream din=new DataInputStream(s.getInputStream());
		DataOutputStream dout=new DataOutputStream(s.getOutputStream());
		while(!exit.equalsIgnoreCase("YES")) {
			dout.writeUTF(Mes);
			String ch=din.readUTF();
			System.out.println("Client Has Selected : "+ch);
			if(ch.equals("1"))
			{     
				String filesname = FilesList();
				dout.writeUTF(filesname);
				String FileName=din.readUTF();
				//System.out.println("FILE NAME : "+FileName);
				boolean exist=CheckFile(FileName);
			    dout.writeBoolean(exist);
			    //System.out.println("status : "+exist);
				if(exist) {
					
					byte content[]=getFile(FileName);
					dout.writeInt(content.length);
					dout.write(content);	
					System.out.println("!!!! FILE SEND TO CLIENT !!!");
					
				}else {
					System.out.println("FILE NOT FOUNT !!");
				}
			}
			if(ch.equals("2")) {
				
				String name=din.readUTF();
				int len= din.readInt();
				byte content[]=new byte[len];
				System.out.println(len);
				din.read(content);
				writeFile(content,name);
			}
			exit=din.readUTF();
			if(exit.equalsIgnoreCase("YES"))
			   System.out.println("CLIENT EXITING !!");
		}
		
		 // GetFile();
		din.close();
		dout.close();
		s.close();
		ss.close();
		
	}
	
	
}
