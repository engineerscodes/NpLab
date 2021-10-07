/**
 * 
 */
package ExamDemo;

import java.util.*;
import java.util.stream.*;


/**
 * @author M.NAVEEN
 * RANDOM CODER'S
 *
 */
public class TcpList {

	public static void main(String[] args) {
	
		ArrayList <Integer> n=new ArrayList();
		
		n.add(51);
		n.add(1);
		n.add(84);
		n.add(0);
		
		Stream<Integer> s=n.stream().sorted().distinct().map(i->i*5).filter(i ->{
			if(i%2==0)
			return	false;
		return true;
		});
		
		//System.out.println(s.findFirst().get());

		s.forEach(System.out::println);
	     //Stream<Integer> s1=n.stream().map(i->i*i);
		//s1.forEach(e->{System.out.println(e);});
		
		byte arr[]= {65,66};
		System.out.println(new String(arr));
		System.out.println(" 5 mutiples ");
		
		ArrayList <Integer> n2=new ArrayList();
		n2.add(9);
		n2.add(55);
		n2.add(1);
		n2.add(10);
		
		n2.stream().filter(i->{
			if(i%5 ==0 )
				return true;
			return false;
		}).forEach(System.out::println);
		
		ArrayList<Integer> n3=(ArrayList<Integer>) n2.stream().filter(i->{
			if(i%5 ==0 )
				return true;
			return false;
		}).collect(Collectors.toList());
         
		System.out.println(n3);
	}

}
