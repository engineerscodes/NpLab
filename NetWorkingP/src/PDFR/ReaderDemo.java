/**
 * 
 */
package PDFR;

import java.util.*;
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
/**
 * @author M.NAVEEN
 * RANDOM CODER'S
 *
 */
public class ReaderDemo {
   
	public static void main(String ...strings) throws IOException {
			
		InputStream in =new FileInputStream("C:\\Users\\HP\\Downloads\\heelo.pdf");
		//FileOutputStream it=new FileOutputStream("C:\\Users\\HP\\Downloads\\heelo.pdf");
		//OutputStreamWriter out=new OutputStreamWriter(it);
		//System.out.println(out.getEncoding());
		Reader r=new InputStreamReader(in,StandardCharsets.UTF_8);
		
		BufferedReader bf=new BufferedReader(r,1024);
		
		StringBuilder sb=new StringBuilder();
		int c;
		
		while((c=bf.read())!=-1)
			sb.append((char)c);
		
		System.out.println(sb.toString());
		
		
	}
	
}
