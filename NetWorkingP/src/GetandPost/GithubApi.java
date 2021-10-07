/**
 * 
 */
package GetandPost;

import java.io.*;
import java.net.*;

/**
 * @author M.NAVEEN
 * RANDOM CODER'S
 *
 */
public class GithubApi {

	
	public static void main(String[] args) throws Exception {
		
	//	String str="https://api.github.com/repos/django/django/stats/contributors";
		
		String str="https://api.github.com/repos/adafruit/Fritzing-Library/stats/contributors";
		
		

		
		URL url=new URL(str);
        
		HttpURLConnection con=(HttpURLConnection)url.openConnection();
		
		System.out.println("STATUS CODE : "+con.getResponseCode());
		
		BufferedReader in=new BufferedReader(new InputStreamReader(con.getInputStream()));
	
		String input=in.readLine();
		StringBuffer sb = new StringBuffer();
		while(input !=null) {
			//System.out.println(input);
			sb.append(input);
			input=in.readLine();
			
			
		}
		
		System.out.println("=====================================================================================================");
		
		System.out.println(sb.toString());
		
		//Read JSON response and print
        


	}

}
