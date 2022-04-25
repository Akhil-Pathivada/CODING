/**
 * Date 25/04/2022
 *
 * @author akhilpathivada
 *
 * https://www.geeksforgeeks.org/min-cost-path-dp-6/
 *
 * Time Complexity : O(m * n)
 * Space Complexity : O(m * n)
 *
 */
package dp;

public class MinCostPath {
        
        private int minCost(int[][] cost, int m, int n) {
                int[][] mc = new int[m][n];
                int i, j;
                mc[0][0] = cost[0][0];
                for (i = 1; i < m; ++i) {
                        mc[i][0] = cost[i - 1][0] + cost[i][0];
                }
                for (j = 1; j < n; ++j) {
                        mc[0][j] = cost[0][j - 1] + cost[0][j];
                }
                for (i = 1; i < m; ++i) {
                        for (j = 1; j < n; ++j) {
                                mc[i][j] = Math.min(mc[i - 1][j - 1],
                                        Math.min(mc[i - 1][j], mc[i][j - 1])) + cost[i][j];
                        }
                }
                return mc[m - 1][n - 1];
        }
        
        public static void main(String[] args) {
                int cost[][]= {
                        { 1, 2, 3 },
                        { 4, 8, 2 },
                        { 1, 5, 3 }
                };
                System.out.println(new MinCostPath().minCost(cost, 2, 2));
        }
}
