/*
Given an unsorted array of integers, find the number of subarrays having sum exactly equal to a given number k.

Time Complexity : O(n)
Space Complexity : O(n)
*/

import java.util.*;

class Array
{
	static int countSubArrays( int arr[], int n, int target)
	{
		HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		
		int curr_sum = 0;
		
		int res = 0;
		
		for(int i=0; i<n; ++i)
		{
			curr_sum += arr[i];
			
			if(curr_sum == target)
				++res;
			
			if(hashMap.containsKey(curr_sum - target))
				res += hashMap.get(curr_sum - target);
			
			Integer count = hashMap.get(curr_sum);
			
			if(count == null)
				hashMap.put(curr_sum, 1);
			else
				hashMap.put(curr_sum, count+1);
		}
		
		return res;
	}
	
	public static void main(String args[])
	{
		int arr[] = {10, 2, -2, -20, 10 };
		
		int n = arr.length;
		
		int sum = -10;
		
		System.out.println("Total SubArrays = " + countSubArrays(arr, n, sum));
	}
}
