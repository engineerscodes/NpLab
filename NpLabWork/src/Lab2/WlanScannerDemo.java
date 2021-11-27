/**
 * 
 */
package Lab2;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author M.NAVEEN
 * RANDOM CODER'S
 *
 */
public class WlanScannerDemo {
    
public static void main(String[] args) throws IOException {
		
		
		InetAddress addr = InetAddress.getLocalHost();
		System.out.println("Local HostAddress :  "+addr.getHostAddress());
		
		/*String str=addr.toString();
		String ip=str.split("/")[1];
		System.out.println(ip.substring(0,str.split("/")[1].lastIndexOf(".")));
		ip=ip.substring(0,str.split("/")[1].lastIndexOf("."));
		*/
		String ip=addr.getHostAddress();
		ip=ip.substring(0,ip.lastIndexOf("."));
		//System.out.println("CURRENT SUB : "+ip);
		for(int i=0;i<255;i++) {
			String checkip = ip+"."+ String.valueOf(i);
			try {
			check(checkip);
			}
			catch(UnknownHostException e)
			{
				System.out.println("Not Reachable "+checkip);
			}
			
			
		}
		

	}
	
	public static void check(String checkip) throws IOException  {
			InetAddress temp = InetAddress.getByName(checkip);
			boolean reachable=false;
					reachable = temp.isReachable(100);
					if(reachable)
						  System.out.println("IP :"+temp.getHostAddress()+" is Connected to Wlan");
				
	}


}
