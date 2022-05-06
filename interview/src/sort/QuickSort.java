/**
 * Date 06/04/2022
 *
 * @author akhilpathivada
 *
 * Quick Sort Algorithm
 *
 * Best Case :
 *      Time Complexity : N * log(N)
 *      Space Complexity : log(N)
 *
 * Worst Case :
 *      Time Complexity : O(N ^ 2)
 *      Space Complexity : O(N)
 */
package sort;

import java.util.Arrays;

public class QuickSort {
        private void swap(int[] arr, int i, int j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
        }
        /** This function takes last element as pivot, places
        the pivot element at its correct position in sorted
        array, and places all smaller (smaller than pivot)
        to left of pivot and all greater elements to right of pivot */
        private int partition(int[] arr, int low, int high) {
                int x = arr[high];
                int i = low - 1;
                for (int j = low; j < high; ++j) {
                        // if current element is smaller than the pivot
                        if (arr[j] <= x) {
                                swap(arr, ++i, j);
                        }
                }
                swap(arr, ++i, high);
                return i;
        }
        private void sort(int[] arr, int low, int high) {
                if(low < high) {
                        // pivot is partitioning index, arr[p] is now at right place
                        int pivot = partition(arr, low, high);
                        // separately sort elements before partition and after partition
                        sort(arr, low, pivot - 1);
                        sort(arr, pivot + 1, high);
                }
        }
        public static void main(String args[]) {
                int arr[] = { 12, 11, 13, 5, 6, 7 };
                System.out.println("Given Array" + Arrays.toString(arr));
                new QuickSort().sort(arr, 0, arr.length - 1);
                System.out.println("Sorted array" +  Arrays.toString(arr));
        }
}
