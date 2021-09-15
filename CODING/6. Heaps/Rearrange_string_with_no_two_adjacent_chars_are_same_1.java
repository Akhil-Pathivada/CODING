/* 
 * Given a string with repeated characters, the task is to rearrange characters in a string so that no two adjacent characters are same.
 * Note : It may be assumed that the string has only lowercase English alphabets.
 * Examples:
 *
 *
 * Input: aaabc
 * Output: abaca
 *
 * Input: aaabb
 * Output: ababa
 *
 * Input: aa
 * Output: Not Possible
 *
 * Time Complexity : O(N * logN)
 * Space Complexity : O(N)
 *  */
import java.util.*;
import java.io.*;

class MaxHeapNodeComparator implements Comparator<MaxHeapNode> {

	@Override
	public int compare(MaxHeapNode k1, MaxHeapNode k2) {

		if(k1.freq < k2.freq) {
		    return 1;
		}
		else if(k1.freq > k2.freq) {
		    return -1;
		}
		return 0;
	}
}

class MaxHeapNode {

	char ch; // stores the char
	int freq; // stores the freq of char

	public MaxHeapNode(char ch, int freq) {

		this.ch = ch;
		this.freq = freq;
	}

}
class GFG { 

	static int MAX_CHAR = 26;
	
	private static void rearrangeString(String str) {

		int n = str.length();
		// store frequencies of all 26 chars
		int count[] = new int[MAX_CHAR];

		for(int i = 0; i < n; ++i) {

			count[str.charAt(i) - 'a']++;
		}

		// Max Heap
		PriorityQueue<MaxHeapNode> queue = new PriorityQueue<>(new MaxHeapNodeComparator());

		// inserting all chars, freq into Max Heap
		for(char ch = 'a'; ch <= 'z'; ++ch) {

			int val = ch - 'a';
			if(count[val] > 0) {

				queue.add(new MaxHeapNode(ch, count[val]));
			}
		}
		// to store the result
		str = "";
		// intializing dummy values to prev
		MaxHeapNode prev = new MaxHeapNode('#', -1);
		
		while(!queue.isEmpty()) {

			MaxHeapNode node = queue.poll();
			str += node.ch;

			if(prev.freq > 0) {

				queue.add(new MaxHeapNode(prev.ch, prev.freq));
			}
			node.freq--;
			prev = node;
		}

		if(n != str.length()) {
			System.out.println("Not Possible");
		}
		else { 
			System.out.println("Rearranged String : " + str);
		}
	}
		
	public static void main(String args[]) {

		String str = "bbbaa";
		rearrangeString(str);
	}
}
