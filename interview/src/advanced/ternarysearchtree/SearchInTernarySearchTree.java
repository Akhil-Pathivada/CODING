/**
 * Date 05/04/2022
 *
 * @author akhilpathivada
 */
package advanced.ternarysearchtree;

public class SearchInTernarySearchTree {
        
        private static boolean searchStringIntoTST(TernarySearchTreeNode root, String s, int index) {
                // base case
                if(root == null) {
                        return false;
                }
                if(s.charAt(index) < root.data) {
                        return searchStringIntoTST(root.left, s, index);
                }
                else if(s.charAt(index) > root.data) {
                        return searchStringIntoTST(root.right, s, index);
                }
                else {
                        if(index + 1 >= s.length()) { // word reaches the end
                                return root.isEndOfString;
                        }
                        // character matches, so search for next character
                        return searchStringIntoTST(root.equal, s, index + 1);
                }
        }
        
        public static void main(String[] args) {
                String strs[] = { "gee", "geeks", "ape", "apple", "geeksforgeeks" };
                TernarySearchTreeNode root = null;
                // insert the strings into TST
                for(String str : strs) {
                        root = InsertionIntoTernarySearchTree.insertStringIntoTST(root, str, 0);
                }
                String target = "apple";
                System.out.printf(searchStringIntoTST(root, target, 0) ? "string : %s found" : "string : %s not found", target);
        }
}
