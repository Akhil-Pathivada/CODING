/**
 * Date 09/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/search-insert-position/
 *
 * Time Complexity : O(log(N))
 * Space Complexity : O(1)
 */
package dac.binarysearch;

public class SearchInsertPosition {
        private static int searchInsert(int[] nums, int target) {
                int start = 0;
                int end = nums.length - 1;
                while (start <= end) {
                        int mid = (start + end) / 2;
                        if ( mid > 0 && nums[mid] >= target && nums[mid - 1] < target) {
                                return mid;
                        } else if(mid == 0 && nums[mid] >= target) {
                                return mid;
                        }
                        if (nums[mid] < target) {
                                start = mid + 1;
                        } else {
                                end = mid;
                        }
                }
                return nums.length;
        }
        public static void main(String[] args) {
                
                int[] nums = { 1, 3, 5, 6};
                int target = 7;
                System.out.println(searchInsert(nums, target));
        }
}
