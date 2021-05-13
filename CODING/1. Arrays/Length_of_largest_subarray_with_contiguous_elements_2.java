/* 
 * Given an array of integers, find length of the longest subarray which contains numbers that can be arranged in a continuous sequence.
 * In the previous post, we have discussed a solution that assumes that elements in given array are distinct.
 * Here we discuss a solution that works even if the input array has duplicates.
 *
 * https://www.geeksforgeeks.org/length-largest-subarray-contiguous-elements-set-2/
 *
 * Examples:
 *
 * Input:  arr[] = {10, 12, 11};
 * Output: Length of the longest contiguous subarray is 3
 *
 * Input:  arr[] = {10, 12, 12, 10, 10, 11, 10};
 * Output: Length of the longest contiguous subarray is 2
 *
 * Time Complexity: O(N ^ 2)
 * Space Complexity: O(N)
 *  */

import java.util.*;

class Array {

	// Returns length of the longest contiguous subarray
	private int findContiguousSubArrayLength(int arr[], int n) {
		
		int maxLength = 1;

		for(int i = 0; i < n - 1; ++i) {

			HashSet<Integer> set = new HashSet<>();
			set.add(arr[i]);

			int min = arr[i], max = arr[i];

			for(int j = i + 1; j < n; ++j) {

				if(set.contains(arr[j])) {
					break;
				}
				set.add(arr[j]);
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

		int arr[] = {10, 12, 12, 10, 10, 11, 10};
		int n = arr.length;

		Array obj = new Array(); 

		System.out.println("Length of the longest contiguous subarray is: " + obj.findContiguousSubArrayLength(arr, n));
	}
}
