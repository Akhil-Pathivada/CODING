/**
 * Date 11/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/sort-colors/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 */
package misc;

import java.util.Arrays;

public class SortColors {
        
        public void swap(int[] nums, int i, int j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
        }
        
        private void sortColors(int[] nums) {
                int start, mid, end;
                start = mid = 0;
                end = nums.length - 1;
                while (mid <= end) {
                        if (nums[mid] == 0) {
                                swap(nums, start, mid);
                                ++start; ++mid;
                        } else if(nums[mid] == 1) {
                                ++mid;
                        } else if(nums[mid] == 2) {
                                swap(nums, mid, end);
                                --end;
                        }
                }
        }
        
        public static void main(String[] args) {
                int[] nums = { 2, 0, 2, 1, 1, 0 };
                new SortColors().sortColors(nums);
                System.out.println(Arrays.toString(nums));
        }
}
