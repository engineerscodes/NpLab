/**
 * 
 */
package Soc;
import java.util.*;
import java.io.*;
import java.net.*;
/**
 * @author M.NAVEEN
 * RANDOM CODER'S
 *
 */
public class socketServer {

	
	public static void main(String args[] ) throws IOException {
		System.out.println("------------ server ----------------------------------");
		int port=8801;
		Scanner nav=new Scanner(System.in);
		ServerSocket ss=new ServerSocket(8802);
		Socket s=ss.accept();
		DataInputStream din=new DataInputStream(s.getInputStream());
		DataOutputStream dout=new DataOutputStream(s.getOutputStream());
		//BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		String input="";
		
		while(!input.equalsIgnoreCase("STOP")) {
			System.out.println(" CLIENT SAYS :"+din.readUTF());
			input=nav.nextLine();
			dout.writeUTF(input);
			dout.flush();
		}
		
		dout.close();
		din.close();
		s.close();
		ss.close();
		
		
	}
	
}
