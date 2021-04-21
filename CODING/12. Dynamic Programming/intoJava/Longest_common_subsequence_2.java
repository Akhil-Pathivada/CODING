/*
Given two sequences, find the length of longest subsequence present in both of them. 
A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous.
The Sequences are of length : m,n

(Dynamic Programming - Bottom Up approach)

Time Complexity : O(m*n)

Space Complexity : O(m*n)
*/

class LCS {

	int getLCS(char[] X, char[] Y, int m, int n) {

		int L[][] = new int[m+1][n+1];

		/* Following steps build L[m+1][n+1] in bottom up fashion. Note
         	that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1] */
		for(int i = 0; i <= m; ++i) {

			for(int j = 0; j <= n; ++j) {

				if(i == 0 || j == 0 ) {
					L[i][j] = 0;
				}
				else if(X[i-1] == Y[j-1]) {
					L[i][j] = 1 + L[i-1][j-1];
				}
				else {
					L[i][j] = Math.max(L[i-1][j], L[i][j-1]);
				}
			}
		}
		return L[m][n];
	}

	public static void main(String args[]) {

		LCS obj = new LCS();

		String s1 = "AGGTAB";
		String s2 = "GXTXAYB";

		char[] X = s1.toCharArray();
	       	char[] Y = s2.toCharArray();

		int m = X.length;
		int n = Y.length;

		System.out.println("Length of the Longest Common Subsequence: " + obj.getLCS(X, Y, m, n));
	}
}
