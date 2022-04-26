/**
 * Program to get the Bottom View of the Binary Tree
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 * */
package tree;

import java.util.*;

public class BottomViewOfBinaryTree {
        
        class QueueObj {
                int hd; // horizontal distance
                TreeNode node; // node
                // constructor
                QueueObj(TreeNode _node, int _hd) {
                        node = _node;
                        hd = _hd;
                }
        }
        
        private void printBottomView(TreeNode root) {
                // base case
                if (root == null) {
                        return;
                }
                // to keep track of Level Order Traversal
                Queue<QueueObj> queue = new LinkedList<QueueObj>();
                // to track if the node with horizontal distance is already visited
                TreeMap<Integer, TreeNode> map = new TreeMap<>();
                // insert the root into Queue
                queue.add(new QueueObj(root, 0));
                while (!queue.isEmpty()) {
                        QueueObj tempObj = queue.poll();
                        // even if node exists for that hd or not update entry with current node
                        map.put(tempObj.hd, tempObj.node);
                        // insert left and right children into Queue
                        if (tempObj.node.left != null) {
                                queue.add(new QueueObj(tempObj.node.left, tempObj.hd - 1));
                        }
                        if (tempObj.node.right != null) {
                                queue.add(new QueueObj(tempObj.node.right, tempObj.hd + 1));
                        }
                }
                // iterate over map values to print result
                for (Map.Entry<Integer, TreeNode> entry : map.entrySet()) {
                        System.out.println(entry.getValue().data);
                }
        }
        
        public static void main(String[] args) {
                TreeNode root = new TreeNode(20);
                root.left = new TreeNode(8);
                root.right = new TreeNode(22);
                root.left.left = new TreeNode(5);
                root.left.right = new TreeNode(3);
                root.right.left = new TreeNode(4);
                root.right.right = new TreeNode(25);
                root.left.right.left = new TreeNode(10);
                root.left.right.right = new TreeNode(14);
                new BottomViewOfBinaryTree().printBottomView(root);
        }
}
