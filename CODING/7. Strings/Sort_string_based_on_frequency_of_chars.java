/* Given a string str, the task is to sort the string according to the frequency of each character, in ascending order. If two elements have the same frequency, then they are sorted in lexicographical order.
 * Examples:
 *
 * Input: str = “geeksforgeeks”
 * Output: forggkksseeee
 * Explanation:
 * Frequency of characters: g2 e4 k2 s2 f1 o1 r1
 * Sorted characters according to frequency: f1 o1 r1 g2 k2 s2 e4
 * f, o, r occurs one time so they are ordered lexicographically and so are g, k and s.
 * Hence the final output is forggkksseeee.
 *
 * Time Complexity : O(N * log(N))
 * Space Complexity : O(N)
 *  */

import java.util.*;

class GFG { 

	private static String frequencySort(String s) {

		// stores character and its frequency
		Map<Character, Integer> map = new HashMap<Character, Integer>();

		for(char ch : s.toCharArray()) {

			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}

		// stores the characters based on their frequency (in non-decreasing order) 
		// change this line inorder to print characters in descending frequency order (Min Heap)
		Queue<Map.Entry<Character, Integer>> minHeap = new PriorityQueue<>((a,b) -> a.getValue() - b.getValue());

		for(Map.Entry<Character, Integer> entry : map.entrySet()) {

			minHeap.add(entry);
		}

		// stores the result string
		StringBuilder sb = new StringBuilder();

		while(!minHeap.isEmpty()) {

			Map.Entry<Character,Integer> entry = minHeap.poll();

			String str = (entry.getKey() + "").repeat(entry.getValue());
			sb.append(str);
		}
		return sb.toString();
	}

	public static void main(String[] args) {

		String str = "geeksforgeeks";

		System.out.println("Original String : " + str);
		System.out.println("Result String : " + frequencySort(str));
	}
}
