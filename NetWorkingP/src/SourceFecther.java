/**
 * 
 */
 import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
/**
 * @author SRI RAM B
 * RANDOM CODER'S
 *
 */
public class SourceFecther {


	public static void main(String[] args) throws IOException {
		
		 URL url=new URL("https://unsplash.com/s/photos/car");
         BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
         StringBuilder sb=new StringBuilder();
         String line;
         while ((line = in.readLine()) != null) {
                  sb.append(line);           
         }
         
         System.out.println("SOURCE CODE :\n"+sb.toString());
         
	}

}
