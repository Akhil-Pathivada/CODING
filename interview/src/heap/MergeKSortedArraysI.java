/**
 * Date 05/04/2022
 *
 * @author akhilpathivada
 *
 * https://www.geeksforgeeks.org/merge-k-sorted-arrays/
 *
 * Time Complexity : O((K * N) * log(K * N))
 * Space Complexity : O(K * N)
 *
 */
package heap;

import java.util.Arrays;

public class MergeKSortedArraysI {
        
        private void mergeArrays(int[][] arr, int[] output, int k, int n) {
                for (int i = 0, c = 0; i < k; ++i) {
                        for (int j = 0; j < n; ++j) {
                                output[c++] = arr[i][j];
                        }
                }
               Arrays.sort(output);
        }
        
        public static void main(String[] args) {
                int[][] arr = {
                        { 2, 6, 12, 34 },
                        { 1, 9, 20, 1000 },
                        { 23, 34, 90, 2000 }
                };
                int k = 3; // k arrays
                int n = 4; // length of each array
                int[] output = new int[k * n];
                new MergeKSortedArraysI().mergeArrays(arr, output, k, n);
                System.out.println(Arrays.toString(output));
        }
}
