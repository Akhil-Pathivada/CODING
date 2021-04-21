/*
Given a sequence, find the length of the longest palindromic subsequence in it.

(Dynamic Programming)

Time Complexity : O(n^2)
Space Complexity : O(n^2)
*/

class LPS {

	int getLPS(char[] str) {

		int n = str.length;
		int i, j, cl;
		int LPS[][] = new int[n][n];


		// Strings of length 1 are palindrome of lentgh 1
		for(i = 0; i < n; ++i) {
			LPS[i][i] = 1;
		}

		// Build the table. Note that the lower
		// diagonal values of table are
		// useless and not filled in the process.
		// cl is length of substring: need to check 
		// for all lengths of string
		for(cl = 2; cl <= n; ++cl) {
			for(i = 0; i <= n - cl ; ++i) {
				j = i + cl - 1;

				if(str[i] == str[j] && cl == 2) {
					LPS[i][j] = 2;
				}
				else if(str[i] == str[j]) {
					LPS[i][j] = 2 + LPS[i+1][j-1];
				}
				else {
					LPS[i][j] = Math.max(LPS[i+1][j], LPS[i][j-1]);
				}
			}
		}
		return LPS[0][n-1];
	}

	public static void main(String args[]) {

		LPS obj = new LPS();

		String seq = "GEEKSFORGEEKS";
		char[] str = seq.toCharArray();
		
		System.out.println("The length of the LPS is: " + obj.getLPS(str));
	}
}
