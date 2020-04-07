/*
Given an array and an integer K, find the maximum for each and every contiguous subarray of size k.

Time Complexity : O(n*k)
Space Complexity : O(1)
*/

class Maximer
{
	static void printMax(int arr[], int n, int k)
	{
		for(int i=0; i<=n-k; ++i)
		{
			int max = arr[i];
			
			for(int j=i; j<i+k; ++j)
			{
				max = arr[j] > max ? arr[j] : max;
			}
			
			System.out.print(max + " ");
		}
	}
	
	public static void main(String args[])
	{
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }; 
		
		int n = arr.length;
		
		int k = 3;
		
		printMax(arr, n, k);
	}
}
