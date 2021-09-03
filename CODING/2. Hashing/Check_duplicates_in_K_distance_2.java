/*
Check if a given array contains duplicate elements within k distance from each other.

Time Complexity : O(n)
Space Complexity : O(k)
*/

import java.util.*;

class Array {

	static boolean checkDuplicates(int arr[], int k) {

		int n = arr.length;
		HashSet<Integer> hashSet = new HashSet<Integer>();
		
		for(int i = 0; i < n; ++i) {

			if(hashSet.contains(arr[i])) {

				return true;
			}
			hashSet.add(arr[i]);

			if(i >= k) {

				hashSet.remove(arr[i - k]);
			}
		}
		return false;
	}
	public static void main(String args[]) {

		int arr[] = {1, 2, 3, 4, 4, 5};
		int k = 3;
		
		System.out.println(checkDuplicates(arr,k));
	}
}
