/**
 * 
 */
package Lab4;

/**
 * @author M.NAVEEN
 * RANDOM CODER'S
 *
 */
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
public class PostData {

    public static void main(String ...strings) throws IOException {
		     
    	
    	
            URL url = new URL("https://httpbin.org/post ");
            
            HttpURLConnection temp = (HttpURLConnection)(url.openConnection());
            temp.setRequestMethod("OPTIONS");
            System.out.println("WEBSITE :" + url.toString());
            System.out.println("METHOD :" + temp.getRequestMethod());
            System.out.println("STATUS CODE :" + temp.getResponseCode());

            System.out.println("ALLOWED METHODS :" + temp.getHeaderField("Allow"));
            String methods=temp.getHeaderField("Allow");
            if(!methods.contains("POST"))
            {
            	System.out.println("POST METHOD NOT ALLOWED");
            	System.exit(0);
            }
            String postData = "NAME=M.NAVEEN&REG=19bcn7185";
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
       
             System.out.println("WEBPAGE LINK : "+url.toString());
	     
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setRequestProperty("Content-Length", Integer.toString(postData.length()));
           
            
            DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
                dos.writeBytes(postData);
            
              System.out.println("CONTENT TYPE :"+conn.getContentType());
              System.out.println("STATUS CODE : "+conn.getResponseCode());
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            
        
         
		
   }
}
