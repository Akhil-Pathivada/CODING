/**
 * Date 05/04/2022
 *
 * @author akhilpathivada
 */
package advanced.trie;

public class SearchInTrie {
        
        private boolean searchStringInTrie(TrieNode root, String s) {
                TrieNode current = root;
                // iterating over every character of string
                for (char c : s.toCharArray()) {
                        // if the character in target string not exists in Trie
                        if (current.trie[c] == null) {
                                return false;
                        }
                        current = current.trie[c];
                }
                return current.isEndOfString;
        }
        
        public static void main(String[] args) {
                String strs[] = { "gee", "geeks", "ape", "apple", "geeksforgeeks" };
                TrieNode root = new TrieNode();
                // insert the strings into Trie
                for (String str : strs) {
                        new InsertionIntoTrie().insertStringIntoTrie(root, str);
                }
                String target = "apple";
                System.out.printf(new SearchInTrie().searchStringInTrie(root, target) ? "string : %s found" : "string : %s not found", target);
        }
}
