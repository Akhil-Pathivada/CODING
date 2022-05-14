/**
 * Date 22/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/product-of-array-except-self/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 */
package array;

import java.util.Arrays;

public class ProductOfArrayExceptSelfII {
        private int[] productExceptSelf(int[] nums) {
                int n = nums.length;
                int[] result = new int[n];
                Arrays.fill(result, 1);
                for (int i = 1; i < n; ++i) {
                        result[i] = result[i - 1] * nums[i - 1];
                }
                int right = 1;
                for (int i = n - 1; i >= 0; --i) {
                        result[i] *= right;
                        right *= nums[i];
                }
                return result;
        }
        public static void main(String[] args) {
                int nums[] = { 1, 2, 3, 4 };
                System.out.println(Arrays.toString(new ProductOfArrayExceptSelfII().productExceptSelf(nums)));
        }
}
