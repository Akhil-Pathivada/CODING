/*
Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.

Note that after backspacing an empty text, the text will continue empty.

 

Example 1:

Input: s = "ab#c", t = "ad#c"
Output: true
Explanation: Both s and t become "ac".
Example 2:

Input: s = "ab##", t = "c#d#"
Output: true
Explanation: Both s and t become "".

Time Complexity: O(M + N) where M, N are the lengths of S and T respectively.
Space Complexity: O(M + N).
*/

import java.util.*;

class GFG {

	static boolean backspaceCompare(String S, String T) {

		return build(S).equals(build(T));
	}

	static String build(String s) {

		Stack<Character> ans = new Stack<>();
		String result = "";
		for(char c : s.toCharArray()) {

			if(c != '#') {
				ans.push(c);
			}
			else if(!ans.isEmpty()) {
				ans.pop();
			}
		}
		return String.valueOf(ans);
	} 

	public static void main(String[] args) {

		String S = new String("ab#c");
		String T = new String("ad#c");

		System.out.println(backspaceCompare(S, T));
	}
}