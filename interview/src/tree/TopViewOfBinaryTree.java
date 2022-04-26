/**
 * Program to get the Top View of the Binary Tree
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 * */
package tree;

import java.util.*;

public class TopViewOfBinaryTree {
        
        class QueueObj {
                int hd; // horizontal distance
                TreeNode node; // node
                // constructor
                QueueObj(TreeNode _node, int _hd) {
                        node = _node;
                        hd = _hd;
                }
        }
        
        private void printTopView(TreeNode root) {
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
                        // if node is the first one with the horizontal distance
                        if (!map.containsKey(tempObj.hd)) {
                                map.put(tempObj.hd, tempObj.node);
                        }
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
                TreeNode root = new TreeNode(1);
                root.left = new TreeNode(2);
                root.right = new TreeNode(3);
                root.left.right = new TreeNode(4);
                root.left.right.right = new TreeNode(5);
                root.left.right.right.right = new TreeNode(6);
                new TopViewOfBinaryTree().printTopView(root);
        }
}
