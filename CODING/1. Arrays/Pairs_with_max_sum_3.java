/*
Given an unsorted of distinct integers, find the largest pair sum in it. For example, the largest pair sum in {12, 34, 10, 6, 40} is 74

Time Complexity : O(n)
Space Complexity : O(1)
*/
class Array
{
	static int maxSumPair( int arr[], int n)
	{	
		int firstMax = Math.max(arr[0], arr[1]);
		
		int secondMax = Math.min(arr[0], arr[1]);
		
		for(int i=2; i<n; ++i)
		{
			if(arr[i] > firstMax)
			{
				secondMax = firstMax;
				
				firstMax = arr[i];
			}
			
			else if(arr[i] > secondMax)
				secondMax = arr[i];
		}
		
		return firstMax + secondMax;
	}
	
	public static void main(String args[])
	{
		int arr[] = {12, 34, 10, 6, 40};
		
		System.out.println("Max. pair sum = " + maxSumPair(arr, arr.length));
	}
}
