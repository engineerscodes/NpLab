package Lab4;

/**
 * @author M.NAVEEN
 * RANDOM CODER'S
 *
 */

import java.util.*;
import java.net.*;
import java.io.*;
import org.jsoup.*;

public class GetDemo {

    
    
	public static void main(String ...strings) throws IOException {
		
		
		String str="https://github.com/engineerscodes/PROTO-SEEK"; //my github account
		
		URL url=new URL(str);
		
		HttpURLConnection con= (HttpURLConnection) url.openConnection(); 
		con.setRequestMethod("GET");
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
		
                System.out.println("------------------------- TEXT --------------------------------------------------------------------");
           
                System.out.println(Htmlparser(sb.toString()));
                
		
		
	}
        
        
        
        public static String Htmlparser(String html){
            
            return Jsoup.parse(html).text();
            
        } 

}