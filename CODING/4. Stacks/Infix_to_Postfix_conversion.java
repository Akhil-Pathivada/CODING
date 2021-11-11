/*
Program to convert a Infix Expression into Postfix Expression.....

Time Complexity : O(N)
Space Complexity : O(N)
*/
import java.util.*;

class GFG {

	// A utility function to return precedence of a given operator
	// Higher returned value means higher precedence
	static int Prec(char ch) {

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

	private static String infixToPostfix(String exp) {

		String result = new String("");
		Stack<Character> stack = new Stack<>();

		for(int i = 0; i < exp.length(); ++i) {

			char ch = exp.charAt(i);
			// If the scanned character is an operand, add it to output.
			if(Character.isLetterOrDigit(ch)) {
				result += ch;
			}
			// If the scanned character is an '(' push it to the stack
			else if(ch == '(') {
				stack.push(ch);
			}
			//  If the scanned character is an ')'  
			// pop and output from the stack until an '(' is encountered.
			else if(ch == ')') {

				while(!stack.isEmpty() && stack.peek() != '(') {
					result += stack.pop();
				}
				stack.pop();
			} 
			// an operator is encountered
			else {
 				while(!stack.isEmpty() && Prec(ch) <= Prec(stack.peek())) {
					result += stack.pop();
				}
				stack.push(ch);
			}
		}
		// pop all the operators from the stack
		while(!stack.isEmpty()) {

			if(stack.peek() == '(') {
				return "Invalid Expression";
			}
			result += stack.pop();
		}
		return result;
	}

	public static void main(String[] args) {
		
		String exp = "a+b*(c^d-e)^(f+g*h)-i";
		System.out.print(infixToPostfix(exp));
	}
}