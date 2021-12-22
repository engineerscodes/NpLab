/**
 * 
 */
package EXAMCAT2;
import java.util.*;
import java.io.IOException;
import java.net.*;
/**
 * @author M.NAVEEN
 * RANDOM CODER'S
 *
 */
public class ResFields {

	
	
	public static void main(String args[]) throws Exception {
		
		String link="https://vtop2.vitap.ac.in/vtop/initialProcess";
		URL url=new URL(link);
		
		HttpURLConnection con=(HttpURLConnection)url.openConnection();
		
		Map<String,List<String>> header=con.getHeaderFields();
		
		
		for(Map.Entry<String, List<String>> e:header.entrySet()) {
			
			System.out.println(e.getKey()+" : "+e.getValue());
		}
		
		
	}
	
	
}
