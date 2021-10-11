/*
Given an array containing only 0s and 1s, find the largest subarray which contain equal no of 0s and 1s.

Time Complexity : O(n)
Space Complexity : O(n)
*/

import java.util.*;

class GFG { 

	private static void maxLength(int[] arr, int n) {

		HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

		// make all 0s to -1
		for(int i = 0; i < n; ++i) {
			if(arr[i] == 0) {
				arr[i] = -1;
			} 
		}

		int currSum = 0;
		int maxLen = 0;
		int end = -1; // indexes 
		for(int i = 0; i < n; ++i) {

			currSum += arr[i];
			// To handle sum=0 at last index
			if(currSum == 0) {
				
				maxLen = i + 1;
				end = i;
			}

			if(hashMap.containsKey(currSum)) {

				if(maxLen < i - hashMap.get(currSum)) {

					maxLen = i - hashMap.get(currSum);
					end = i;
				}
			}
			else {
				hashMap.put(currSum, i);
			}
		}
		// make all -1s to 0
		for(int i = 0; i < n; ++i) {
			if(arr[i] == -1) {
				arr[i] = 0;
			} 
		}
		int start = end - maxLen + 1;
		System.out.println(start + " to " + end);
	}

	public static void main(String[] args) {

		int arr[] = { 1, 0, 0, 1, 0, 1, 1 };
		int n = arr.length;

		maxLength(arr, n);
	}
}