/*
Check whether two arrays are Disjoint or not....

Time Complexity : O(n)
Space Complexity : O(m)
*/

import java.util.*;

class GFG {

	private static boolean areDisjoint(int[] arr1, int[] arr2) {

		HashSet<Integer> set = new HashSet<>();

		for(int i : arr1) {
			set.add(i);
		}

		for(int i : arr2) {

			if(set.contains(i)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		
		int set1[] = {10, 5, 3, 4, 6};
		int set2[] = {8, 7, 9, 3};

		System.out.println(areDisjoint(set1, set2) ? "Yes" : "No");
	}
}