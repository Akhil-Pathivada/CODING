/**
 * Date 08/04/2022
 *
 * @author akhilpathivada
 *
 * https://www.geeksforgeeks.org/connect-n-ropes-minimum-cost/
 *
 * Time Complexity : O(N * log(N))
 * Space Complexity : O(N)
 */
package greedy;

import java.util.PriorityQueue;

public class ConnectNRopesMinimumCost {
        
        private int minCost(int[] arr, int n) {
                // create a min heap
                PriorityQueue<Integer> minHeap = new PriorityQueue<>();
                // adding items to the heap
                for (int i : arr) {
                        minHeap.add(i);
                }
                // initialize result
                int result = 0;
                while (minHeap.size() > 1) {
                        // extract shortest two ropes from pq
                        int first = minHeap.poll();
                        int second = minHeap.poll();
                        // Connect the ropes: update result and insert the new rope to heap
                        result += first + second;
                        minHeap.offer(first + second);
                }
                return result;
        }
        
        public static void main(String[] args) {
                int arr[] = { 4, 3, 2, 6 };
                System.out.println("Total cost for connecting ropes is = " + new ConnectNRopesMinimumCost().minCost(arr, arr.length));
        }
}
