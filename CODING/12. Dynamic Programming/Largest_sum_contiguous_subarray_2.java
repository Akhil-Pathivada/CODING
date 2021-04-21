/* 
 * Write an efficient program to find the sum of contiguous subarray within a one-dimensional array of numbers that has the largest sum.
 *
 * The implementation handles the case when all numbers in array are negative.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *  */

import java.util.*;

class Kadane {

	private int maxSubArraySum(int arr[]) {

		int size = arr.length;

		int max_sum_so_far = arr[0],
		curr_max = arr[0];

		for(int i = 1; i < size; ++i) {

			curr_max = Math.max(arr[i], curr_max + arr[i]);
			max_sum_so_far = Math.max(max_sum_so_far, curr_max);
		}

		return max_sum_so_far;
	}

	public static void main(String args[]) {

		int arr[] = { -2, -3, 4, -1, -2, 1, 5, -3};
		Kadane obj = new Kadane();
		System.out.println("Maximum contiguous sum is " + obj.maxSubArraySum(arr));
	}
}
