/* 
 * Given an array of strings. The task is to print all strings in reverse dictionary order using Trie.
 * If there are duplicates in the input array, we need to print them only once
 *
 * Input: str = {"cat", "there", "caller", "their", "calling"}
 * Output: there
 *         their
 *         cat
 *         calling
 *         caller
 *
 * Time Complexity: O(N * M) where N is no. of strings and M is max. length of string
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

	private void printInReverseDictOrder(TrieNode root, String printableString) {

		// print if the string ends here
		if(root.isEnd == true){

			System.out.println(printableString);
		}

		// traversing from the last character
		for(int i = 255; i >= 0; --i) {
			
			if(root.trie[i] != null) {
				// appending character to string
				printableString += (char) i;
				// iterating over all possible strings
				printInReverseDictOrder(root.trie[i], printableString);				
				// trimming the last character
				printableString = printableString.substring(0, printableString.length() - 1);
			}
			
		}
	}

	public static void main(String args[]) {
		
		// Given array of strings
		String strings[] = {"cat", "there", "caller", "their", "calling"};
		
		// Initialise a Trie
		TrieNode root = new TrieNode();

		Trie obj = new Trie();

		for(int i = 0; i < strings.length; ++i) {

			obj.insertStringsIntoTrie(root, strings[i]);
		}

		obj.printInReverseDictOrder(root, "");

	}
}

