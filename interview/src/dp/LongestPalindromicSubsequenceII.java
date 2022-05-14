/**
 * https://leetcode.com/problems/longest-palindromic-subsequence/
 *
 * Time Complexity : O(N ^ 2)
 * Space Complexity : O(N ^ 2)
 * */
package dp;

public class LongestPalindromicSubsequenceII {
        private int LPS(String s, int n) {
                int[][] table = new int[n][n]; // table to store the sub problems result
                for (int i = n - 1; i >= 0; --i) {
                        table[i][i] = 1; // string of length 1 is always a palindrome
                        for (int j = i + 1; j < n; ++j) {
                                // palindrome
                                if (s.charAt(i) == s.charAt(j)) {
                                        table[i][j] = table[i + 1][j - 1] + 2;
                                } else {
                                        table[i][j] = Math.max(table[i + 1][j], table[i][j - 1]);
                                }
                        }
                }
                return table[0][n - 1];
        }
        public static void main(String[] args) {
                String str = "GEEKSFORGEEKS";
                int n = str.length();
                System.out.printf("The length of the LPS is %d", new LongestPalindromicSubsequenceII().LPS(str, n));
        }
}
