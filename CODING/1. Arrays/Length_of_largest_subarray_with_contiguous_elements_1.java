/* 
 * Given an array of distinct integers, find length of the longest subarray
 * which contains numbers that can be arranged in a continuous sequence.
 *
 * https://www.geeksforgeeks.org/length-largest-subarray-contiguous-elements-set-1/
 *
 * Examples:
 *
 * Input:  arr[] = {10, 12, 11};
 * Output: Length of the longest contiguous subarray is 3
 *
 * Input:  arr[] = {14, 12, 11, 20};
 * Output: Length of the longest contiguous subarray is 2
 *
 * Time Complexity: O(N ^ 2)
 * Space Complexity: O(1)
 *  */

import java.util.*;

class Array {

	// Returns length of the longest contiguous subarray
	private int findContiguousSubArrayLength(int arr[], int n) {
		
		int maxLength = 1;

		for(int i = 0; i < n - 1; ++i) {

			int min = arr[i], max = arr[i];

			for(int j = i + 1; j < n; ++j) {

				min = Math.min(min, arr[j]);
				max = Math.max(max, arr[j]);

				if((max - min) == j - i) {
					maxLength = Math.max(maxLength, max - min + 1);
				}
			}
		}		
		return maxLength;
	}

	public static void main(String args[]) {

		int arr[] = {1, 56, 58, 57, 90, 92, 94, 93, 91, 45};
		int n = arr.length;

		Array obj = new Array(); 

		System.out.println("Length of the longest contiguous subarray is: " + obj.findContiguousSubArrayLength(arr, n));
	}
}
