/**
 * https://leetcode.com/problems/kth-largest-element-in-a-stream/
 *
 * Time Complexity : O(K)
 * Space Complexity : O(K)
 *
 * */
package heap;

import java.io.PrintStream;
import java.util.PriorityQueue;

public class KthLargestElementInStream {
        
        private void printKthLargestElementInStream(int[] stream, int k) {
                PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
                for (int ele : stream) {
                        // insert element
                        minHeap.offer(ele);
                        if (minHeap.size() > k) {
                                // remove top from minheap
                                minHeap.poll();
                                System.out.print(minHeap.peek() + ", ");
                        }
                }
        }
        
        public static void main(String[] args) {
                int[] stream = {4, 5, 8, 2, 3, 5, 10, 9, 4};
                int k = 3;
                new KthLargestElementInStream().printKthLargestElementInStream(stream, k);
        }
}
