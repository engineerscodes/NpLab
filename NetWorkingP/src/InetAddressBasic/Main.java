/**
 * 
 */
package InetAddressBasic;
import java.util.*;
import java.net.*;
/**
 * @author M.NAVEEN
 * RANDOM CODER'S
 *
 */
public class Main {

	
	public static void main(String[] args) {
	    
		InetAddress ip;
		try {
			ip = InetAddress.getByName("www.naveen.social"); //185.199.110.153
			byte b[]=ip.getAddress();
			System.out.println(ip+"   ");
			//reverse loopkup
			ip=InetAddress.getByName("208.201.239.100");
			System.out.print(ip.getHostName());
			System.out.println("ALL IP ADD");
			InetAddress all[]=InetAddress.getAllByName("www.google.com");
			System.out.print(Arrays.toString(all)+"\n");
			
			System.out.println(InetAddress.getLocalHost());
			
			byte ips[]= {107,23,(byte)216,(byte)196};
			
			ip=InetAddress.getByAddress(ips);
			System.out.println(ip.getHostName());
			//Inet6Address.getByAddress
			
		} catch (UnknownHostException e) {
			
			e.printStackTrace();
		}
		
		
	}

}
