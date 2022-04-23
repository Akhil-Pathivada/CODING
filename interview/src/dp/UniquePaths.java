/**
 * Date 23/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/unique-paths/
 *
 * Time Complexity : O(m * n)
 * Space Complexity : O(m * n)
 */
package dp;

public class UniquePaths {
        
        private int uniquePaths(int m, int n) {
                int dp[][] = new int[m][n];
                for (int i = 0; i < m; ++i) {
                        for (int j = 0; j < n; ++j) {
                                if (i == 0 || j == 0) {
                                        dp[i][j] = 1;
                                } else {
                                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                                }
                        }
                }
                return dp[m - 1][n - 1];
        }
        
        public static void main(String[] args) {
                int m = 3, n = 7;
                System.out.println(new UniquePaths().uniquePaths(m, n));
        }
}
