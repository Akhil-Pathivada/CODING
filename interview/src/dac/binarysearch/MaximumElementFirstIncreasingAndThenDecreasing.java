/**
 * Date 05/05/2022
 *
 * @author akhilpathivada
 *
 * https://www.geeksforgeeks.org/find-the-maximum-element-in-an-array-which-is-first-increasing-and-then-decreasing/
 *
 * Time Complexity : O(log(N))
 * Space Complexity : O(1)
 */
package dac.binarysearch;

public class MaximumElementFirstIncreasingAndThenDecreasing {
        private int maxInBitonic(int[] arr) {
                int low = 0, high = arr.length - 1;
                while (low <= high) {
                        int mid = (low + high) / 2;
                        // If there are two elements return the maximum
                        if (high == low + 1) {
                                return Math.max(arr[low], arr[high]);
                        }
                        // If we reach a point where arr[mid] is greater
                        // than both of its adjacent elements arr[mid-1] and
                        // arr[mid+1], then arr[mid] is the maximum element
                        if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                                return arr[mid];
                        }
                        if (arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1]) { // target exists in right side
                                low = mid + 1;
                        } else { // left side
                                high = mid - 1;
                        }
                }
                return -1;
        }
        public static void main(String[] args) {
                int arr[] = { 1, 3, 50, 10, 9, 7, 6 };
                System.out.println("The maximum element is " + new MaximumElementFirstIncreasingAndThenDecreasing().maxInBitonic(arr));
        }
}
