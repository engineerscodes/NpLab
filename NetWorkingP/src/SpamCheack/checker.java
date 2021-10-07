/**
 * 
 */
package SpamCheack;
import java.util.*;
import java.net.*;
/**
 * @author M.NAVEEN
 * RANDOM CODER'S
 *
 */
public class checker {
   
	static final String BLACKHOLE="www.spamhaus.org";
	
	public static void main(String ...strings) {
		
		for(String i:strings) {
			if(isSpammer(i))
			{
				System.out.println(i+" is spammer ");
			}else {
				System.out.println(i+" is Not spammer ");
			}
		}
		
		
		
	}

	private static boolean isSpammer(String i) {
		try {
			InetAddress add=InetAddress.getByName(i);
			byte ip[]=add.getAddress();
			String query=BLACKHOLE;
			System.out.println(Arrays.toString(ip));
			for(int j=0;j<ip.length;j++) {
				int usignedint=ip[j]<0?(int)ip[j]+(int)256:ip[j];
				query= usignedint+"."+query;
			}
			System.out.println(query);
			add=InetAddress.getByName(query);
			return true;
		}
		catch(UnknownHostException e) {
			return false;
		}
	}
	
}
