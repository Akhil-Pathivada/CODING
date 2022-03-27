/**
 * https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
 *
 * Time Complexity : O(K * log(K))
 * Space Complexity : O(N)
 * */
package heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class KPairsWithSmallestSumsII {
        
        private static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
                // store elements in max heap
                PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>(
                        (a, b) -> (nums1[a.get(0)] + nums2[a.get(1)]) - (nums1[b.get(0)] + nums2[b.get(1)])
                );
                // offer initial pairs {nums[i], first element of nums2}
                for(int i = 0; i < Math.min(k, nums1.length); ++i) {
                        minHeap.offer(Arrays.asList(i, 0));
                }
                // store result
                List<List<Integer>> result = new ArrayList<>();
                
                while(k-- > 0 && !minHeap.isEmpty()) {
                        // poll the min and add to result
                        List<Integer> curr = minHeap.poll();
                        result.add(Arrays.asList(nums1[curr.get(0)], nums2[curr.get(1)]));
                        // dont' add the next index if there is no more left in 2nd array
                        if (curr.get(1) == nums2.length - 1) continue;
                        // form pairs with current nums1 element with remaining elements of nums2
                        minHeap.offer(Arrays.asList(curr.get(0), curr.get(1) + 1));
                
                }
                return result;
        }
        
        public static void main(String[] args) {
                
                int nums1[] = {1, 7, 11}, nums2[] = { 2, 4, 6}, k = 3;
                System.out.println(kSmallestPairs(nums1, nums2, k));
        }
}
