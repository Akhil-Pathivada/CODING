/*
Given an unsorted of distinct integers, find the largest pair sum in it. For example, the largest pair sum in {12, 34, 10, 6, 40} is 74

Time Complexity : O(n^2)
Space Complexity : O(1)
*/
class Array
{
	static int maxSumPair( int arr[], int n)
	{
		int max = 0;
		
		for(int i=0; i<n; ++i)
		{
			for(int j=i+1; j<n; ++j)
			{
				if(arr[i] + arr[j] > max)
					max = arr[i] + arr[j];
			}
		}
		
		return max;
	}
	
	public static void main(String args[])
	{
		int arr[] = {12, 34, 10, 6, 40};
		
		System.out.println("Max. pair sum = " + maxSumPair(arr, arr.length));
	}
}
