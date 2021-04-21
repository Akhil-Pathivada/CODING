/*
Given an array of size n and an integer k, return the of count of distinct numbers in all windows of size k. 

Time Complexity : O(N)
Space Complexity : O(N)
*/
import java.util.*;

class Array
{
	static void countDistincts(int arr[], int k)
	{
		int n = arr.length;
		
		int distCount = 0;
		
		HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		
		// for the first k elements
		for(int i=0; i<k; ++i)
		{
			if(hashMap.get(arr[i]) == null)
			{
				hashMap.put(arr[i], 1);
					
				distCount++;
			}
			else
			{
				int count = hashMap.get(arr[i]);
					
				hashMap.put(arr[i], count+1);
			}
		}
		
		System.out.print(distCount + " ");		
		
		// for the remaining elements
		for(int i=k; i<n; ++i)
		{
			if(hashMap.get(arr[i-k]) == 1)
			{
				hashMap.remove(arr[i-k]);
				
				distCount--;
			}
			else
			{
				int count = hashMap.get(arr[i-k]);
				
				hashMap.put(arr[i-k], count-1);
			}
			
			if(hashMap.get(arr[i]) == null)
			{
				hashMap.put(arr[i], 1);
					
				distCount++;
			}
			else
			{
				int count = hashMap.get(arr[i]);
					
				hashMap.put(arr[i], count+1);
			}
			
			System.out.print(distCount + " ");
		}
	}
	
	public static void main(String args[])
	{
		int arr[] = {1,2,1,4,4,3,3,4,1,8,1};
		
		int k = 4;
		
		countDistincts(arr, k);
	}
}
