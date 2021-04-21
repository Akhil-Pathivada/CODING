/*
Given an unsorted of distinct integers, find the largest pair sum in it. For example, the largest pair sum in {12, 34, 10, 6, 40} is 74

Time Complexity : O(n*logn)
Space Complexity : O(1)
*/
import java.util.*;
class Array
{
	static int maxSumPair( int arr[], int n)
	{
		Arrays.sort(arr);
		
		return arr[n-1] + arr[n-2];
	}
	
	public static void main(String args[])
	{
		int arr[] = {12, 34, 10, 6, 40};
		
		System.out.println("Max. pair sum = " + maxSumPair(arr, arr.length));
	}
}
