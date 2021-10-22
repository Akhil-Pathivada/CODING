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
 * Auxiliary Space : O(1)
 *  */

import java.util.*;

class GFG {

	private static boolean checkForSubsequence(String str, String target, int m, int n) {

		if(n == 0) {
			return true;
		}
		if(m == 0) {
			return false;
		}
		if(target.charAt(n-1) == str.charAt(m-1)) {
			return checkForSubsequence(str, target, m - 1, n - 1);
		}

		int j = 0; // keeps track of target string
		for(int i = 0; i < m && j < n; ++i) {

			if(target.charAt(j) == str.charAt(i)) {
				++j;
			}
		}
		return (j == n);
	}

	public static void main(String args[]) {

		String str = "KOTTAYAM";
		String target = "KOTA";

		System.out.println(checkForSubsequence(str, target, str.length(), target.length()) ? "Yes" : "No");
	}
}
