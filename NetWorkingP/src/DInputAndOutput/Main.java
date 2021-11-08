/**
 * 
 */
package DInputAndOutput;
import java.util.*;
import java.io.*;
/**
 * @author M.NAVEEN
 * RANDOM CODER'S
 *
 */
public class Main {

	
	public static void main(String[] args) throws IOException {
		
		FileOutputStream f=new FileOutputStream("reads.txt");
		DataOutputStream dout=new DataOutputStream(f);
		
		dout.writeInt(55); //int memory 55 ASCII is written =7
		dout.writeDouble(99.5);
		dout.flush();
		
		DataInputStream din=new DataInputStream(new FileInputStream("reads.txt"));
		
		System.out.println(din.readInt());//55
		System.out.println(din.readDouble());
		
		
		

	}

}
