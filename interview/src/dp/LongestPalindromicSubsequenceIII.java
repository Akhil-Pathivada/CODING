/**
 * Date 05/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/longest-palindromic-subsequence/
 *
 * Here, we use LCS to find the LPS
 *
 * Time Complexity : O(N ^ 2)
 * Space Complexity : O(N ^ 2)
 *
 */
package dp;

public class LongestPalindromicSubsequenceIII {
        private int LCS(char[] X, char[] Y, int m, int n) {
                int table[][] = new int[m + 1][n + 1];
                for (int i = 0; i <= m; ++i) {
                        for (int j = 0; j <= n; ++j) {
                                if (i == 0 || j == 0) {
                                        table[i][j] = 0;
                                } else if (X[i - 1] == Y[j - 1]) {
                                        table[i][j] = 1 + table[i - 1][j - 1];
                                } else {
                                        table[i][j] = Math.max(table[i - 1][j], table[i][j - 1]);
                                }
                        }
                }
                return table[m][n];
        }
        public static void main(String[] args) {
                String X = "GEEKSFORGEEKS"; // input
                String Y = new StringBuilder(X).reverse().toString();
                System.out.printf("The length of the LPS is = %d ", new LongestPalindromicSubsequenceIII().LCS(X.toCharArray(), Y.toCharArray(), X.length(), Y.length()));
        }
}
