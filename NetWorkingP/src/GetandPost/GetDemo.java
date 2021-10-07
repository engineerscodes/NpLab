/**
 * 
 */
package GetandPost;

import java.util.*;
import java.net.*;
import java.io.*;

/**
 * @author M.NAVEEN
 * RANDOM CODER'S
 *
 */
public class GetDemo {

	
	
	
	public static void main(String ...strings) throws IOException {
		
		
		String str="https://naveennaveen.me/";
		
		URL url=new URL(str);
		
		HttpURLConnection con= (HttpURLConnection) url.openConnection(); //returns urlconnection
		//by default is get
		con.setRequestMethod("GET");
		
		//add user header
		//con.setRequestProperty("User-Agent","Mozilla/5.0");
		System.out.println("WEBPAGE LINK : "+url.toString());
		System.out.println("STATUS CODE : "+con.getResponseCode());
		
		BufferedReader buff=new BufferedReader(new InputStreamReader(con.getInputStream()));
		
		
		int input=buff.read();
		StringBuilder sb=new StringBuilder();
		while(input!=-1) {
			System.out.print((char)input);
			sb.append((char)input);
			input=buff.read();
		}
        
		buff.close();
		
		System.out.println("=================================================================================================");
		
		System.out.println(sb.toString());
		
		
		
	}

}
