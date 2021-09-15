/* 
 * Given an array arr[] consisting of N positive integers, such that arr[i] represents the number of products the ith supplier has and a positive integer, M, the task is to find the maximum profit by selling M products if the profit of a particular product is the same as the number of products left of that supplier.
 *
 * Examples:
 *
 * Input: arr[] = {4, 6}, M = 4
 * Output: 19
 * Explanation:
 * Below are the order of the product sell to gain the maximum profit:
 * Product 1: Sell a product from the second supplier, then the array modifies to {4, 5} and the profit is 6.
 * Product 2: Sell a product from the second supplier, then the array modifies to{4, 4} and the profit is 6 + 5 = 11.
 * Product 3: Sell a product from the second supplier, then the array modifies to {4, 3} and the profit is 6 + 5 + 4 = 15.
 * Product 4: Sell a product from the first supplier, then the array modifies to {3, 3} and the profit is 6 + 5 + 4 + 4 = 19.
 * Therefore, the maximum profit that can be obtained by selling 4 products is 19.
 *
 * Time Complexity : O(M * log(N))
 * Space Complexity : O(N)
 *  */

import java.util.*;

class GFG { 

	private static int findMaximumProfit(int[] arr, int M, int N) {

		int maxProfit = 0;
		// Initialize a Max-Heap to keep track of the maximum value
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

		for(int i = 0; i < N; ++i) {
			
			maxHeap.add(arr[i]);
		}
		while(M > 0) {
			
			int X = maxHeap.poll();

			maxProfit += X;
			maxHeap.add(X - 1);
			--M;
		}
		return maxProfit;
	} 

	public static void main(String[] args) {

		int[] arr = { 4, 6 };
		int M = 4;
		int N = arr.length;

		System.out.println("Max. Profit : " + findMaximumProfit(arr, M, N));
	}
}
