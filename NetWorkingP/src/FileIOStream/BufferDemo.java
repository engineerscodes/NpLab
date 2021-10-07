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
public class BufferDemo {

	
	public static void main(String[] args) {
	
     
		try {
			FileInputStream file=new FileInputStream("input.txt");
			BufferedInputStream input=new BufferedInputStream (file);
			input.mark(0);
			while(input.available()>0) {
				System.out.print((char)input.read());
			}
			input.reset();
			System.out.println("\n===============================================After reseting==============================\n ");
			while(input.available()>0) {
				System.out.print((char)input.read());
			}
			
		}
		catch(Exception e) {
			
		}
		
	}

}
