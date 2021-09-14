/* 
 * Given k sorted arrays of size n each, merge them and print the sorted output.
 *
 * Example:
 *
 * Input:
 * k = 3, n = 4
 * arr[][] = { {1, 3, 5, 7},
 * {2, 4, 6, 8},
 * {0, 9, 10, 11}} ;
 * Output: 0 1 2 3 4 5 6 7 8 9 10 11
 * Explanation: The output array is a sorted array that contains all the elements of the input matrix.
 *
 * Time Complexity: O(N * K * (log(N * K)))
 * Space Complexity: O(N * K)
 *
 *  */

import java.util.*;

class GFG {

	private static void mergeKArrays(int[][] arr, int[] output, int n, int k) {

		int c = 0;

		for(int i = 0; i < n; ++i) {

			for(int j = 0; j < k; ++j) {

				output[c++] = arr[i][j];
			}
		}
		Arrays.sort(output);
	}

	private static void printArray(int[] arr, int size) {

		for(int i = 0; i < size; ++i) {

		    System.out.print(arr[i] + " "); 
		}
	}

	public static void main(String args[]) {

		int[][] arr = { { 2, 6, 12, 34 },
				{ 1, 9, 20, 1000 },
				{ 23, 34, 90, 2000 } };
		int k = 4;
		int n = 3;
		int[] output = new int[n * k];
	 
		mergeKArrays(arr, output, n, k);
	 
		System.out.println("Merged array is ");
		printArray(output, n * k);		
	}
}
