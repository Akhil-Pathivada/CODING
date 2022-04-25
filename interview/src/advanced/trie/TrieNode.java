/**
 * Date 05/04/2022
 *
 * @author akhilpathivada
 */
package advanced.trie;

public class TrieNode {
        
        TrieNode[] trie; // each characters' index acts as a pointer
        boolean isEndOfString; // tells if the string ends there or not
        public TrieNode() {
                trie = new TrieNode[256];
                // iterates over 256 indexes and initializes as null
                for (int i = 0; i < 256; ++i) {
                        trie[i] = null;
                }
                isEndOfString = false;
        }
}
