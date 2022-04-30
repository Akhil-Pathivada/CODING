/**
 * Date 29/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/
 *
 * Time Complexity : O(m * n)
 * Space Complexity : O(m * n)
 *
 */
package dp;

public class MinimumInsertionsToMakeStringPalindrome {
        
        private int LPS(String s) {
                int n = s.length();
                int[][] table = new int[n][n];
                for (int i = n - 2; i >= 0; --i) {
                        table[i][i] = 1;
                        for (int j = i + 1; j < n; ++j) {
                                if (s.charAt(i) == s.charAt(j)) {
                                        table[i][j] = 2 + table[i + 1][j - 1];
                                } else {
                                        table[i][j] = Math.max(table[i + 1][j], table[i][j - 1]);
                                }
                        }
                }
                return table[0][n - 1];
        }
        
        private int minInsertions(String s) {
                return (s.length() == 1) ? 0 : s.length() - LPS(s);
        }
        
        public static void main(String[] args) {
                String s = "mbadm";
                System.out.println(new MinimumInsertionsToMakeStringPalindrome().minInsertions(s));
        }
}
