/**
 * Regular Binary Search
 * Time Complexity : O(log(N))
 * Space Complexity : O(1)
 */
package dac.binarysearch;
public class BinarySearch {
        private int search(final int[] arr, int target) {
                int low = 0, high = arr.length - 1;
                while (low <= high) {
                        int mid = low + ((high - low) / 2);
                        if (arr[mid] == target) {
                                return mid;
                        } else if (arr[mid]  < target) {
                                low = mid + 1;
                        } else {
                                high = mid - 1;
                        }
                }
                return -1;
        }
        public static void main(String[] args) {
                BinarySearch binSearch = new BinarySearch();
                final int arr[] = {1, 2, 4, 5, 7, 8};
                System.out.println(binSearch.search(arr, 7));
        }
}
