package trees;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ZigZagLevelOrderTraverseII {
        
        private List<List<Integer>> zigZagLevelOrder(TreeNode root) {
                
                if(root == null) {
                        return new ArrayList<>();
                }
                List<List<Integer>> resultList = new ArrayList<>();
                // maintain Double Ended Queue: since we need to insert both at First and Last positions
                Deque<TreeNode> deque = new LinkedList<>();
                // insert root
                deque.offerFirst(root);
                // tracks which level nodes to be inserted in reverse order
                boolean flip = true;
                while(!deque.isEmpty()) {
                        // get size of this level
                        int nodeCount = deque.size();
                        List<Integer> list = new ArrayList<>();
                        // iterate over all nodes in this level
                        while(nodeCount-- > 0) {
                                // node to be added to list
                                TreeNode node;
                                // if nodes to be inserted in normal order
                                if(flip) {
                                        // get first element
                                        node = deque.pollFirst();
                                        // add left and right children
                                        if(node.left != null) {
                                                deque.offerLast(node.left);
                                        }
                                        if(node.right != null) {
                                                deque.offerLast(node.right);
                                        }
                                }
                                // if nodes to be inserted in reverse order
                                else {
                                        // get last element
                                        node = deque.pollLast();
                                        // add right and left children
                                        if(node.right != null) {
                                                deque.offerFirst(node.right);
                                        }
                                        if(node.left != null) {
                                                deque.offerFirst(node.left);
                                        }
                                }
                                list.add(node.data);
                        }
                        flip = !flip;
                        resultList.add(list);
                }
                return resultList;
        }
        
        public static void main(String[] args) {
        
                TreeNode root = new TreeNode(4);
                root.left = new TreeNode(2);
                root.right = new TreeNode(7);
                root.left.left = new TreeNode(1);
                root.left.right = new TreeNode(3);
                root.right.left = new TreeNode(6);
                root.right.right = new TreeNode(9);
        
                System.out.println(new ZigZagLevelOrderTraverseII().zigZagLevelOrder(root));
        }
}
