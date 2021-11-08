/**
 * 
 */
import java.util.*;
import java.io.*;
/**
 * @author M.NAVEEN
 * RANDOM CODER'S
 *
 */

public class FileTranfer implements Serializable {

	String name;
	int length;
	byte content[];
	
	
	public FileTranfer(String name, int length, byte[] content) {
		super();
		this.name = name;
		this.length = length;
		this.content = content;
	}


	public String toString() {
		return name;
	}


	public static void main(String ...strings) {
	
		File f=new File("C:\\Users\\HP\\git\\NpLab\\NetWorkingP\\input.txt");
		
		
		byte content[]=new byte[(int)f.length()];
	    
		try {
			FileInputStream fil=new FileInputStream(f);
		   content=fil.readAllBytes();
		  // System.out.println(Arrays.toString(content));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		System.out.println(f.getName());
		System.out.println(f.length());
		
	
	}
	
}
