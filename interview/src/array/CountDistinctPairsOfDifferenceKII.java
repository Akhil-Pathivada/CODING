/**
 * https://www.geeksforgeeks.org/count-pairs-difference-equal-k/
 * Given an integer array and a positive integer k, count all distinct pairs with differences equal to k.
 *
 * Binary Search Approach
 *
 * Time Complexity : O(N * log(N))
 * Space Complexity : O(1)
 * */

package array;

import java.util.Arrays;

public class CountDistinctPairsOfDifferenceKII {
        
        private static int binarySearch(int[] arr, int low, int high, int x) {
                
                while(low <= high) {
                        
                        int mid = low + (high - low) / 2;
                        
                        if(arr[mid] == x) {
                                return mid - 1;
                        }
                        else if(x < arr[mid]) {
                                high = mid - 1;
                        }
                        else {
                                low = mid + 1;
                        }
                }
                return -1;
        }
        
        private static int countPairsWithDiffK(int[] arr, int n, int k) {
                
                int count = 0;
                // sort the given array
                Arrays.sort(arr);
                
                for(int i = 0; i < n; ++i) {
                        /* do Binary Search instead of Linear search
                        if arr[i] + k is found, increment count... */
                        if(binarySearch(arr, i + 1, n - 1, arr[i] + k) != -1) {
                                ++count;
                        }
                }
                return count;
        }
        
        public static void main(String[] args) {
                
                int arr[] = { 1, 5, 3, 4, 2 };
                int n = arr.length;
                int k = 3;
                
                System.out.println("Count of pairs with given diff is " + countPairsWithDiffK(arr, n, k));
        }
}
