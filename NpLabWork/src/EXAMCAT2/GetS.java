/**
 * 
 */
package EXAMCAT2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

/**
 * @author M.NAVEEN
 * RANDOM CODER'S
 *
 */
public class GetS {

	
	public static void main(String[] args) throws IOException {
		
		String link="https://github.com/engineerscodes";
		System.out.println("WebPage : "+link);
		
		URL url=new URL(link);//throws MalformedURLException
		HttpURLConnection con= (HttpURLConnection) url.openConnection(); //IOEXCEPTION
		con.setRequestMethod("GET");
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
