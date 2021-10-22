/* 
 * Given a string S, the task is to check if the string target is a subsequence of string str or not, using a Stack.
 *
 * Examples:
 *
 * Input: S = ”KOTTAYAM”, target = ”KOTA”
 * Output: Yes
 * Explanation: “KOTA” is a subsequence of “KOTTAYAM”.
 *
 * Time Complexity : O(N)
 * Auxiliary Space : O(N)
 *  */

import java.util.*;

class GFG {

	private void checkForSubsequence(String str, String target) {

		Stack<Character> stack = new Stack<>();

		// Push the characters of target into the stack
		for (int i = 0; i < target.length(); ++i) {
		    stack.push(target.charAt(i));
		}

		// Traverse the string S in reverse
		for (int i = (int)str.length() - 1; i >= 0; --i) {
	 
		    // If the stack is empty
		    if (stack.empty()) {
	 
			System.out.println("Yes");
			return;
		    }
	 
		    // if S[i] is same as the top of the stack
		    if (str.charAt(i) == stack.peek()) {
			// Pop the top of stack
			stack.pop();
		    }
		}
	 
		// Stack is empty
		if (stack.empty())
		    System.out.println("Yes");
		else
		    System.out.println("No");
	}

	public static void main(String args[]) {

		String str = "KOTTAYAM";
		String target = "KOTA";

		GFG obj = new GFG();

		obj.checkForSubsequence(str, target);
	}
}
