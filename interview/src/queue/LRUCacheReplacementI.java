/**
 * LRU Cache Implementation....
 *
 * Time Complexity : O(1)
 * Space Complexity : O(N)
 * */
package queue;

import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class LRUCacheReplacementI {
        
        private final int CACHE_SIZE; // maximum capacity of cache
        private Deque<Integer> deque; // store keys of cache
        private HashSet<Integer> hashSet; // store references of key in cache
        private LRUCacheReplacementI(int capacity) {
                CACHE_SIZE = capacity;
                deque = new LinkedList<>();
                hashSet = new HashSet<>(capacity);
        }
        // Refer the page within the LRU cache
        private void refer(int page) {
                // if page not found && cache is full
                if (!hashSet.contains(page)) {
                        if (deque.size() == CACHE_SIZE) {
                                // remove least recently used page: it should be last
                                int lru = deque.removeLast();
                                hashSet.remove(lru);
                        }
                } else { /** The found page may not be always the last element, even if it's an intermediate
                 element that needs to be removed and added to the start of the Queue */
                        deque.remove(page);
                }
                deque.addFirst(page);
                hashSet.add(page);
        }
        // display contents of cache
        private void displayCache() {
                Iterator<Integer> itr = deque.iterator();
                while (itr.hasNext()) {
                        System.out.print(itr.next() + " ");
                }
        }
        public static void main(String[] args) {
                LRUCacheReplacementI cache = new LRUCacheReplacementI(4);
                cache.refer(1);
                cache.refer(2);
                cache.refer(3);
                cache.refer(1);
                cache.refer(4);
                cache.refer(5);
                cache.refer(2);
                cache.refer(2);
                cache.refer(1);
                cache.displayCache();
        }
}
