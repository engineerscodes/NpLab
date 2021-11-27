/**
 * 
 */
package Lab2;

/**
 * @author M.NAVEEN
 * RANDOM CODER'S
 *
 */

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;

public class HostIp {
    
	
	public static void main(String ...args) throws MalformedURLException {
		
    try {
  		InetAddress addr = InetAddress.getLocalHost();
		System.out.println("Local HostAddress :  "+addr.getHostAddress());
		String hostname = addr.getHostName();
		System.out.println("Local host name: "+hostname);
		
	} catch (UnknownHostException e) {
		e.printStackTrace();
	}
			    
	
	}
	
	
}