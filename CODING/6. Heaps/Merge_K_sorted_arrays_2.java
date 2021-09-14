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
 * Time Complexity: O(N * K * log(K))
 * Space Complexity: O(N * K)
 *
 *  */

import java.util.*;

class MinHeapNode implements Comparable<MinHeapNode> {
	
	int[] arr; // stores address of array
	int index; // stores index of an array element 
	
	public MinHeapNode(int[] arr, int index) {
		
		this.arr = arr;
		this.index = index;
	}

	@Override
	public int compareTo(MinHeapNode o) {

		return this.arr[this.index] - o.arr[o.index]; 
	}
}

class GFG {

	private static void mergeKArrays(int[][] arr, int[] output, int n, int k) {

		PriorityQueue<MinHeapNode> queue = new PriorityQueue<MinHeapNode>();

		for(int i = 0; i < n; ++i) {
			// inserting first elements of all arrays
			queue.add(new MinHeapNode(arr[i], 0));
		}

		int i = 0;
		while(!queue.isEmpty()) {
			
			MinHeapNode node = queue.poll();
			output[i++] = node.arr[node.index];

			if(node.index < node.arr.length - 1) {

				queue.add(new MinHeapNode(node.arr, node.index + 1));
			}
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
	 
		System.out.println("Merged array is " + Arrays.toString(output));
	}
}
