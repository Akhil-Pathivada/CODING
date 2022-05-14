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
 *
 * Space Complexity : O(n)
 */
package dp;

public class LongestCommonSubsequenceIII {
        private int LCS(char[] X, char[] Y, int m, int n) {
                int table[][] = new int[m + 1][n + 1];
                int bi = 0;
                for (int i = 0; i <= m; ++i) {
                        bi = i & 1;
                        for (int j = 0; j <= n; ++j) {
                                if (i == 0 || j == 0) {
                                        table[bi][j] = 0;
                                } else if(X[i - 1] == Y[j - 1]) {
                                        table[bi][j] = 1 + table[1 - bi][j - 1];
                                } else {
                                        table[bi][j] = Math.max(table[1 - bi][j], table[bi][j - 1]);
                                }
                        }
                }
                return table[bi][n];
        }
        public static void main(String[] args) {
                String X = "AGGTAB";
                String Y = "GXTXAYB";
                System.out.printf("Longest Common Subsequence = %d ", new LongestCommonSubsequenceIII().LCS(X.toCharArray(), Y.toCharArray(), X.length(), Y.length()));
        }
}
