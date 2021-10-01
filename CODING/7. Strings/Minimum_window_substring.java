/*
Given two strings, string1 and string2, the task is to find the smallest substring in string1 containing all characters of string2 efficiently. 

Examples: 

Input: string = “this is a test string”, pattern = “tist” 
Output: Minimum window is “t stri” 
Explanation: “t stri” contains all the characters of pattern.

Input: string = “geeksforgeeks”, pattern = “ork” 
Output: Minimum window is “ksfor”

*/

class GFG {

	static int MAX_CHARS = 256;

	static String minWindow(String S, String P) {

		// convert strings into Character Arrays
		char[] str = S.toCharArray();
		char[] pat = P.toCharArray();

		int[] map = new int[MAX_CHARS];
		int count = 0; // captures the distinct chars in pattern

		// store frequency of all chars of pattern
		for(char ch : pat) {
			// capture count of distinct chars
			if(map[ch] == 0) {
				++count;
			}
			map[ch]++;
		}

		int minLen = Integer.MAX_VALUE; // length of min. window
		int i, j, start; // start index of result window
		i = j = start = 0;

		while(j < str.length) {

			map[str[j]]--;
			// if all occurences of this char are visited
			if(map[str[j]] == 0) {
				--count;
			}
			// if all chars of pattern are visited
			if(count == 0) {

				while(count == 0) {
					
					int len = j - i + 1;
					// if new window length is less than already captured window length
					if(len < minLen) {

						minLen = len;
						start = i;
					}

					// want to remove first char from resulted window
					map[str[i]]++;

					if(map[str[i]] > 0) {
						++count;
					}
					++i;
				}
			}
			++j;
		}
		// if pattern is found
		if(minLen != Integer.MAX_VALUE) {
			return String.valueOf(str).substring(start, start + minLen);
		}
		else {
			return new String("-1");
		}
	}


	public static void main(String[] args) {

		String str = "ADOBECODEBANC"; // given string
		String pat = "ABC"; // pattern to match

		System.out.println("Smallest window that contain all character = " + minWindow(str, pat));
	}
}