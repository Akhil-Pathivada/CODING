/**
 * Date 05/05/2022
 *
 * @author akhilpathivada
 *
 * Using Two Stacks
 *
 * Time Complexity : For Push : O(1), Pop : O(1) -> Amortised
 * Space Complexity : O(N)
 */
package queue;

import java.util.Stack;

public class ImplementQueueUsingStackII {
        // Implement a queue using two stacks
        static class Queue<T> {
                Stack<T> input, output;
                Queue() {
                        input = new Stack<>();
                        output = new Stack<>();
                }
                void enqueue(T data) {
                        // push item into the input stack
                        input.push(data);
                }
                // Remove an item from the stack
                T dequeue() {
                        // if the output stack is empty
                        // push elements from input stack to output
                        if (output.isEmpty()) {
                                while (!input.isEmpty()) {
                                        output.push(input.pop());
                                }
                        }
                        // return the top item from the output stack
                        return output.pop();
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
