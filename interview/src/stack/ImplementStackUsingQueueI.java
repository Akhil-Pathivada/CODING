/**
 * Date 05/05/2022
 *
 * @author akhilpathivada
 *
 * Using Two Queues
 *
 * Time Complexity for Push : O(N), Pop : O(1)
 * Space Complexity : O(N)
 */
package stack;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueueI {
        // Implement stack using two queues
        static class Stack<T> {
                Queue<T> q1, q2;
                // Constructor
                Stack() {
                        q1 = new LinkedList<>();
                        q2 = new LinkedList<>();
                }
                // Push an item into the stack
                void push(T data) {
                        // Move all elements from the first queue to the second queue
                        while (!q1.isEmpty()) {
                                q2.add(q1.poll());
                        }
                        // Push the given item into the first queue
                        q1.add(data);
                        // Move all elements back to the first queue from the second queue
                        while (!q2.isEmpty()) {
                                q1.add(q2.poll());
                        }
                }
                // Remove the top item from the stack
                T pop() {
                        // if the first queue is empty
                        if (q1.isEmpty()) {
                                System.out.println("Underflow!!");
                                System.exit(0);
                        }
                        // return the front item from the first queue
                        return q1.poll();
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
