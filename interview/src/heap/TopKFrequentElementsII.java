/**
 * https://leetcode.com/problems/top-k-frequent-elements/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 * */
package heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElementsII {
        
        private static List<Integer> topKFrequentElements(int[] nums, int K) {
                // store <element, frequency> in a map
                Map<Integer, Integer> frequencyMap = new HashMap<>();
                for(int num : nums) {
                        frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
                }
                // store into bucket as <frequency, element(s)> format
                List<Integer>[] bucket = new List[nums.length + 1];
                for(int key : frequencyMap.keySet()) {
                        int frequency = frequencyMap.get(key);
                        // no element present yet for this frequency
                        if(bucket[frequency] == null) {
                                bucket[frequency] = new ArrayList<>();
                        }
                        // add element to that list
                        bucket[frequency].add(key);
                }
                List<Integer> result = new ArrayList<>();
                // iterate over bucket in reverse order to get top K frequency elements
                for(int i = bucket.length - 1; i >= 0 && result.size() < K; --i) {
                        if(bucket[i] != null) {
                                result.addAll(bucket[i]);
                        }
                }
                return result;
        }
        
        public static void main(String[] args) {
                
                int nums[] = {1, 1, 1, 2, 2, 3};
                int K = 2;
                System.out.println(topKFrequentElements(nums, K));
        }
}
