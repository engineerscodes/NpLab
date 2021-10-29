/**
 * 
 */
package LAB5;
import org.jsoup.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
/**
 * @author M.NAVEEN
 * RANDOM CODER'S
 *
 */
public class Vowels {
    
	static HashMap<Character,Integer> map=new HashMap<>();
	
	public static void main(String[] args) throws IOException {
	   
		
		  URL url=new URL("https://www.poetrytranslation.org/poems/the-sun-is-one-who-sees-and-knows-everything/");
          BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            
           StringBuilder sb=new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                     sb.append(line);           
            }
            int count=0;
          
            String text=GetTextFromHTML(sb.toString());
            for(int i=0;i<text.length();i++) {
            	  if(text.toLowerCase().charAt(i)=='a'|| text.toLowerCase().charAt(i)=='e'||text.toLowerCase().charAt(i)=='u'||
            			  text.toLowerCase().charAt(i)=='i'||text.toLowerCase().charAt(i)=='o' ) {
            		    count++;
            	  }
            	  if(text.charAt(i)!=' ')
            	  {if(!map.containsKey(text.toLowerCase().charAt(i)))
            		  map.put(text.toLowerCase().charAt(i),1);
            	  else
            		  map.put(text.toLowerCase().charAt(i),map.get(text.toLowerCase().charAt(i))+1); 
            	  }
            	  
            }
            System.out.println("TOTAL VOWELS OCCURRED :"+count);
            getMaxCharater();
         
    }
    
	public static void getMaxCharater() {
		
		int Max=Integer.MIN_VALUE;
		char MaxChar=' ';
		
		for(Map.Entry<Character, Integer> e:map.entrySet()) {
			
			if(Max<e.getValue()) {
				Max=e.getValue();
				MaxChar=e.getKey();
			}
			   
			
		}
		System.out.println("MOST COMMON CHARACTER IS : "+MaxChar+" occurred -> "+Max);
	}
	
	
	private static String GetTextFromHTML(String string) {
	
		return Jsoup.parse(string).text();
	}
		

	

}
