/**
 * https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
 *
 * Time Complexity : O(N ^ 2)
 * Space Complexity : O(N)
 * */
package heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class KPairsWithSmallestSumsI {
        
        private static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
                // store elements in max heap
                PriorityQueue<List<Integer>> maxHeap = new PriorityQueue<>(
                        (a, b) -> (b.get(0) + b.get(1)) - (a.get(0) + a.get(1))
                );
                
                for(int i = 0; i < nums1.length; ++i) {
                        for(int j = 0; j < nums2.length; ++j) {
                                // insert into max heap
                                maxHeap.offer(Arrays.asList(nums1[i], nums2[j]));
                                // remove top when heap size exceeds K
                                if(maxHeap.size() > k) {
                                        maxHeap.poll();
                                }
                        }
                }
                return new ArrayList<>(maxHeap);
        }
        
        public static void main(String[] args) {
                
                int nums1[] = {1, 7, 11}, nums2[] = { 2, 4, 6}, k = 3;
                System.out.println(kSmallestPairs(nums1, nums2, k));
        }
}
