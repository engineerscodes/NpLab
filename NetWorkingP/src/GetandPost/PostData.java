/**
 * 
 */
package GetandPost;

import java.util.*;



import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.*;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
/**
 * @author M.NAVEEN
 * RANDOM CODER'S
 *
 */
public class PostData {

	
	public static void main(String[] args) throws IOException {
		
		URL page=new URL("http://127.0.0.1:8000/account/login/");
		String res="";
		try {
		  res=GetPage(page);
		  System.out.println("RES :"+res);
		}catch(Exception e) {
			System.out.println("GET FALIED !!");
			System.exit(0);
		}
		
		try {
			String token[]=res.split(";");
			System.out.println(Arrays.toString(token));
			postDate(token[0],token[1],page);
		}catch(Exception e) {
			System.out.println("POST FALIED !!");
			System.exit(0);
		}

	}
	private static void postDate(String cok,String token,URL  link) throws IOException {
		
	        String payload="csrfmiddlewaretoken="+token+"&user-name=naveen&passwordcnf=naveen";
	        System.out.println(payload);
			HttpURLConnection con=(HttpURLConnection)(link.openConnection());
			System.out.println("WEBSITE :"+link.toString());
			con.setRequestMethod("POST");
			con.setRequestProperty("Cookie", "csrftoken="+cok);
			con.setDoOutput(true);
			OutputStream os = con.getOutputStream();
			os.write(payload.getBytes());
			os.flush();
			os.close();
			int responseCode = con.getResponseCode();
			System.out.println("POST Response Code :: " + responseCode);
			if (responseCode == HttpURLConnection.HTTP_OK) { //success
				BufferedReader in = new BufferedReader(new InputStreamReader(
						con.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();

				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();

				// print result
				System.out.println(Jsoup.parse(response.toString()).text());
			} else {
				System.out.println("POST request not worked");
			}
	}

	private static String GetPage(URL link) throws IOException {
          
		HttpURLConnection con=(HttpURLConnection)(link.openConnection());
		System.out.println("WEBSITE :"+link.toString());
		System.out.println("METHOD :"+con.getRequestMethod());
		System.out.println("STATUS CODE :"+con.getResponseCode());
		BufferedReader in=new BufferedReader(new InputStreamReader(con.getInputStream()));
		
		StringBuilder sb=new StringBuilder();
		String line;
		while((line=in.readLine())!=null) {
			sb.append(line);
		}
		
		Document doc=Jsoup.parse(sb.toString());
	    Elements links=doc.select("input");
        
		System.out.println("TOEKN :"+links.get(0).attr("value"));
		List<String> cookies = con.getHeaderFields().get("Set-Cookie");
		System.out.println(cookies.get(0).split(";")[0].split("=")[1]);
		return cookies.get(0).split(";")[0].split("=")[1]+";"+links.get(0).attr("value");
	}
	
	

}
