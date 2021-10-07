/**
 * 
 */
import java.util.*;
import java.util.stream.Stream;
import java.io.*;
/**
 * @author M.NAVEEN
 * RANDOM CODER'S
 *
 */

public class Basic {

	
	public static void main(String[] args) {
		
		ArrayList <Integer> n=new ArrayList();
		n.add(5);
		n.add(1);
		n.add(88);
		n.add(6);
		
		Comparator <Integer> c=new Comparator<Integer>() {

			/*@Override
			public int compare(Object o1, Object o2) {
	       return -1*(Integer.parseInt(o1.toString())-Integer.parseInt(o2.toString()));
			}
			*/

			@Override
			public int compare(Integer o1, Integer o2) {
				
				return -1*(o1-o2); //reverse older 
			}
			
		};
		
		Stream <Integer> i=n.stream().map(x -> x*x).sorted(c);
		i.forEach(System.out::println);
	
	}

}
