/**
 * Date 06/05/2022
 *
 * @author akhilpathivada
 *
 * Bubble Sort
 *
 * Time Complexity : O(N ^ 2)
 * Space Complexity : O(1)
 */
package sort;

import java.util.Arrays;

public class BubbleSort {
        private void swap(int[] arr, int i, int j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
        }
        private void sort(int[] arr) {
                for (int i = 0; i < arr.length; ++i) {
                        for (int j = i + 1; j < arr.length; ++j) {
                                if (arr[i] > arr[j]) {
                                        swap(arr, i, j);
                                }
                        }
                }
        }
        public static void main(String[] args) {
                int arr[] = { 64, 34, 25, 12, 22, 11, 90 };
                System.out.println("Given Array" + Arrays.toString(arr));
                new BubbleSort().sort(arr);
                System.out.println("Sorted array" +  Arrays.toString(arr));
        }
}
