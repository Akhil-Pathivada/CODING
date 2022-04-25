/**
 * Date 25/04/2022
 *
 * @author akhilpathivada
 *
 * https://www.geeksforgeeks.org/partition-problem-dp-18/
 *
 */
package dp;

public class PartitionProblemI {
        
        private boolean isSubsetSum(int[] set, int n, int sum) {
                // base cases
                if (sum == 0) {
                        return true;
                }
                if (n == 0) {
                        return false;
                }
                if (set[n - 1] > sum) {
                        return isSubsetSum(set, n - 1, sum);
                }
                return isSubsetSum(set, n - 1, sum - set[n - 1])
                        || isSubsetSum(set, n - 1, sum);
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
                System.out.println(new PartitionProblemI().findPartition(nums));
        }
}
