/**
 * Date 24/04/2022
 *
 * @author akhilpathivada
 *
 * https://www.geeksforgeeks.org/subset-sum-problem-dp-25/
 *
 * Time Complexity : O(n * sum)
 * Space Complexity : O(n * sum)
 */
package dp;

public class SubsetSumII {
        
        private boolean isSubsetSum(int[] set, int n, int sum) {
                boolean table[][] = new boolean[n + 1][sum + 1];
                // If sum is 0, then answer is true
                for (int i = 0; i <= n; ++i) {
                        table[i][0] = true;
                }
                // If sum is not 0 and set is empty,
                // then answer is false
                for (int i = 1; i <= sum; ++i) {
                        table[0][i] = false;
                }
                for (int i = 1; i <= n; ++i) {
                        for (int j = 1; j <= sum; ++j) {
                                if (set[i - 1] > j) {
                                        table[i][j] = table[i - 1][j];
                                } else {
                                        table[i][j] =  table[i - 1][j - set[i - 1]] || table[i - 1][j];
                                }
                        }
                }
                return table[n][sum];
        }
        
        public static void main(String[] args) {
                int[] set = { 3, 34, 4, 12, 5, 2 };
                int sum = 9;
                System.out.println(new SubsetSumII().isSubsetSum(set, set.length, sum));
        }
}
