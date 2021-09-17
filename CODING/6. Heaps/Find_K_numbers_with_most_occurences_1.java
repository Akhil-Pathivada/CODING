/* 
 * Given an array of n numbers and a positive integer k. The problem is to find k numbers with most occurrences, i.e., the top k numbers having the maximum frequency. If two numbers have the same frequency then the larger number should be given preference. The numbers should be displayed in decreasing order of their frequencies. It is assumed that the array consists of k numbers with most occurrences.
 *
 * Examples:
 *
 * Input:
 * arr[] = {3, 1, 4, 4, 5, 2, 6, 1},
 * k = 2
 * Output: 4 1
 * Explanation:
 * Frequency of 4 = 2
 * Frequency of 1 = 2
 * These two have the maximum frequency and 4 is larger than 1.
 *
 * Time Complexity : O()
 * Space Complexity : O()
 *
 *  */

import java.util.*;

class GFG { 

	private static void getKTopFrequenciedNumbers(int[] arr, int n, int k) {

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for(int i : arr) {

			map.put(i, map.getOrDefault(i, 0) + 1);
		}

		List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());

		Collections.sort(
				list, 
				new Comparator<Map.Entry<Integer, Integer>>() {
					
					public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {

						if(o1.getValue() == o2.getValue()) {
							return o2.getKey() - o1.getKey();
						}
						else {
							return o2.getValue() - o1.getValue();
						}
					}
				});

		for(int i = 0; i < k; ++i) {

			System.out.print(list.get(i).getKey() + ", ");
		}
	}

	public static void main(String[] args) {

		int arr[] = { 7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9};
		int n = arr.length;
		int k = 4;

		getKTopFrequenciedNumbers(arr, n, k);
	}
}
