/**
 * Date 06/04/2022
 *
 * @author akhilpathivada
 *
 * Merge Sort Algorithm
 *
 * Time Complexity : O(N * log(N))
 * Space Complexity : O(N)
 */
package sort;

import java.util.Arrays;

public class MergeSort {
        // Merges two subarrays of arr[]. First subarray is arr[p..q] Second subarray is arr[q+1..r]
        private void merge(int[] arr, int p, int q, int r) {
                int i, j;
                // find sizes of two subarrays to be merged
                int n1 = q - p + 1;
                int n2 = r - q;
                // create temp arrays
                int L[] = new int[n1 + 1];
                int R[] = new int[n2 + 1];
                // copy data to temp arrays L[] and R[]
                for (i = 0; i < n1; ++i) {
                        L[i] = arr[p + i];
                }
                for (j = 0; j < n2; ++j) {
                        R[j] = arr[q + 1 + j];
                }
                L[n1] = R[n2] = Integer.MAX_VALUE;
                // initial indexes of first and second subarrays
                i = j = 0;
                // Merge the temp arrays back into arr[p..r]
                for (int k = p; k <= r; ++k) {
                        if (L[i] <= R[j]) {
                                arr[k] = L[i++];
                        } else {
                                arr[k] = R[j++];
                        }
                }
        }
        private void sort(int[] arr, int p, int r) {
                if (p < r) {
                        int q = (p + r) / 2;
                        // call sort on first and second halves
                        sort(arr, p, q);
                        sort(arr, q + 1, r);
                        // merge first and second halves
                        merge(arr, p, q, r);
                }
        }
        public static void main(String args[]) {
                int arr[] = { 12, 11, 13, 5, 6, 7 };
                System.out.println("Given Array" + Arrays.toString(arr));
                new MergeSort().sort(arr, 0, arr.length - 1);
                System.out.println("Sorted array" +  Arrays.toString(arr));
        }
}
