/**
 * Date 25/04/2022
 *
 * @author akhilpathivada
 *
 * https://www.geeksforgeeks.org/partition-problem-dp-18/
 *
 * Time Complexity : O(m * n)
 * Space Complexity : O(m * n)
 */
package dp;

public class PartitionProblemII {
        
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
        
        private boolean findPartition(int[] nums) {
                int sum = 0;
                for (int num : nums) {
                        sum += num;
                }
                if (sum % 2 != 0) {
                        return false;
                }
                return isSubsetSum(nums, nums.length, sum % 2);
        }
        
        public static void main(String[] args) {
                int nums[] = { 3, 1, 5, 9, 12 };
                System.out.println(new PartitionProblemII().findPartition(nums));
        }
}
