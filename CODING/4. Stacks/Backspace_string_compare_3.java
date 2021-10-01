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

Time Complexity: O(M)+ O(N) where M, N are the lengths of S and T respectively.
Space Complexity: O(M)+ O(N).
*/

import java.util.*;

class GFG {

	static boolean backspaceCompare(String S, String T) {

		return build(S).equals(build(T));
	}

	static String build(String str) {

		StringBuilder res = new StringBuilder();
		int count = 0;
		// start from the end of string
		for(int i = str.length() - 1; i >=0; --i) {

			char ch = str.charAt(i);
			// count occurences of '#'
			if(ch == '#') {
				++count;
			}
			else {
				if(count > 0) {
					--count;
				}
				else {
					res.append(ch);
				}
			}
		}
		return res.toString();
	} 

	public static void main(String[] args) {

		String S = new String("ab#c");
		String T = new String("ad#c");

		System.out.println(backspaceCompare(S, T));
	}
}