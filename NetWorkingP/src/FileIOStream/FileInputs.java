/**
 * 
 */
package FileIOStream;
import java.io.*;
/**
 * @author M.NAVEEN
 * RANDOM CODER'S
 *
 */
public class FileInputs {


	public static void main(String[] args) {
		
		try {
		FileInputStream input=new FileInputStream("output.txt");
		
		//System.out.println((char)input.read());
		//System.out.println((char)input.read());
		//System.out.println((char)input.read());
		//input.mark(0);
		//input.reset();
		System.out.println(" TEXT  IN FILE ");
		while(input.available()>0) {
			System.out.print((char)input.read());
			
		}
       //or
		//input.reset();
		int b=input.read();
		while(b!=-1) {
			System.out.print((char)b);
			b=input.read();
		}
      
		
		}
		catch(IOException e) {
			
			
			
		}

	}

}
