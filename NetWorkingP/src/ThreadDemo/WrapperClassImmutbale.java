/**
 * 
 */
package ThreadDemo;

/**
 * @author M.NAVEEN
 * RANDOM CODER'S
 *
 */
public class WrapperClassImmutbale {
	 public static void main(String[] args)
	    {
	        Integer i =12;
	        System.out.println(i);
	        modify(i);
	        
	        System.out.println("\nAFTER MODIFY "+i);
	    }
	  
	    private static void modify(Integer i)
	    {  
	        i = i + 10;
	     
	        System.out.println(i == i+1); //false because new  Integer(i+1) is returned;
	        
	        // it does new Integer(i+10);
	        //and assign to i
	        // so old referces it broken
	    }
	    
	    //https://www.geeksforgeeks.org/primitive-wrapper-classes-are-immutable-in-java/
}
