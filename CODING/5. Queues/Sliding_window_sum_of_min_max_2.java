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
 * Time Complexity : O(N)
 * Space Complexity: O(K)
 *
 *  */

import java.util.*;

class GFG { 

	static int sumOfKMinMax(int arr[], int n, int k) {

		int sum = 0;

		Deque<Integer> S = new LinkedList<>(), G = new LinkedList<>();

		int i;

		for(i = 0; i < k; ++i) {

			while(!S.isEmpty() && arr[S.peekLast()] >= arr[i]) {

				S.removeLast();
			}
			while(!G.isEmpty() && arr[G.peekLast()] <= arr[i]) {

				G.removeLast();
			}
			S.addLast(i);
			G.addLast(i);
		}
		
		for( ; i < n; ++i) {

			sum += arr[S.peekFirst()] + arr[G.peekFirst()];

			while(!S.isEmpty() && S.peekFirst() <= i-k) {

				S.removeFirst();
			}
			while(!G.isEmpty() && G.peekFirst() <= i-k) {

				G.removeFirst();
			}
			while(!S.isEmpty() && arr[S.peekLast()] >= arr[i]) {

				S.removeLast();
			}
			while(!G.isEmpty() && arr[G.peekLast()] <= arr[i]) {

				G.removeLast();
			}
			S.addLast(i);
			G.addLast(i);
		}
		sum += arr[S.peekFirst()] + arr[G.peekFirst()];

		return sum;
	}

	public static void main(String args[]) {

		int arr[] = {2, 5, -1, 7, -3, -1, -2} ;
		int k = 3;

		System.out.println(sumOfKMinMax(arr, arr.length, k));
	}	
}
