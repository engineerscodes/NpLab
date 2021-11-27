
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class PostData {

    public static void main(String ...strings) throws IOException {
		
		
        try {
            URL url = new URL("https://httpbin.org/post ");
            String postData = "NAME=RAM";
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
             System.out.println("WEBPAGE LINK : "+url.toString());
	     
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setRequestProperty("Content-Length", Integer.toString(postData.length()));
            conn.setUseCaches(false);
            
            try (DataOutputStream dos = new DataOutputStream(conn.getOutputStream())) {
                dos.writeBytes(postData);
            }
              System.out.println("CONTENT TYPE :"+conn.getContentType());
              System.out.println("STATUS CODE : "+conn.getResponseCode());
            try (BufferedReader br = new BufferedReader(new InputStreamReader(
                                                conn.getInputStream())))
            {
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    
         
		
   }
}
