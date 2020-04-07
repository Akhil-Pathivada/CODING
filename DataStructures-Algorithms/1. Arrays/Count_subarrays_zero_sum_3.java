/*
Count number of SubArrays possible with sum Zero.....

Time Complexity : O(n)
Space Complexity :O(n)
*/

import java.util.*;

class Array
{
	static int countSubArrays(int arr[])
	{
		int n = arr.length;
		
		int count = 0;
		
		int sum = 0;
		
		HashSet<Integer> hashSet = new HashSet<Integer>();
		
		for(int i=0; i<n; ++i)
		{
			sum += arr[i];
			
			if(arr[i]==0 || sum==0 || hashSet.contains(sum))
				++count;
			
			hashSet.add(sum);
		}	
		
		return count;
	}
	
	public static void main(String args[])
	{
		
		int arr[] = {11, 10, -5, -3, -2, 10, 7, -1, -6};

		System.out.println(" Total SubArrays : " + countSubArrays(arr));
	}
}
