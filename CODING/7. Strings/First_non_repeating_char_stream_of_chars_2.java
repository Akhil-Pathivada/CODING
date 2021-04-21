/* 
 * Given a stream of characters, find the first non-repeating character from stream.
 * You need to tell the first non-repeating character in O(1) time at any moment.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 *
 * https://www.geeksforgeeks.org/find-first-non-repeating-character-stream-characters/
 *  
 *  */

import java.util.*;

class GFG {

	final static int MAX_CHAR = 256;

	private void findFirstNonRepeatingChar(String stream) {

		// stores like a Hash 
		int charCount[] = new int[MAX_CHAR];

		Queue<Character> queue = new LinkedList<Character>();

		for(int i = 0; i < stream.length(); ++i) {

			char ch = stream.charAt(i);

			System.out.print("Reading " + ch + " from stream :: ");

			++charCount[ch];

			queue.add(ch);

			while(!queue.isEmpty()) {

				if(charCount[queue.peek()] > 1) {
					queue.remove();
				}
				else {
					System.out.println("First non-repeating character so far is : " + queue.peek());
					break;
				}
			}
			if(queue.isEmpty()) {
				System.out.print(-1 + "");
			}
		}
	}
	public static void main(String args[]) {

		String stream = "geeksforgeeksandgeeksquizfor";

		GFG obj = new GFG();

		obj.findFirstNonRepeatingChar(stream);
	}
}

