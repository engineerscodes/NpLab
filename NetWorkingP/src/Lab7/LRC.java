/**
 * 
 */
package Lab7;

/**
 * @author M.NAVEEN
 * RANDOM CODER'S
 *
 */

import java.util.*;



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
	}

	public void display() {
		Iterator<Integer> itr = doublyQueue.iterator();
		System.out.print("LRC PAGE NUMEBER : ");
		while (itr.hasNext()) {
			System.out.print(itr.next() + " ");
		}
	}

	public static void main(String[] args) {
		LRC cache = new LRC(4);
		cache.add(1);
		cache.add(2);
		cache.add(3);
		cache.add(1);
		cache.add(4);
		cache.add(5);
		cache.add(2);
		cache.add(2);
		cache.add(1);
		System.out.println("---".repeat(20)+" CACHE "+"---".repeat(20));
		cache.display();
	}
}

