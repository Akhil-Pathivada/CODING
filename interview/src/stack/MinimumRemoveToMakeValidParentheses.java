/**
 * Date 13/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 */
package stack;

import java.util.Stack;

public class MinimumRemoveToMakeValidParentheses {
        
        private String minRemove(String s) {
                StringBuilder sb = new StringBuilder(s);
                Stack<Integer> stack = new Stack<>();
                for (int i = 0; i < sb.length(); ++i) {
                        // push index of '('
                        if (sb.charAt(i) == '(') {
                                stack.push(i);
                        } else if (sb.charAt(i) == ')'){
                                // balanced
                                if (!stack.isEmpty()) {
                                        stack.pop();
                                } else { // replace ')' with '*'
                                        sb.setCharAt(i, '*');
                                }
                        }
                }
                // replace ')' with '*'
                while (!stack.isEmpty()) {
                        sb.setCharAt(stack.pop(), '*');
                }
                // replace '*' with ''
                return sb.toString().replaceAll("\\*", "");
        }
        
        public static void main(String[] args) {
                String s = "lee(t(c)o)de)";
                System.out.println("Valid string after removal = " + new MinimumRemoveToMakeValidParentheses().minRemove(s));
        }
}
