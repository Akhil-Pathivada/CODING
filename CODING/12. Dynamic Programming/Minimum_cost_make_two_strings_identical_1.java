/*
Given two strings X and Y, and two values costX and costY. 
We need to find minimum cost required to make the given two strings identical. 
We can delete characters from both the strings. The cost of deleting a character from string X is costX and from Y is costY. 
Cost of removing all characters from a string is same. 

Input :  X = "abcd", Y = "acdb", costX = 10, costY = 20.
Output:  30
For Making both strings identical we have to delete 
character 'b' from both the string, hence cost will
be = 10 + 20 = 30.

Use LCS and compute cost result
Time Complexity : O(m * n)
Space Complexity : O(m* n)
*/

class GFG {

	private static int LCS(String X, String Y, int m, int n) {

		int L[][] = new int[m + 1][n + 1];

		for(int i = 0; i <= m; ++i) {

			for(int j = 0; j <= n; ++j) {

				if(i == 0 || j == 0) {
					L[i][j] = 0;
				}
				else if(X.charAt(i - 1) == Y.charAt(j - 1)) {
					L[i][j] = 1 + L[i - 1][j - 1];
				}
				else {
					L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
				}
			}
		}
		return L[m][n];
	}

	private static int findMinCost(String X, String Y, int costX, int costY) {

		int m = X.length();
		int n = Y.length();

		int length_of_LCS = LCS(X, Y, m, n);

		return (m - length_of_LCS) * costX + 
		       (n - length_of_LCS) * costY;
	}

	public static void main(String[] args) {
		
		String X = "abcd";
		String Y = "acdb";
		int costX = 10;
		int costY = 20;

		System.out.println("Minimum Cost to make two strings identical is = " + findMinCost(X, Y, costX, costY));
	}
}
