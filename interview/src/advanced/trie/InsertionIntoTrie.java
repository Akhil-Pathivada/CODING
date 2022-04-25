/**
 * Date 05/04/2022
 *
 * @author akhilpathivada
 * The complexity of creating a trie is O(W*L), where W is the number of words, and L is an average length of the word:
 * you need to perform L lookups on the average for each of the W words in the set.
 *
 */
package advanced.trie;

public class InsertionIntoTrie {
        
        // Method to insert every string into Trie
        public void insertStringIntoTrie(TrieNode root, String s) {
                TrieNode current = root;
                // iterating over every character in string and forming trie
                for (char c : s.toCharArray()) {
                        // if that character not exists
                        if (current.trie[c] == null) {
                                current.trie[c] = new TrieNode();
                        }
                        current = current.trie[c];
                }
                // marking current node as EndOfString so that we can easily identify end-of-string
                current.isEndOfString = true;
        }
        
        public static void main(String[] args) {
                String strs[] = { "gee", "geeks", "ape", "apple", "geeksforgeeks" };
                TrieNode root = new TrieNode();
                // insert the strings into Trie
                for (String str : strs) {
                        new InsertionIntoTrie().insertStringIntoTrie(root, str);
                }
        }
}
