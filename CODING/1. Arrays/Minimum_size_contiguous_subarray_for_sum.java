/*
Given an array of positive integers nums and a positive integer target, return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target. If there is no such subarray, return 0 instead.

 

Example 1:

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
Example 2:

Input: target = 4, nums = [1,4,4]
Output: 1

*/

class GFG {

	static int minSubArrayLength(int[] nums, int target) {

        	if(nums == null  || nums.length == 0) {
            		return 0;
        	}

        	int i = 0, j = 0; // start and end indexes of result window        
        	int sum = 0;
        	int minLen = Integer.MAX_VALUE;
        
        	while(j < nums.length) {
            
            		sum += nums[j++];
            
            		while(sum >= target) {
                
                		minLen = Math.min(minLen, j - i);
                		sum -= nums[i++];
            		}
        	}
        	return minLen == Integer.MAX_VALUE ? 0 : minLen;
	}

	public static void main(String[] args) {

		int[] nums = {2, 3, 1, 2, 4, 3};
		int target = 7;

		System.out.println("Min. Length of contiguous subarray which equals to sum = " + minSubArrayLength(nums, target));
	}
}