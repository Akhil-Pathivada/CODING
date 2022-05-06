/**
 * Date 06/04/2022
 *
 * @author akhilpathivada
 *
 * Insertion Sort Algorithm
 *
 * Time Complexity : O(N ^ 2)
 * Space Complexity : O(1)
 */
package sort;

import java.util.Arrays;

public class InsertionSort {
        private void sort(int[] arr, int n) {
                int i, j, key;
                // picking up all the elements;
                for (i = 1; i < n; ++i) {
                        key = arr[i];
                        // Move elements of arr[0..i-1], that are greater than key, to one position ahead
                        // of their current position
                        for (j = i - 1; j >= 0 && arr[j] > key; --j) {
                                arr[j + 1] = arr[j];
                        }
                        arr[j + 1] = key;
                }
        }
        public static void main(String args[]) {
                int arr[] = { 12, 11, 13, 5, 6, 7 };
                System.out.println("Given Array" + Arrays.toString(arr));
                new InsertionSort().sort(arr, arr.length);
                System.out.println("Sorted array" +  Arrays.toString(arr));
        }
}
