/**
 * Date 29/03/2022
 *
 * @author akhilpathivada
 *
 * http://www.geeksforgeeks.org/find-the-largest-subtree-in-a-tree-that-is-also-a-bst/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 */
package tree;

public class LargestBSTInBinaryTreeII {
        
        private class NodeInfo {
                
                int size; // size of subtree
                int max; // max number in subtree
                int min; // min number in subtree
                int ans; // size of largest BST which is subtree of current node
                boolean isBST; // is this subtree is BST or not
                
                NodeInfo() {}
                
                NodeInfo(int size, int min, int max, int ans, boolean isBST) {
                        
                        this.size = size;
                        this.min = min;
                        this.max = max;
                        this.ans = ans;
                        this.isBST = true;
                }
        }
        
        private NodeInfo largestBST(TreeNode root) {
                // base case
                if(root == null) {
                        return new NodeInfo(0, Integer.MAX_VALUE, Integer.MIN_VALUE, 0, true);
                }
                // Leaf node itself is a BST- with size 0
                if(root.left == null && root.right == null) {
                        return new NodeInfo(1, root.data, root.data, 1, true);
                }
                // Recur on both Left and Right SubTrees
                NodeInfo leftSubTree = largestBST(root.left);
                NodeInfo rightSubTree = largestBST(root.right);
                // Returning the info of the Root node
                NodeInfo returnNodeInfo = new NodeInfo();
                // Computing size of the every node
                returnNodeInfo.size = 1 + leftSubTree.size + rightSubTree.size;
                // if both and Left and Right Subtrees are BST, then need computing nodeInfo of root
                if(leftSubTree.isBST && rightSubTree.isBST && leftSubTree.max < root.data && rightSubTree.min > root.data) {
                        
                        returnNodeInfo.min = Math.min(Math.min(leftSubTree.min, rightSubTree.min), root.data);
                        returnNodeInfo.max = Math.max(Math.max(leftSubTree.max, rightSubTree.max), root.data);
                        returnNodeInfo.ans = returnNodeInfo.size;
                        returnNodeInfo.isBST = true;
                        return returnNodeInfo;
                }
                returnNodeInfo.ans = Math.max(leftSubTree.ans, rightSubTree.ans);
                returnNodeInfo.isBST = false;
                return returnNodeInfo;
        }
        
        public static void main(String[] args) {
                
                TreeNode root = new TreeNode(50);
                root.left = new TreeNode(10);
                root.right = new TreeNode(60);
                root.left.left = new TreeNode(5);
                root.left.right = new TreeNode(20);
                root.right.left = new TreeNode(55);
                root.right.left.left = new TreeNode(45);
                root.right.right = new TreeNode(70);
                root.right.right.left = new TreeNode(65);
                root.right.right.right = new TreeNode(80);
                
                System.out.printf("Size of largest BST is = %d ", new LargestBSTInBinaryTreeII().largestBST(root).ans);
        }
}
