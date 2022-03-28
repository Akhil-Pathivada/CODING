/**
 * https://leetcode.com/problems/top-k-frequent-elements/
 *
 * Time Complexity : O(K * log(N))
 * Space Complexity : O(N)
 * */
package heap;

import java.util.*;

public class TopKFrequentElementsI {
        
        private static List<Integer> topKFrequentElements(int[] nums, int K) {
                // store <element, frequency> in a map
                Map<Integer, Integer> frequencyMap = new HashMap<>();
                for(int num : nums) {
                        frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
                }
                // create a maxHeap
                PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a,b) -> (b.getValue() - a.getValue()));
                // store entries of hashmap into maxHeap
                for(Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
                        maxHeap.add(entry);
                }
                List<Integer> result = new ArrayList<>();
                // poll the K elements from heap and append to result
                while(K-- > 0) {
                        Map.Entry<Integer, Integer> entry = maxHeap.poll();
                        result.add(entry.getKey());
                }
                return result;
        }
        
        public static void main(String[] args) {
        
                int nums[] = {1, 1, 1, 2, 2, 3};
                int K = 2;
                System.out.println(topKFrequentElements(nums, K));
        }
}
