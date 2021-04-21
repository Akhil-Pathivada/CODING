/*
Given an array and an integer K, find the maximum for each and every contiguous subarray of size k.

Time Complexity : O(n)
Space Complexity : O(k)
*/
import java.util.*;

class Maximer
{
	static void printMax( int arr[], int n, int k)
	{
		Deque<Integer> queue = new LinkedList<Integer>();
		
		int i;
		
		for(i=0; i<k; ++i)
		{
			while(!queue.isEmpty() && arr[i] >= arr[queue.peekLast()])
				queue.removeLast();
			
			queue.add(i);
		}
		
		for(i=k; i<n; ++i)
		{
			System.out.print(arr[queue.peek()] + " ");
			
			while(!queue.isEmpty() && queue.peek() <= i-k)
				queue.removeFirst();
			
			while(!queue.isEmpty() && arr[i] >= arr[queue.peekLast()])
				queue.removeLast();
			
			queue.add(i);	
		}
		
		System.out.print(arr[queue.peek()] + " ");
	}
	
	public static void main(String args[])
	{
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }; 
		
		int n = arr.length;
		
		int k = 3;
		
		printMax(arr, n, k);
	}
}
