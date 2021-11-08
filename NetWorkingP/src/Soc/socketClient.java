/**
 * 
 */
package Soc;
import java.util.*;
import java.net.*;
import java.io.*;
/**
 * @author M.NAVEEN
 * RANDOM CODER'S
 *
 */
public class socketClient {

	
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("------------ Client ----------------------------------");
		Scanner nav=new Scanner(System.in);
		Socket s=new Socket("localhost",8802);
		
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
