/**
 * Date 01/05/2022
 *
 * @author akhilpathivada
 */
package advanced.segmenttree;

import java.util.Arrays;

public class RangeMinimumQuery {
        
        private int rangeMinimumUtil(int[] st, int ss, int se, int qs, int qe, int index) {
                // base case
                if (qs <= ss && qe >= se) {
                        return st[index];
                }
                if (qs > se || qe < ss) {
                        return Integer.MAX_VALUE;
                }
                int mid = ss + (se - ss) / 2;
                return Math.min(rangeMinimumUtil(st, ss, mid, qs, qe, 2 * index + 1),
                                rangeMinimumUtil(st, mid + 1, se, qs, qe, 2 * index + 2));
        }
        
        private int rangeMinimum(int[] arr, int n, int qs, int qe) {
                if (qs < 0 || qe >= n) {
                        return -1;
                }
                // create segment tree
                int[] st = new SegmentTree(arr, n).st;
                return rangeMinimumUtil(st, 0, n - 1, qs, qe, 0);
        }
        
        public static void main(String[] args) {
                int arr[] = { 1, 3, 2, 7, 9, 11 };
                int n = arr.length;
                int qs = 1;  // Starting index of query range
                int qe = 5;  // Ending index of query range
                System.out.println("Minimum of values in range [" + qs + ", " + qe + "] is = " + new RangeMinimumQuery().rangeMinimum(arr, n, qs, qe));
        }
}
