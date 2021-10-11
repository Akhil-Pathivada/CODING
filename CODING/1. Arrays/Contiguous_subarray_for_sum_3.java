/*
Given an unsorted array of integers, find a continous subarray which adds to a given number. 
(Handles Negative Numbers)

Time Complexity : O(n)
Space Complexity : O(n)
*/

import java.util.*;

class Array {

	static void findSubArray(int arr[], int n, int target) {

		HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		
		int start = 0;
		int end = -1;
		int curr_sum = 0;
		
		for(int i = 0; i < n; ++i) {

			curr_sum += arr[i];
			
			if(curr_sum - target == 0) {

				start = 0;
				end = i;
				break;
			}
			
			if(hashMap.containsKey(curr_sum - target)) {

				start = hashMap.get(curr_sum - target) + 1;
				end = i;
				break;
			}
			hashMap.put(curr_sum, i);
		}
		
		if(end == -1) {
			System.out.println("SubArray does not exists");
		}
		else {
			System.out.println("SubArray exists between "+ start + " and " + end);
		}
	}
	
	public static void main(String args[]) {

		int arr[] = {1, 5, 20, 3, 10, 4};
		int n = arr.length;
		int sum = 33;
		
		findSubArray(arr, n, sum);
	}
}
