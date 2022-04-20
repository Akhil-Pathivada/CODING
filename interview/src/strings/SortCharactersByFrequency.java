/**
 * Date 04/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/sort-characters-by-frequency/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(1) -> for 26 characters
 *
 */
package strings;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {
        
        private String sortCharacters(String s) {
                Map<Character, Integer> map = new HashMap<>();
                // insert all character, frequency into map
                for(char c : s.toCharArray()) {
                        map.put(c, map.getOrDefault(c, 0) + 1);
                }
                PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
                maxHeap.addAll(map.entrySet()); // add all map elements into maxheap
                StringBuilder sb = new StringBuilder();
                // iterate till heap becomes empty
                while(!maxHeap.isEmpty()) {
                        Map.Entry e = maxHeap.poll();
                        // append character
                        for(int i = 0; i < (int)e.getValue(); ++i) {
                                sb.append(e.getKey());
                        }
                }
                return sb.toString();
        }
        
        public static void main(String[] args) {
                String s = "tree";
                System.out.printf("Sorted String = %s ", new SortCharactersByFrequency().sortCharacters(s));
        }
}
