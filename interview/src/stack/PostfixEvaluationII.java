/**
 * Date 06/04/2022
 *
 * @author akhilpathivada
 *
 * https://www.geeksforgeeks.org/stack-set-4-evaluation-postfix-expression/
 *
 * Allows operands to have multiple digits
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 *
 */
package stack;

import java.util.Stack;

public class PostfixEvaluationII {
        
        private static int evaluatePostfix(String postfix) {
                
                Stack<Integer> stack = new Stack<>();
                
                for(int i = 0; i < postfix.length(); ++i) {
                        
                        char ch = postfix.charAt(i);
                        
                        if(ch == ' ') {
                                continue;
                        }
                        // If the scanned character is an operand (number here), push it to the stack.
                        else if(Character.isDigit(ch)) {
                                //extract the characters and store it in num
                                int n = 0;
                                while(Character.isDigit(ch)) {
                                        
                                        n = n * 10 + (int) (ch - '0');
                                        ch = postfix.charAt(++i);
                                }
                                --i;
                                // push the number in stack
                                stack.push(n);
                        }
                        //  If the scanned character is an operator, pop two
                        // elements from stack apply the operator
                        else {
                                int n1 = stack.pop();
                                int n2 = stack.pop();
                                
                                switch(ch) {
                                        
                                        case '+':
                                                stack.push(n1 + n2);
                                                break;
                                        case '-':
                                                stack.push(n2 - n1);
                                                break;
                                        case '*':
                                                stack.push(n1 * n2);
                                                break;
                                        case '/':
                                                stack.push(n2 / n1);
                                                break;
                                }
                        }
                }
                return stack.pop();
        }
        
        public static void main(String[] args) {
                
                String postfix = "100 200 + 2 / 5 * 7 +";
                System.out.printf("postfix evaluation = %d", evaluatePostfix(postfix));
        }
}
