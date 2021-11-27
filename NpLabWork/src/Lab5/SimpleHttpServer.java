/**
 * 
 */
package Lab5;

/**
 * @author M.NAVEEN
 * RANDOM CODER'S
 *
 */
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.Headers;
public class SimpleHttpServer{

  public static void main(String[] args) throws Exception {
    HttpServer server = HttpServer.create(new InetSocketAddress(8004), 0);
    server.createContext("/info", new InfoHandler());
    
    server.createContext("/get", new GetHandler());
    server.setExecutor(null); // creates a default executor
    server.start();
  }

  static class InfoHandler implements HttpHandler {
	  static int count=0;
    public void handle(HttpExchange t) throws IOException {
      String response = "<p>Use /get to download a PDF</p>"+count++;
      t.sendResponseHeaders(200, response.length());
      OutputStream os = t.getResponseBody();
      os.write(response.getBytes());
      os.close();
    }
  }

  static class GetHandler implements HttpHandler {
	  static int count=0;
    public void handle(HttpExchange t) throws IOException {
      System.out.println(count++ +" "+ t.getRequestMethod());
      URI QueryString=t.getRequestURI();
      
      System.out.println(QueryString.toString());
      // add the required response header for a PDF file
      BufferedReader httpInput = new BufferedReader(new InputStreamReader(t.getRequestBody(), "UTF-8"));
	  	StringBuilder in = new StringBuilder();
	  	String input;
	  	while ((input = httpInput.readLine()) != null) {
	  		in.append(input).append(" ");
	  	}
     System.out.println("DATA \n"+in.toString());
      Headers h = t.getResponseHeaders();
      
      h.add("Content-Type", "text/html");

      // a PDF (you provide your own!)
      File file = new File ("C:\\Users\\HP\\Downloads\\privacypolicy.html");
      byte [] bytearray  = new byte [(int)file.length()];
      FileInputStream fis = new FileInputStream(file);
      BufferedInputStream bis = new BufferedInputStream(fis);
      bis.read(bytearray, 0, bytearray.length);

      // ok, we are ready to send the response.
      t.sendResponseHeaders(200, file.length());
      OutputStream os = t.getResponseBody();
      os.write(bytearray,0,bytearray.length);
      os.close();
    }
  }
}

