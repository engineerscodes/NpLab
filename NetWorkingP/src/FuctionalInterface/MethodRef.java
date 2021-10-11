/**
 * 
 */
package FuctionalInterface;

/**
 * @author M.NAVEEN
 * RANDOM CODER'S
 *
 */

interface x{
	
	void show(String str);
}

interface y{
	
	public int show(String s1,String s2);
}

public class MethodRef {
    
	public static void hell(String text) {
		System.out.println("Why did you send me this : "+text);
	}
    
	public static void main(String ...strings) {
		
		x obj=MethodRef::hell;  //static method refernces
		obj.show("You Bala !");
		y obj2=String::indexOf;  
		System.out.println(obj2.show("HILLO","Heelo"));
		int s=4_____8_____________________________0___________________1_____________________________________99;
		System.out.print(s);
	}

	

}
