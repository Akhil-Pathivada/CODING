/**
 * Date 11/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/sliding-window-maximum/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(K)
 *
 */
package slidingwindow;

import java.util.*;

public class SlidingWindowMaximumII {
        
        private static int[] maxSlidingWindow(int[] nums, int k) {
                
                // maintain a deque, we store indexes of elements
                // always the index of maximum element of a window is at head
                Deque<Integer> deque = new LinkedList<>();
                // store maximum of every window
                List<Integer> result = new ArrayList<>();
                int i = 0;
                // for the first window
                for( ; i < k; ++i) {
                        // poll the smaller elements from last
                        while(!deque.isEmpty() && nums[i] >= nums[deque.peekLast()])  {
                                deque.removeLast();
                        }
                        // insert current element's index at last
                        deque.addLast(i);
                }
                // maximum is at head of deque
                result.add(nums[deque.peekFirst()]);
                for( ; i < nums.length; ++i) {
                        // if queue contains index which is out of current window
                        while(!deque.isEmpty() && deque.peekFirst() <= i - k) {
                                deque.removeFirst();
                        }
                        // poll the smaller elements from last
                        while(!deque.isEmpty() && nums[i] >= nums[deque.peekLast()])  {
                                deque.removeLast();
                        }
                        // insert current element's index at last
                        deque.addLast(i);
                        // maximum is at head of deque
                        result.add(nums[deque.peekFirst()]);
                }
                return result.stream().mapToInt(e -> e).toArray();
        }
        
        public static void main(String[] args) {
                
                int nums[] = { 1, 3, -1, -3, 5, 3, 6, 7 }, k = 3;
                System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
        }
}
