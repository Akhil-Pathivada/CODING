/**
 * Date 13/04/2022
 *
 * @author akhilpathivada
 *
 * https://www.geeksforgeeks.org/longest-common-substring-dp-29/
 *
 * Time Complexity : O(2 ^ (m + n))
 * Space Complexity : O(m + n)
 */
package dp;

public class LongestCommonSubstringI {
        
        private int LCS(char[] X, char[] Y, int m, int n, int count) {
                // base case
                if(m == 0 || n == 0) {
                        return count;
                }
                // characters on both strings matches
                // so capture count including from this point
                if(X[m - 1] == Y[n - 1]) {
                        count = LCS(X, Y, m - 1, n -1 , count + 1);
                }
                // even if characters on both strings matches
                // check without including the current characters will give big results or not
                count = Math.max(count,
                        Math.max(LCS(X, Y, m - 1, n, 0), LCS(X, Y, m , n - 1, 0))
                );
                return count;
        }
        
        public static void main(String[] args) {
                String X = "abcdxyz";
                String Y = "xyzabcd";
                System.out.println(new LongestCommonSubstringI().LCS(X.toCharArray(), Y.toCharArray(), X.length(), Y.length(), 0));
        }
}
