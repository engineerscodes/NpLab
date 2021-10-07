/**
 * 
 */
import java.util.*;
import java.io.IOException;
import java.net.*;
/**
 * @author M.NAVEEN
 * RANDOM CODER'S
 *
 */
public class MainURL {
  
	
	public static void main(String ...strings) throws IOException {
		
		URL url=new URL("https://www.naveennaveen.me/index.html");
		System.out.println(url.getProtocol() +" file :"+url.getFile());
		
	}
	
}
