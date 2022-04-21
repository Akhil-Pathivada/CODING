
/**
 * Consider lines of slope -1 passing between nodes.
 * Given a Binary Tree, print all diagonal elements in a binary tree belonging to same line.
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
*/

package tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class DiagonalTraversalOfBinaryTree {
        
        private void diagonalTraversalUtil(TreeNode root, int vd, HashMap<Integer, Vector<Integer>> map) {
                // base case
                if(root == null) {
                        return;
                }
                Vector<Integer> vec = map.get(vd);
                // if no elememts are there for vertical distance
                if(vec == null) {
                        vec = new Vector<>();
                }
                vec.add(root.data);
                map.put(vd, vec);
                // recur over left and right subtrees
                diagonalTraversalUtil(root.left, vd + 1, map);
                diagonalTraversalUtil(root.right, vd, map);
        }
        
        private void diagonalTraversal(TreeNode root) {
                // map tracks vertical distance and its corresponding elements
                HashMap<Integer, Vector<Integer>> map = new HashMap<>();
                // capture vertical distance
                int vd = 0;
                diagonalTraversalUtil(root, vd, map);
                // iterate over the map print result
                for(Map.Entry<Integer, Vector<Integer>> entry : map.entrySet()) {
                        System.out.println(entry.getValue());
                }
        }
        
        public static void main(String[] args) {
                TreeNode root = new TreeNode(1);
                root.left = new TreeNode(2);
                root.right = new TreeNode(3);
                root.left.left = new TreeNode(4);
                root.left.right = new TreeNode(5);
                root.right.left = new TreeNode(6);
                root.right.left.left = new TreeNode(7);
                new DiagonalTraversalOfBinaryTree().diagonalTraversal(root);
        }
}
