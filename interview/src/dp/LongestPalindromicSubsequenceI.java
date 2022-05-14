/**
 * https://leetcode.com/problems/longest-palindromic-subsequence/
 *
 * Time Complexity : O(2 ^ N)
 * Space Complexity : O(N)
 * */
package dp;

public class LongestPalindromicSubsequenceI {
        private int LPS(char[] str, int start, int end) {
                // base case
                if (start > end) {
                        return 0;
                }
                // If there is only 1 character
                if (start == end) {
                        return 1;
                }
                // If the first and last characters match
                if (str[start] == str[end]) {
                        return 2 + LPS(str, start + 1, end - 1);
                }
                // If the first and last characters do not match
                return Math.max(LPS(str, start + 1, end), LPS(str, start, end - 1));
        }
        public static void main(String[] args) {
                String str = "GEEKSFORGEEKS";
                int n = str.length();
                System.out.printf("The length of the LPS is %d", new LongestPalindromicSubsequenceI().LPS(str.toCharArray(), 0, n - 1));
        }
}
