/**
 * Date 01/05/2022
 *
 * @author akhilpathivada
 *
 * https://www.geeksforgeeks.org/counting-inversions/
 *
 * Time Complexity : O(N * log(N))
 * Space Complexity : O(N)
 */
package dac;

import java.util.Arrays;

public class CountInversionsII {
        
        private int merge(int[] arr, int[] temp, int p, int q, int r) {
                // Left subarray
                int left[] = Arrays.copyOfRange(arr, p, q + 1);
                // Right subarray
                int right[] = Arrays.copyOfRange(arr, q + 1, r + 1);
                int i = 0, j = 0, k = p, swaps = 0;
                while (i < left.length && j < right.length) {
                        if (left[i] <= right[j]) {
                                arr[k++] = left[i++];
                        } else {
                                arr[k++] = right[j++];
                                swaps += (q + 1) - (p + i);
                        }
                }
                while (i < left.length) {
                        arr[k++] = left[i++];
                }
                while (j < right.length) {
                        arr[k++] = right[j++];
                }
                return swaps;
        }
        private int mergeSort(int[] arr, int[] temp, int p, int r) {
                int inversions = 0;
                if (p < r) {
                        int q = (p + r) / 2;
                        inversions += mergeSort(arr, temp, p, q);
                        inversions += mergeSort(arr, temp,q + 1, r);
                        inversions += merge(arr, temp, p, q, r);
                }
                return inversions;
        }
        
        private int inversions(int[] arr) {
                int[] temp = new int[arr.length];
                return mergeSort(arr, temp, 0, arr.length - 1);
        }
        
        public static void main(String[] args) {
                int[] arr = { 7, 5, 1, 3, 4, 6 };
                System.out.println(new CountInversionsII().inversions(arr));
        }
}

