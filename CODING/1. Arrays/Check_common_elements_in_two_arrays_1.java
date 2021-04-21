/** 
  * Given two given arrays of equal length, the task is to find if given arrays are equal or not. Two arrays are said to be equal
  * if both of them contain the same set of elements, arrangements (or permutation) of elements may be different though.
  *
  * (Using HashMap)
  * Time Complexity: O(N)
  * Space Complexity: O(N)
  *  */

import java.util.*;

class Array {

	private boolean areEqual(int arr1[], int arr2[]) {

		int m = arr1.length;
		int n = arr2.length;

		if(m != n) {
			return false;
		}
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for(int i = 0; i < m; ++i) {

			if(map.get(arr1[i]) == null) {
				map.put(arr1[i], 1);
			}
			else {
				map.put(arr1[i], map.get(arr1[i]) + 1);
			}
		}
		for(int i = 0; i < n; ++i) {

			if(!map.containsKey(arr2[i])) {
				return false;
			}
			if(map.get(arr2[i]) == 0){
				return false;
			}
			map.put(arr2[i], map.get(arr2[i]) - 1);
		}
		return true;
	}
	
	public static void main(String args[]) {

		int arr1[] = { 3, 5, 2, 5, 2 };
		int arr2[] = { 2, 3, 5, 5, 2 };
	 	
		Array obj = new Array();

		System.out.println(obj.areEqual(arr1, arr2) ? "Yes" : "No");
	}
}
