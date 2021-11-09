/*
LRU Cache Implementation....

Time Complexity : O(1)
Space Complexity : O(N)
*/
import java.util.*;

class LRUCache {

	private Deque<Integer> deque; // store keys of cache
	private HashSet<Integer> hashSet; // store references of key in cache
	private final int CACHE_SIZE; // maximum capacity of cache

	LRUCache(int capacity) {

		deque = new LinkedList<>();
		hashSet = new HashSet<>();
		CACHE_SIZE = capacity;
	}

	private void refer(int page) {

		if(!hashSet.contains(page)) {

			if(deque.size() == CACHE_SIZE) {

				int lru = deque.removeLast();
				hashSet.remove(lru);
			}
		}
		else { 
			deque.remove(page);
		}
		deque.addFirst(page);
		hashSet.add(page);
	}

	private void display() {

        	Iterator<Integer> itr = deque.iterator();

        	while (itr.hasNext()) {
         	   System.out.print(itr.next() + " ");
        	}		
	}

	public static void main(String[] args) {
		
		LRUCache cache = new LRUCache(4);

        	cache.refer(1);
        	cache.refer(2);
        	cache.refer(3);
        	cache.refer(1);
        	cache.refer(4);
        	cache.refer(5);
        	cache.refer(2);
        	cache.refer(2);
        	cache.refer(1);

        	cache.display();		
	}
}