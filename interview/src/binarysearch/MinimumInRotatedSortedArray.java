/**
 * Date 02/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 *
 * Time Complexity : O(log(N))
 * Space Complexity : O(1)
 */
package binarysearch;

public class MinimumInRotatedSortedArray {
        
        private static int findMinimum(int[] nums) {
        
                int n = nums.length;
                // base cases
                if (n == 0) {
                        return 0;
                }
                if(n == 1) {
                        return nums[0];
                }
                int start = 0, end = n - 1;
                // binary search
                while(start < end) {
                        // get the mid
                        int mid = (start + end) / 2;
                        // min element found
                        if(mid > 0 && nums[mid] < nums[mid - 1]) {
                                return nums[mid];
                        }
                        // min exists in right side
                        if(nums[mid] >= nums[start] && nums[mid] > nums[end]) {
                                start = mid + 1;
                        }
                        // min exists in left side
                        else {
                                end = mid - 1;
                        }
                }
                return nums[start];
        }
        
        public static void main(String[] args) {
                
                int nums[] = { 4, 5, 6, 7, 0, 1, 2};
                System.out.printf("Minimum in sorted rotated array = %d ", findMinimum(nums));
        }
}
