/**
 * Date 01/05/2022
 *
 * @author akhilpathivada
 */
package advanced.segmenttree;

public class SegmentTree {
        
        int[] st; // This array stores Segment Tree nodes
        int maxSize; // Size of Segment Tree
        public SegmentTree(int[] arr, int n) {
                // compute height of segment tree
                int x = (int)(Math.ceil(Math.log(n) / Math.log(2)));
                maxSize = 2 * (int) Math.pow(2, x) - 1;
                st = new int[maxSize];
                constructSegmentTree(arr, 0, n - 1, 0);
        }
        private int constructSegmentTree(int[] arr, int ss, int se, int index) {
                // If there is one element in array, store it in current
                //  node of segment tree and return
                if (ss == se) {
                        st[index] = arr[ss];
                        return arr[ss];
                }
                int mid = ss + (se - ss) / 2;
                // If there are more than one element, then recur for left and
                // right subtrees and store the minimum of two values in this node
                st[index] = Math.min(constructSegmentTree(arr, ss, mid, index * 2 + 1),
                                constructSegmentTree(arr, mid + 1, se, index * 2 + 2));
                return st[index];
        }
}
