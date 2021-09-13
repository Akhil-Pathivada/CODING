/*
Given an array and an integer K, find the maximum for each and every contiguous subarray of size k.

Time Complexity : O(N)
Space Complexity : O(K)
*/

import java.util.*;

class GFG { 

	static void printMax(int arr[], int n, int k) {

		Deque<Integer> deque = new LinkedList<Integer>();

		int i;

		for(i = 0; i < k; ++i) {

			while(!deque.isEmpty() && arr[i] >= arr[deque.peekLast()]) {

				deque.removeLast();
			}
			deque.addLast(i);
		}

		for( ; i < n; ++i) {

			System.out.print(arr[deque.peek()] + ", ");

			while(!deque.isEmpty() && deque.peek() <= i-k) {

				deque.removeFirst();
			}

			while(!deque.isEmpty() && arr[i] >= arr[deque.peekLast()]) {

				deque.removeLast();
			}
			deque.addLast(i);
		}
		System.out.print(arr[deque.peek()] + ", ");
	}

	public static void main(String[] args) {

		int arr[] = { 12, 1, 78, 90, 57, 89, 56 };
		int k = 3;

		printMax(arr, arr.length, k);		
	}
}
