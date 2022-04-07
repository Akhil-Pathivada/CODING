/**
 * Date 06/04/2022
 *
 * @author akhilpathivada
 *
 * https://www.geeksforgeeks.org/in-place-convert-a-given-binary-tree-to-doubly-linked-list/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 */
package tree;

public class ConvertBinaryTreeToDLLII {
        
        private static TreeNode head = null;
        private static TreeNode prev = null;
    
        private static void convertBinaryTreeToDLL(TreeNode root) {
                // base case
                if(root == null) {
                        return;
                }
                // Convert the left subtree and link to root
                convertBinaryTreeToDLL(root.left);
                // initialize DLL head
                if(prev == null) {
                        head = root;
                }
                else { // make double links of prev and root
                        prev.right = root;
                        root.left = prev;
                }
                prev = root;
                // Convert the right subtree and link to root
                convertBinaryTreeToDLL(root.right);
        }
        
        private static void printDLL() {
                
                if(head == null) {
                        return;
                }
                // traverse backwards to the root
                for( ; head.left != null; head = head.left);
                // print the DLL
                for( ; head != null; head = head.right) {
                        System.out.print(head.data + ", ");
                }
        }
        
        public static void main(String[] args) {
                
                TreeNode root = new TreeNode(10);
                root.left = new TreeNode(12);
                root.right = new TreeNode(15);
                root.left.left = new TreeNode(25);
                root.left.right = new TreeNode(30);
                root.right.left = new TreeNode(36);
                
                convertBinaryTreeToDLL(root);
                printDLL();
        }
}
