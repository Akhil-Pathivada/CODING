/**
 * Date 29/03/2022
 *
 * @author akhilpathivada
 *
 * Given two sequences, find the length of longest subsequence present in both of them.
 * A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous.
 * The Sequences are of length : m, n
 *
 * Time Complexity : O(m * n)
 * Space Complexity : O(m * n)
 */
package dp;

public class LongestCommonSubsequenceII {
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
                String X = "AGGTAB";
                String Y = "GXTXAYB";
                System.out.printf("Longest Common Subsequence = %d ", new LongestCommonSubsequenceII().LCS(X.toCharArray(), Y.toCharArray(), X.length(), Y.length()));
        }
}
