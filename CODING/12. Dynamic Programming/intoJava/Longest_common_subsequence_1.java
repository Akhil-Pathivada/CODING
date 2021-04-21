/*
Given two sequences, find the length of longest subsequence present in both of them. 
A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous.
The Sequences are of length : m,n

(Naive approach)

Time Complexity : O( 2^(n+m))

Space Complexity : O(n+m)
*/

class LCS {

	int getLCS(char[] X, char[] Y, int m, int n) {

		if(m == 0 || n == 0 ) {
			return 0;
		}

		if(X[m-1] == Y[n-1]) {
			return 1 + getLCS(X, Y, m-1, n-1);
		}

		return Math.max(getLCS(X, Y, m-1, n), getLCS(X, Y, m, n-1));
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
