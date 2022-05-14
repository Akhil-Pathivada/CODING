/**
 * Date 07/04/2022
 *
 * @author akhilpathivada
 *
 * https://www.geeksforgeeks.org/design-and-implement-special-stack-data-structure/
 *
 * Space Complexity : O(1)
 *
 */
package stack;

import java.util.Stack;

public class SpecialStackForGetMinimum {
        static int min = Integer.MAX_VALUE;
        private static void push(Stack<Integer> stack, int value) {
                if (value > min) { // push element if it is bigger than min
                        stack.push(value);
                } else { // update min
                        stack.push(value - min);
                        min = value;
                }
        }
        private static int pop(Stack<Integer> stack) {
                // base case
                if (stack.isEmpty()) {
                        return -1;
                }
                // if popped element is minimum : update min and pop
                if (stack.peek() <= -1) {
                        int temp = min;
                        min -= stack.pop();
                        return temp;
                }
                return stack.pop();
        }
        // returns the minimum element
        private static int getMinimum() {
                return min;
        }
        public static void main(String[] args) {
                int[] nums = { 3, 2, 6, 1, 8, 5, 5, 5, 5 };
                Stack<Integer> stack = new Stack<>();
                // push elements into stack
                for (int num : nums) {
                        push(stack, num);
                        System.out.println("pushed: "+ num + " and min is: " + min);
                }
                // pop all elements from stack and print min every time
                for (int i = 0; i < nums.length; ++i) {
                        System.out.println("popped: "+ pop(stack) + " and min is: " + min);
                }
        }
}
