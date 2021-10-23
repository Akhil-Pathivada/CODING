/*
Reverse the words in a String

Time Complexity : O(N)
Space Complexity : O(N)
*/

import java.util.*;

class GFG { 

	private static String reverseWords(String str) {

		String[] s = str.split(" ");
		String ans = "";

		for(int i = s.length - 1; i >= 0; --i) {

			ans += s[i] + " ";
		} 
		return ans;
	}

	public static void main(String[] args) {
	
		String str = "I Love this Program very much";
		System.out.println(reverseWords(str));
	}
}

