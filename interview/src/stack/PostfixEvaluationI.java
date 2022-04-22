/**
 * Date 06/04/2022
 *
 * @author akhilpathivada
 *
 * https://www.geeksforgeeks.org/stack-set-4-evaluation-postfix-expression/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 *
 */
package stack;

import java.util.Stack;

public class PostfixEvaluationI {
        
        private int evaluatePostfix(String postfix) {
                Stack<Integer> stack = new Stack<>();
                for(char ch : postfix.toCharArray()) {
                        if(Character.isDigit(ch)) { // If the scanned character is an operand (number here), push it to the stack.
                                stack.push(ch - '0');
                        } else { //  If the scanned character is an operator, pop two elements from stack apply the operator
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
                String postfix = "231*+9-";
                System.out.printf("postfix evaluation = %d", new PostfixEvaluationI().evaluatePostfix(postfix));
        }
}
