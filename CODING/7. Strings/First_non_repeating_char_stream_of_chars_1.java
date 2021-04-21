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

		List<Character> DLL = new LinkedList<Character>();

		// repeated[x] is true if x is repeated two or more
		// times. If x is not seen so far or x is seen only
		// once. then repeated[x] is false
		boolean repeated[] = new boolean[MAX_CHAR];

		for(int i = 0; i < stream.length(); ++i) {

			char ch = stream.charAt(i);

			System.out.print("Reading " + ch + " from stream :: ");

			if(!repeated[ch]) {

				if(!(DLL.contains(ch))) {
					DLL.add(ch);
				}
				else {
					DLL.remove((Character)ch);
					repeated[ch] = true;
				}
			}
			if(DLL.size() != 0) {
				System.out.println("First non-repeating character so far is " + DLL.get(0));
			}
		}

	}
	public static void main(String args[]) {

		String stream = "geeksforgeeksandgeeksquizfor";

		GFG obj = new GFG();

		obj.findFirstNonRepeatingChar(stream);
	}
}

