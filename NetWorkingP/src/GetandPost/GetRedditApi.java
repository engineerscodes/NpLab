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
public class GetRedditApi {


	public static void main(String[] args) throws IOException {
	
		
		String str="https://dashboard.nbshare.io/api/v1/apps/reddit";
		URL url=new URL(str);
		
		HttpURLConnection con=(HttpURLConnection)url.openConnection();
		
		System.out.println("STATUS CODE : "+con.getResponseCode());
		
		BufferedReader in=new BufferedReader(new InputStreamReader(con.getInputStream()));
		
		int input=in.read();
		StringBuilder sb=new StringBuilder();
		while(input!=-1) {
			sb.append((char)input);
			input=in.read();
			
		}
		
		System.out.println("==============================================================================================");
		System.out.println(sb.toString());
		
		

	}

}
