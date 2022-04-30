/**
 * https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/
 *
 * Time Complexity : O(D + (N * log(N)))....where D is the range of A[i][1]
 * Space Complexity : O(N)
 * */
package misc;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaxEventsCanBeAttend {
        
        private int maxEvents(int[][] events) {
                // sort based upon start times
                Arrays.sort(events, (a, b) -> a[0] - b[0]);
                PriorityQueue<Integer> minHeap = new PriorityQueue<>();
                int i = 0, res = 0, n = events.length;
                // take a pool of days and iterate over it
                for (int d = 1; d <= 100000; ++d) {
                        // Add new events that can attend on day `d`
                        while (i < n && events[i][0] == d) {
                                minHeap.offer(events[i++][1]);
                        }
                        // Remove events that are already closed
                        while (!minHeap.isEmpty() && minHeap.peek() < d) {
                                minHeap.poll();
                        }
                        // Use day `d` to attend to the event that closes earlier
                        if (!minHeap.isEmpty()) {
                                ++res;
                                minHeap.poll();
                        }
                }
                return res;
        }
        
        public static void main(String[] args) {
                int[][] events = {{1, 2}, {2, 3}, {3, 4}, {1, 2}};
                System.out.println("Max events can be attended = " + new MaxEventsCanBeAttend().maxEvents(events));
        }
}
