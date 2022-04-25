/**
 * LRU Cache Implementation....
 *
 * (Using LinkedHashSet)
 *
 * Time Complexity : O(1)
 * Space Complexity : O(N)
 * */
package queue;

import java.util.*;

public class LRUCacheReplacementII {
        
        private final int CACHE_SIZE; // maximum capacity of cache
        private Set<Integer> cache; // store references of key in cache
        private LRUCacheReplacementII(int capacity) {
                CACHE_SIZE = capacity;
                cache = new LinkedHashSet<>(capacity);
        }
        /** This function returns false if key is not present in cache. Else it moves the key to
          front by first removing it and then adding it, and returns true. */
        private boolean get(int page) {
                if (!cache.contains(page)) {
                        return false;
                }
                cache.remove(page);
                cache.add(page);
                return true;
        }
        
        /** if cache is full, remove first element in cache(which is lru)
          and insert new page into cache */
        private void put(int page) {
                if (cache.size() == CACHE_SIZE) {
                        int firstKey = cache.iterator().next();
                        cache.remove(firstKey);
                }
                cache.add(page);
        }
        
        // Refer the page within the LRU cache && insert if page not found
        private void refer(int page) {
                if (!get(page)) {
                        put(page);
                }
        }
        // display contents of cache
        private void displayCache() {
                LinkedList<Integer> list = new LinkedList<>(cache);
                /** The descendingIterator() method of java.util.LinkedList class is used to return an iterator over the elements
                 in this LinkedList in reverse sequential order */
                Iterator<Integer> itr = list.descendingIterator();
                while (itr.hasNext()) {
                        System.out.print(itr.next() + " ");
                }
        }
        public static void main(String[] args) {
                LRUCacheReplacementII ca = new LRUCacheReplacementII(4);
                ca.refer(1);
                ca.refer(2);
                ca.refer(3);
                ca.refer(1);
                ca.refer(4);
                ca.refer(5);
                ca.refer(2);
                ca.refer(2);
                ca.refer(1);
                ca.displayCache();
        }
}
