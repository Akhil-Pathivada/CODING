/**
 * Date 01/05/2022
 *
 * @author akhilpathivada
 *
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 */
package misc;

public class MaxConsecutiveOnes {
        
        private int findMaxConsecutiveOnes(int[] nums) {
                int count = 0, result = 0;
                for (int i = 0; i < nums.length; ++i) {
                        if (nums[i] == 1) {
                                ++count;
                                result = Math.max(result, count);
                        } else {
                                count = 0;
                        }
                }
                return result;
        }
        
        public static void main(String[] args) {
                int[] nums = { 1, 1, 0, 1, 1, 1 };
                System.out.println(new MaxConsecutiveOnes().findMaxConsecutiveOnes(nums));
        }
}
