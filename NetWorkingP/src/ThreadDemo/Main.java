/**
 * 
 */
package ThreadDemo;

/**
 * @author M.NAVEEN
 * RANDOM CODER'S
 *
 */
public class Main {

	
	public static void main(String[] args) throws InterruptedException {
	 
		System.out.println();
		X x=new X();
		Thread t1=new Thread(x);
		Thread t2=new Thread(x);
		
		t1.start();
		t2.start();
		t1.join();
		t2.join();
        System.out.println(x.count);
	}

}

 class X implements Runnable{
    Integer count=0;
	@Override
	public void run() {
		  //System.out.println(count +"   !!  "+Thread.currentThread().getName());
	  for(int i=0;i<10;i++) {
		  synchronized(count){ 
			  System.out.println(count +"     "+Thread.currentThread().getName());
			  count++;
		  }
	  }
	  //System.out.println(count +"  ! !  "+Thread.currentThread().getName());
	}
	// for more info check https://gist.github.com/engineerscodes/312780a6c710a9d7ba0a87b074c2c9f0
	//output is not 20000
	//because  check this 
	//https://stackoverflow.com/questions/22047209/potential-concurrency-issue-when-integer-object-is-used-as-a-lock-in-synchronize

	// count++ --> i = Integer.valueOf(i.intValue() + 1) so new Integer is returned !!! that why i messed up !!!!!!
	/*
	 public static Integer valueOf(int i) {
	        if (i >= IntegerCache.low && i <= IntegerCache.high)
	            return IntegerCache.cache[i + (-IntegerCache.low)];
	        return new Integer(i);
	    }

	*/
  
}