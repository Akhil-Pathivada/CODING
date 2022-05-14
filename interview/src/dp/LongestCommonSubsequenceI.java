/**
 * Date 29/03/2022
 *
 * @author akhilpathivada
 *
 *
 *
 * Time Complexity : O(2 ^ (m + n))
 * Space Complexity : O(m + n)
 *
 * Given two sequences, find the length of longest subsequence present in both of them.
 * A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous.
 * The Sequences are of length : m, n
 *
 */
package dp;

public class LongestCommonSubsequenceI {
        private int LCS(char[] X, char[] Y, int m, int n) {
                if (m == 0 || n == 0) {
                        return 0;
                }
                if (X[m - 1] == Y[n - 1]) {
                        return 1 + LCS(X, Y, m - 1, n - 1);
                }
                return Math.max(LCS(X, Y, m, n - 1), LCS(X, Y, m - 1, n));
        }
        public static void main(String[] args) {
                String X = "AGGTAB";
                String Y = "GXTXAYB";
                System.out.printf("Longest Common Subsequence = %d ", new LongestCommonSubsequenceI().LCS(X.toCharArray(), Y.toCharArray(), X.length(), Y.length()));
        }
}
