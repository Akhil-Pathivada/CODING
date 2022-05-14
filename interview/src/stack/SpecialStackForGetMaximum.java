/**
 * Date 07/04/2022
 *
 * @author akhilpathivada
 * 
 * Space Complexity : O(1)
 */
package stack;

import java.util.Stack;

public class SpecialStackForGetMaximum {
        static int max = Integer.MIN_VALUE;
        private static void push(Stack<Integer> stack, int value) {
                // push element if it is bigger than max
                if (value < max) {
                        stack.push(value);
                } else { // update max
                        stack.push(max - value);
                        max = value;
                }
        }
        private static int pop(Stack<Integer> stack) {
                // base case
                if (stack.isEmpty()) {
                        return -1;
                }
                // if popped element is maximum : update max and pop
                if (stack.peek() <= -1) {
                        int temp = max;
                        max += stack.pop();
                        return temp;
                }
                return stack.pop();
        }
        // returns the maximum element
        private static int getmaximum() {
                return max;
        }
        public static void main(String[] args) {
                int[] nums = { 3, 2, 6, 1, 8, 5, 5, 5, 5 };
                Stack<Integer> stack = new Stack<>();
                // push elements into stack
                for (int num : nums) {
                        push(stack, num);
                        System.out.println("pushed: "+ num + " and max is: " + max);
                }
                // pop all elements from stack and print max every time
                for (int i = 0; i < nums.length; ++i) {
                        System.out.println("popped: "+ pop(stack) + " and max is: " + max);
                }
        }
}
