/**
 * Date 05/04/2022
 *
 * @author akhilpathivada
 *
 * Time Complexity: The time complexity of the ternary search tree operations is similar to that of binary search tree.
 * i.e. the insertion, deletion, and search operations take time proportional to the height of the ternary search tree.
 * The space is proportional to the length of the string to be stored.
 */
package advanced.ternarysearchtree;


public class InsertionIntoTernarySearchTree {
        
        public static TernarySearchTreeNode insertStringIntoTST(TernarySearchTreeNode root, String s, int index) {
                // create node
                if(root == null) {
                        root = new TernarySearchTreeNode(s.charAt(index));
                }
                
                if(s.charAt(index) < root.data) {
                        
                        root.left = insertStringIntoTST(root.left, s, index);
                }
                else if (s.charAt(index) > root.data) {
                        
                        root.right = insertStringIntoTST(root.right, s, index);
                }
                else {
                        if(index + 1 < s.length()) {
                               root.equal = insertStringIntoTST(root.equal, s, index + 1);
                        }
                        else { // reached end of string
                             root.isEndOfString = true;
                        }
                }
                return root;
        }
        
        public static void main(String[] args) {
                String strs[] = { "gee", "geeks", "ape", "apple", "geeksforgeeks" };
                TernarySearchTreeNode root = null;
                // insert the strings into TST
                for(String str : strs) {
                        root = insertStringIntoTST(root, str, 0);
                }
        }
}
