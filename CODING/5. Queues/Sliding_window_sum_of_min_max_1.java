/* Given an array of both positive and negative integers, the task is to compute sum of minimum and maximum elements of all sub-array of size k.
 * Examples:
 *
 *
 * Input : arr[] = {2, 5, -1, 7, -3, -1, -2}
 *         K = 4
 * Output : 18
 * Explanation : Subarrays of size 4 are :
 *      {2, 5, -1, 7},   min + max = -1 + 7 = 6
 *      {5, -1, 7, -3},  min + max = -3 + 7 = 4
 *      {-1, 7, -3, -1}, min + max = -3 + 7 = 4
 *      {7, -3, -1, -2}, min + max = -3 + 7 = 4
 *      Sum of all min & max = 6 + 4 + 4 + 4
 *                           = 18
 *
 * Time Complexity : O(N * K)
 * Space Complexity: O(1)
 *
 *  */

import java.util.*;

class GFG { 

	static int sumOfKMinMax(int arr[], int n, int k) {

		int j, max, min;
		int resultSum = 0;

		for (int i = 0; i <= n - k; i++) {

		    min = max = arr[i];

		    for(j = 1; j < k; j++) {

			if(arr[i + j] < min) {
			
			    	min = arr[i + j];
		    	}
			if(arr[i + j] > max) {
			
			    	max = arr[i + j];
		    	}
		    }
		    resultSum += min + max;
		}
		return resultSum;
	}

	public static void main(String args[]) {

		int arr[] = {2, 5, -1, 7, -3, -1, -2} ;
		int k = 3;

		System.out.println(sumOfKMinMax(arr, arr.length, k));
	}	
}
