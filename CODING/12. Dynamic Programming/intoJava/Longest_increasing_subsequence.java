/*
Find the length of the longest subsequence of a given sequence such that all elements of the subsequence are sorted in increasing order. 
For example, the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and LIS is {10, 22, 33, 50, 60, 80}.

(Dynamic Programming)

Time Complexity : O(n^2)
Space Complexity : O(n)
*/

class LIS {

	int getLIS(int arr[], int n) {

		// Compute LIS of every element 
		// and store it appropriately
		int lis[] = new int[n];
		
		int max = 0;
		
		// Initialize LIS values for all indexes
		for(int i = 0; i < n; ++i) {
			lis[i] = 1;
		}

		// Compute optimized LIS values in
                // Top-Down manner
		for(int i = 1; i < n; ++i) {
			for(int j = i - 1; j >= 0; --j) {
				if(arr[i] > arr[j] && lis[i] < lis[j] + 1) {
					lis[i] = lis[j] + 1;
				}
			}
		}

		// Pick Maximum from all LIS values
		for(int i = 0; i < n; ++i) {
			if(max < lis[i]) {
				max = lis[i];
			}
		}
		return max;
	}

	public static void main(String args[]) {
		
		int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
		int n = arr.length;
		
		LIS obj = new LIS();	
		System.out.println("Longest Increasing Subsequence: " + obj.getLIS(arr, n));
	}
}
