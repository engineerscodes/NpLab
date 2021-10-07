/**
 * 
 */
package JAVA8APIS;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;
import java.io.*;
/**
 * @author M.NAVEEN
 * RANDOM CODER'S
 *
 */

interface x{
	//A default method cannot override a method from java.lang.Object
	/*default boolean equals(Object e)
	{
		return true;
	}
	*/
}
public class Basic {

	public static void main(String ...strings) {
		
	    List <Integer> n= Arrays.asList(1,3,5,6,19);
	    //EXternal iterations
	    for(int i=0;i<n.size();i++)
	    	System.out.print(n.get(i)+" ");
		 System.out.println();
		 System.out.println();
	    for(Integer i:n)
	    	System.out.print(i+" ");
	    System.out.println();
	    System.out.println();
	    //or 
	    //internal iterations
	    // foreach takes functional interface caonsumer
	    n.stream().forEach(x->System.out.print(x+" "));
	    //This is what is happening 
	    Consumer <Integer> obj=(x)->{
	    	System.out.print(x+100 +", ");
	    };
	    
	   // obj.accept(451);
	    System.out.println();
	    n.stream().forEach(obj);
	    
	    //with type
	    System.out.println();
	    System.out.println();
	    n.stream().forEach((Integer i)->{System.out.print(i+" !!!!!!!!!!!! ");});
	    System.out.println();
	    //list has foreach
	    //forEach is default impl in List
	    n.forEach(i->System.out.print(" # "+i));
		
	    System.out.println();
	    //using method referces
	    n.forEach(System.out::println);
	    
	    n.stream().filter(i->{
	    	if(i%2==0 || i%5==0)  // it will remove number with even values and 5 multiples
	    		return false;
	    	return true;
	    }).forEach(i->{System.out.println(i+" !");});
	    System.out.println("==================================STREAM CANNOT BE REUSED=================================");
	    Stream<Integer> x=n.stream();
	    
	    x.forEach(System.out::print);
	  //  x.forEach(System.out::print);
		/*
			Exception in thread "main" java.lang.IllegalStateException: stream has already been operated upon or closed
			at java.base/java.util.stream.AbstractPipeline.sourceStageSpliterator(AbstractPipeline.java:279)
			at java.base/java.util.stream.ReferencePipeline$Head.forEach(ReferencePipeline.java:658)
			at JAVA8APIS.Basic.main(Basic.java:75)
		*/
	    
	    System.out.println("\n==================================SUM OF LIST=============================================");
	    List<Integer> num=Arrays.asList(1,2,3,4,5,6,1,99);
	    System.out.println(num.stream().map(i->i+0).reduce(0,(c,e)->c+e));
	    System.out.println(num.stream().reduce(0,(c,e)->c+e));
	    
	    Function<Integer,Integer> f=new Function<Integer,Integer>() {
            int sum=0;
			@Override
			public Integer apply(Integer t) {
				
				return t;
			}
	    	
	    };
	    
	    BinaryOperator<Integer> bp=new BinaryOperator<Integer>() {
            int mul=0;
			@Override
			public Integer apply(Integer t, Integer u) {
				
				mul+=t*u;
				return mul;
			}
     
	    };
	  System.out.println(  "HI "+num.stream().reduce(bp).get());
	    
	    
	    Consumer <Integer> cs=new Consumer<Integer>() {
            int sum=0;
			public void accept(Integer t) {
			  sum=sum+t;
				System.out.println(sum);
			}
	    	
	    };
	    
	   
	   num.forEach(cs);
	   
	   System.out.println("Size of Stream  : "+num.stream().distinct().count()); //get distinct element and count it 
	   System.out.println("==================================DISTINCT====================================");
	   num.stream().distinct().forEach(i->System.out.print(i+" , "));
	   
	
	}
}
