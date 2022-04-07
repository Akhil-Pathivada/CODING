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

public class ConvertBinaryTreeToDLLI {
        
        private static void createPrevNextLinks(TreeNode prev, TreeNode curr) {
                
                prev.right = curr;
                curr.left = prev;
        }
        
        private static TreeNode convertBinaryTreeToDLL(TreeNode root) {
                // base case
                if(root == null) {
                        return root;
                }
                // Convert the left subtree and link to root
                if(root.left != null) {
                
                        TreeNode prevNode = convertBinaryTreeToDLL(root.left);
                        // Find inorder predecessor. After this loop, prevNode
                        // will point to the inorder predecessor
                        while(prevNode.right != null ) {
                                prevNode = prevNode.right;
                        }
                        createPrevNextLinks(prevNode, root);
                }
                // Convert the right subtree and link to root
                if(root.right != null) {
                        // Convert the right subtree
                        TreeNode nextNode = convertBinaryTreeToDLL(root.right);
                        // Find inorder successor. After this loop, nextNode
                        // will point to the inorder successor
                        while(nextNode.left != null) {
                                nextNode = nextNode.left;
                        }
                        createPrevNextLinks(root, nextNode);
                }
                return root;
        }
        
        private static void printDLL(TreeNode head) {
                
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
                
                root = convertBinaryTreeToDLL(root);
                printDLL(root);
        }
}
