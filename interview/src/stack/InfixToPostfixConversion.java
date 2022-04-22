/**
 * Date 06/04/2022
 *
 * @author akhilpathivada
 *
 * https://www.geeksforgeeks.org/stack-set-2-infix-to-postfix/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 *
 */
package stack;

import java.util.Stack;

public class InfixToPostfixConversion {
        
        private int precedence(char ch) {
                switch (ch) {
                        case '+':
                        case '-':
                                return 1;
                        case '*':
                        case '/':
                                return 2;
                        case '^':
                                return 3;
                }
                return -1;
        }
        
        private String infixToPostfix(String infix) {
                // initializing empty String for result
                StringBuilder postfix = new StringBuilder("");
                // initializing empty stack
                Stack<Character> stack = new Stack<>();
                for(char ch : infix.toCharArray()) {
                        if(Character.isLetterOrDigit(ch)) { // If the scanned character is an operand, add it to output.
                                postfix.append(ch);
                        } else if(ch == '(') { // If the scanned character is an '(', push it to the sta
                                stack.push(ch);
                        } else if(ch == ')') { // If the scanned character is an ')', pop and output from the stack until an '(' is encountered.
                                while(!stack.isEmpty() && stack.peek() != '(') {
                                        postfix.append(stack.pop());
                                }
                                stack.pop();
                        } else { // an operator is encountered
                                while(!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
                                        postfix.append(stack.pop());
                                }
                                stack.push(ch);
                        }
                }
                // pop all the operators from the stack
                while(!stack.isEmpty()) {
                        if(stack.peek() == '(') {
                                return "Invalid Expression";
                        }
                        postfix.append(stack.pop());
                }
                return postfix.toString();
        }
        
        public static void main(String[] args) {
                String infix = "a+b*(c^d-e)^(f+g*h)-i";
                System.out.println(new InfixToPostfixConversion().infixToPostfix(infix));
        }
}
