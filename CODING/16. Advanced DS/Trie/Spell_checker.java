/* 
 * Given an array of strings str[] and a string key, the task is to check if the spelling of the key is correct or not. If found to be true, then print “YES”.
 * Otherwise, print the suggested correct spellings.
 *
 * Input:str[] = { “gee”, “geeks”, “ape”, “apple”, “geeksforgeeks” }, key = “geek”
 * Output: geeks geeksforgeeks
 * Explanation:
 * The string “geek” not present in the array of strings.
 * Therefore, the suggested words are { “geeks”, “geeksforgeeks” }.
 *
 * Time Complexity: O(N * M), where N is no. of strings and M is the maximum length of the string
 * Space Complexity: O(N * 256)
 *  */

class TrieNode {
	
	TrieNode trie[]; // each characters' index acts as a pointer 
	boolean isEnd; // tells if the string ends there or not

	public TrieNode() {

		trie = new TrieNode[256];
		// iterates over 26 indexes and
		// initializes as null
		for(int i = 0; i < 256; ++i) {
			trie[i] = null;
		}
		isEnd = false;
	}
}

class Trie {

	// Method to print the suggestions of strings
	private void printSuggestions(TrieNode root, String result) {

		// printing the string if it is reach to end
		if(root.isEnd == true){

			System.out.println(result + " ");
		}
		// iterating over all possible characters of string
		for(int i = 0; i < 256; ++i) {
			// if character is present
			if(root.trie[i] != null) {

				result += (char) i;
				// recursively iterating over all the strings
				// possible strings from this character
				printSuggestions(root.trie[i], result);
				result = result.substring(0, result.length() - 1);
			}
		}
	} 

	// Checking the string is present in the Trie or not
	private boolean checkStringIsPresent(TrieNode root, String str) {
		// iterating over every character of string
		for(int i = 0; i < str.length(); ++i) {
			// if the current character not exists in Trie
			if(root.trie[str.charAt(i)] == null) {
				
				this.printSuggestions(root, str.substring(0, i));	
				return false;
			} 
			root = root.trie[str.charAt(i)];
		}
		// if we reached end-of-string
		if(root.isEnd == true) {
			return true;
		}
		printSuggestions(root, str);
		return false;
	}

	// Method to insert every string into Trie
	private void insertStringsIntoTrie(TrieNode root, String str) {
		
		TrieNode temp = root;
		// iterating over every string and forming trie
		for(int i = 0; i < str.length(); ++i) {
			// if that character not exists
			if(temp.trie[str.charAt(i)] == null) {

				temp.trie[str.charAt(i)] = new TrieNode();
			}
			temp = temp.trie[str.charAt(i)];
		}
		// marking the trienode isEnd = true
		// so that we can easily identify end-of-string
		temp.isEnd = true;
	}

	public static void main(String args[]) {
		
		// Given array of strings
		String strings[] = { "gee", "geeks", "ape", "apple", "geeksforgeeks" };
		
		String key = "geek";

		// Initialise a Trie
		TrieNode root = new TrieNode();

		Trie obj = new Trie();
		// Inserting the strings into Trie
		for(int i = 0; i < strings.length; ++i) {

			obj.insertStringsIntoTrie(root, strings[i]);
		}
		obj.checkStringIsPresent(root, key);
	}
}
