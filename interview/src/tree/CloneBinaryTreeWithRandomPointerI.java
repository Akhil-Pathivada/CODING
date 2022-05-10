/**
 * Date 10/05/2022
 *
 * @author akhilpathivada
 *
 * https://www.geeksforgeeks.org/clone-binary-tree-random-pointers/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 */
package tree;

import java.util.HashMap;

public class CloneBinaryTreeWithRandomPointerI {
        private static class BinaryTreeNodeWithRandomPointer {
                int data;
                BinaryTreeNodeWithRandomPointer left, right, random;
                BinaryTreeNodeWithRandomPointer(int _data) {
                        data = _data;
                        left = null;
                        right = null;
                        random = null;
                }
        }
        private static void printInorder(BinaryTreeNodeWithRandomPointer node) {
                // base case
                if (node == null) {
                        return;
                }
                // First recur on left subtree
                printInorder(node.left);
                // then print data of Node and its random
                System.out.print("[" + node.data + " ");
                if (node.random == null) {
                        System.out.print("null], ");
                } else {
                        System.out.print(node.data + "]");
                }
                // now recur on right subtree
                printInorder(node.right);
        }
        private static void copyRandomPointer(BinaryTreeNodeWithRandomPointer root, BinaryTreeNodeWithRandomPointer clone, HashMap<BinaryTreeNodeWithRandomPointer, BinaryTreeNodeWithRandomPointer> map) {
                // base case
                if (root == null) {
                        return;
                }
                clone.random = map.get(root.random);
                copyRandomPointer(root.left, clone.left, map);
                copyRandomPointer(root.right, clone.right, map);
        }
        private static BinaryTreeNodeWithRandomPointer cloneTreeUtil(BinaryTreeNodeWithRandomPointer root, HashMap<BinaryTreeNodeWithRandomPointer, BinaryTreeNodeWithRandomPointer> map) {
                // base case
                if (root == null) {
                        return null;
                }
                BinaryTreeNodeWithRandomPointer clone = new BinaryTreeNodeWithRandomPointer(root.data);
                map.put(root, clone);
                clone.left = cloneTreeUtil(root.left, map);
                clone.right = cloneTreeUtil(root.right, map);
                return clone;
        }
        private static BinaryTreeNodeWithRandomPointer cloneTree(BinaryTreeNodeWithRandomPointer originalTreeRoot) {
                // base case
                if (originalTreeRoot == null) {
                        return null;
                }
                // create a hashmap to store the randoms
                HashMap<BinaryTreeNodeWithRandomPointer, BinaryTreeNodeWithRandomPointer> map = new HashMap<>();
                BinaryTreeNodeWithRandomPointer cloneTreeRoot = cloneTreeUtil(originalTreeRoot, map);
                copyRandomPointer(originalTreeRoot, cloneTreeRoot, map);
                return cloneTreeRoot;
        }
        public static void main(String[] args) {
                BinaryTreeNodeWithRandomPointer root = new BinaryTreeNodeWithRandomPointer(1);
                root.left = new BinaryTreeNodeWithRandomPointer(2);
                root.right = new BinaryTreeNodeWithRandomPointer(3);
                root.left.left = new BinaryTreeNodeWithRandomPointer(4);
                root.left.right = new BinaryTreeNodeWithRandomPointer(5);
                root.random = root.left.right;
                root.left.left.random = root;
                root.left.right.random = root.right;
                printInorder(root);
                BinaryTreeNodeWithRandomPointer cloneTreeRoot = cloneTree(root);
                System.out.println();
                printInorder(cloneTreeRoot);
        }
}
