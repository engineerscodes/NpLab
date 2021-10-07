/**
 * 
 */
package FileIOStream;
import java.util.*;
import java.io.*;
/**
 * @author M.NAVEEN
 * RANDOM CODER'S
 *
 */
public class InputSDemos {

	
	public static void main(String ...strings) {
	 	
	 try {	
		InputStream input=new FileInputStream("input.txt");
	
		System.out.println("Available Bytes :"+input.available());
		//byte array[]=new byte[100]; then first 100 bytes will be printed
		byte array[]=new byte[input.available()];
		input.read(array);
		//System.out.println(" DATA  "+Arrays.toString(array));
		String str=new String(array);
		System.out.println("-------------------------------------- FILE TEXT ------------------------------------------");
		System.out.println(str);
	  }
	 catch(IOException e) {
		 
	 }
		
		
	}
    
}
