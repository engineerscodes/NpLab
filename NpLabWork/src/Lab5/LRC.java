
package Lab5;
import java.util.*;
import java.io.IOException;
import java.net.InetSocketAddress;


/**
 *
 * @author 19BCN7185
 */


public class LRC {



private Deque<Integer> doublyQueue;
private HashSet<Integer> hashSet;



final int SIZE;



LRC(int capacity) {
this.doublyQueue = new LinkedList<>();
this.hashSet = new HashSet<>();
this.SIZE = capacity;
}



public void add(int page) {
if (!hashSet.contains(page)) {
	if (doublyQueue.size() == SIZE) {
	int last = doublyQueue.removeLast();
	hashSet.remove(last);
	   }
}
else {
doublyQueue.remove(page);
}
doublyQueue.push(page);
hashSet.add(page);

System.out.println(doublyQueue);
}



public void display() {
Iterator<Integer> itr = doublyQueue.iterator();
System.out.print("LRC PAGE NUMEBER : ");
while (itr.hasNext()) {
System.out.print(itr.next() + " ");
}
}



public static void main(String[] args) throws IOException {
LRC cache = new LRC(4);
cache.add(1);
cache.add(2);
cache.add(3);
cache.add(1);
cache.add(4);
cache.add(5);
System.out.println("---------------------------------------"+" CACHE "+"----------------------------------");
cache.display();


}
}