/**
 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 * */

package strings;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInStringI {
        
        private static String removeDuplicates(String s, int k) {
                // maintains character at stack[0] and its frequency at stack[1]
                Stack<int[]> stack = new Stack<>();
                
                for(char c : s.toCharArray()) {
                        // if the top character matches current character
                        if(!stack.isEmpty() && stack.peek()[0] == c) {
                                // increment its frequency
                                stack.peek()[1]++;
                        }
                        else { // push if we visiting char for first time
                                stack.push(new int[]{c, 1});
                        }
                        // if k adjacent same chars encountered
                        if(stack.peek()[1] == k) {
                                stack.pop();
                        }
                }
                // stores result
                StringBuilder sb = new StringBuilder();
                // append chars in stack and reverse it
                while(!stack.isEmpty()) {
                        // pop from stack
                        int[] e = stack.pop();
                        // append char based on its frequency
                        for( ; e[1] > 0; --e[1]) {
                                sb.append((char) e[0]);
                        }
                }
                return sb.reverse().toString();
        }
        
        public static void main(String[] args) {
                
                String s1 = "pbbcggttciiippooaais";
                int k1 = 2;
                System.out.println(removeDuplicates(s1, k1));
                
                String s2 = "deeedbbcccbdaa";
                int k2 = 3;
                System.out.println(removeDuplicates(s2, k2));
        }
}
