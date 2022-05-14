/**
 * Height of a Binary Tree
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 * */
package tree;

import java.util.LinkedList;
import java.util.Queue;

public class HeightOfBinaryTreeII {
        private int heightOfBinaryTree(TreeNode root) {
                // base case
                if(root == null) {
                        return 0;
                }
                int height = 0;
                Queue<TreeNode> queue = new LinkedList<>();
                queue.add(root);
                while(true) {
                        // count nodes in current level
                        int nodeCount = queue.size();
                        // if all nodes visited
                        if (nodeCount == 0) {
                                return height - 1;
                        }
                        ++height;
                        // iterate over all nodes in current level
                        while (nodeCount-- > 0) {
                                TreeNode temp = queue.remove();
                                if (temp.left != null) {
                                        queue.add(temp.left);
                                }
                                if (temp.right != null) {
                                        queue.add(temp.right);
                                }
                                --nodeCount;
                        }
                }
        }
        public static void main(String[] args) {
                TreeNode root = new TreeNode(1);
                root.left = new TreeNode(2);
                root.right = new TreeNode(3);
                root.left.left = new TreeNode(4);
                root.left.left.right = new TreeNode(5);
                System.out.println("Height of Binary Tree = " + new HeightOfBinaryTreeII().heightOfBinaryTree(root));
        }
}
