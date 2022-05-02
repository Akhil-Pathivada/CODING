/**
 * https://leetcode.com/problems/valid-parentheses/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 * */
package stack;

import java.util.Stack;

public class ValidParentheses {
        
        private boolean isValid(String str) {
                Stack<Character> stack = new Stack<Character>();
                // iterate over string
                for (char c : str.toCharArray()) {
                        if (c == '(') {
                                stack.push(')');
                        } else if(c == '{') {
                                stack.push('}');
                        } else if(c == '[') {
                                stack.push(']');
                        } else if (stack.isEmpty() || stack.pop() != c) {
                                return false;
                        }
                }
                return stack.isEmpty();
        }
        
        public static void main(String[] args) {
                String str = "()[]{}";
                System.out.println(new ValidParentheses().isValid(str));
        }
}
