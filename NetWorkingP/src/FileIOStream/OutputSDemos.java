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
public class OutputSDemos {

	
	public static void main(String[] args) {
	    String data="I AM NAVEEN ...............VIT IS HELL ...............";
	    try {
	    	OutputStream output=new FileOutputStream("output.txt");
	    	byte text[]=data.getBytes();
	    	output.write(text);
	    	System.out.println("Written Data ");
	    	output.close();
	    }	
	    catch(IOException e) {
	    	System.out.println(e);
	    }

	}

}
