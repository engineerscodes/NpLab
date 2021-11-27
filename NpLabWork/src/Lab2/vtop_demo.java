/**
 * 
 */
package Lab2;

/**
 * @author M.NAVEEN
 * RANDOM CODER'S
 *
 */
import java.io.IOException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
public class vtop_demo {

	

	public static void main(String[] args) throws IOException {
	 
		URL vtop=new URL("https://vtop2.vitap.ac.in/vtop/initialProcess");
		
		System.out.println("URL : "+vtop.toString());
		
		System.out.println("Authority : "+vtop.getAuthority());
		
		System.out.println("PORT : "+vtop.getPort());//443
		
		  URLConnection conn = vtop.openConnection();
		
		  
		 
		  System.out.println("Content Type "+conn.getContentType());
		  System.out.println("HOST  "+vtop.getHost());
		  
		 
		   
		  InetAddress vtopip=InetAddress.getByName("vtop2.vitap.ac.in");
		  
		  System.out.println("Canonical Name :"+vtopip.getCanonicalHostName());
		  System.out.println("Date Last Modified :"+conn.getLastModified());
		 
	}

}


