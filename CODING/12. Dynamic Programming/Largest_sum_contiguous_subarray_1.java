/* 
 * Write an efficient program to find the sum of contiguous subarray within a one-dimensional array of numbers that has the largest sum.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *  */

import java.util.*;

class Kadane {

	private int maxSubArraySum(int arr[]) {

		int size = arr.length;

		int max_sum_so_far = Integer.MIN_VALUE,
		curr_sum = 0, start = 0, end = 0, newStart = 0;

		for(int i = 0; i < size; ++i) {

			curr_sum += arr[i];

			if(curr_sum > max_sum_so_far) {
				max_sum_so_far = curr_sum;
				start = newStart;
				end = i;
			}

			if(curr_sum < 0) {
				curr_sum = 0;
				newStart = i + 1;
			}
		}

		System.out.println("Start && End Indexes of Max. SubArray: " + start + ", " + end);

		return max_sum_so_far;
	}

	public static void main(String args[]) {

		int arr[] = { -2, -3, 4, -1, -2, 1, 5, -3};
		Kadane obj = new Kadane();
		System.out.println("Maximum contiguous sum is " + obj.maxSubArraySum(arr));
	}
}
