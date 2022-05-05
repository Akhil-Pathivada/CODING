/**
 * Date 05/05/2022
 *
 * @author akhilpathivada
 *
 * Using One Queue
 *
 * Time Complexity for Push : O(N), Pop : O(1)
 * Space Complexity : O(N)
 */
package stack;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueueII {
        // Implement stack using two queues
        static class Stack<T> {
                Queue<T> queue;
                // Constructor
                Stack() {
                        queue = new LinkedList<>();
                }
                // Push an item into the stack
                void push(T data) {
                        // get previous size of queue
                        int size = queue.size();
                        // Add current element
                        queue.add(data);
                        for (int i = 0; i < size; ++i) {
                                // this will add front element into rear of queue
                                queue.add(queue.remove());
                        }
                }
                // Remove the top item from the stack
                T pop() {
                        // if the first queue is empty
                        if (queue.isEmpty()) {
                                System.out.println("Underflow!!");
                                System.exit(0);
                        }
                        return queue.poll();
                }
        }
        
        public static void main(String[] args) {
                int[] keys = { 1, 2, 3, 4, 5 };
                // insert the above keys into the stack
                Stack<Integer> s = new Stack<Integer>();
                for (int key: keys) {
                        s.push(key);
                }
                // printing elements of stack
                for (int i = 0; i <= keys.length; i++) {
                        System.out.println(s.pop());
                }
        }
}