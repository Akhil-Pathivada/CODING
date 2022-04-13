/**
 * Date 11/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/is-subsequence/
 *
 * Time Complexity : O(2 ^ (m))
 * Space Complexity : O(m)
 */
package dp;

public class IsSubsequenceI {
        
        private static boolean isSubsequence(char[] s, char[] t, int m, int n) {
                if(m == 0) {
                        return true;
                }
                if(n == 0) {
                        return false;
                }
                if(s[m - 1] == t[n - 1]) {
                        return isSubsequence(s, t, m - 1, n - 1);
                }
                return isSubsequence(s, t, m, n - 1);
        }
        
        public static void main(String[] args) {
                String s ="abc", t = "ahbgdc";
                System.out.println(isSubsequence(s.toCharArray(), t.toCharArray(), s.length(), t.length()));
        }
}
