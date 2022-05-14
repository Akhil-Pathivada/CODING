/**
 * Date 29/03/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/find-pivot-index/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 */
package array;

public class FindPivotIndex {
        private int findPivotIndex(int[] nums) {
                int n = nums.length, sum = 0, leftSum = 0;
                // compute total sum of array
                for (int i = 0; i < n; ++i) {
                        sum += nums[i];
                }
                for (int i = 0; i < n; ++i){
                        sum -= nums[i];
                        if(leftSum == sum){ // found
                                return i;
                        }
                        leftSum += nums[i];
                }
                return -1;
        }
        public static void main(String[] args) {
                int[] nums = { 1, 7, 3, 6, 5, 6 };
                System.out.printf("Pivot Index = %d ", new FindPivotIndex().findPivotIndex(nums));
        }
}
