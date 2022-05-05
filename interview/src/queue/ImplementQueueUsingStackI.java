/**
 * Date 05/05/2022
 *
 * @author akhilpathivada
 *
 * Using Two Stacks
 *
 * Time Complexity : For Push : O(N), Pop : O(1)
 * Space Complexity : O(N)
 */
package queue;

import java.util.Stack;

public class ImplementQueueUsingStackI {
        // Implement a queue using two stacks
        static class Queue<T> {
                Stack<T> s1, s2;
                Queue() {
                        s1 = new Stack<>();
                        s2 = new Stack<>();
                }
                void enqueue(T data) {
                        // Move all elements from the first stack to the second stack
                        while (!s1.isEmpty()) {
                                s2.push(s1.pop());
                        }
                        // push item into the first stack
                        s1.push(data);
                        // Move all elements back to the first stack from the second stack
                        while (!s2.isEmpty()) {
                                s1.push(s2.pop());
                                
                        }
                }
                // Remove an item from the queue
                T dequeue() {
                        // if the first stack is empty
                        if (s1.isEmpty()) {
                                System.out.println("Underflow!!");
                                System.exit(0);
                        }
                        return s1.pop();
                }
        }
        
        public static void main(String[] args) {
                int[] keys = { 1, 2, 3, 4, 5 };
                Queue<Integer> queue = new Queue<Integer>();
                // insert above keys
                for (int key: keys) {
                        queue.enqueue(key);
                }
                System.out.println(queue.dequeue());    // print 1
                System.out.println(queue.dequeue());
        }
}
