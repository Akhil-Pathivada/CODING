/**
 * https://www.geeksforgeeks.org/count-pairs-difference-equal-k/
 * Given an integer array and a positive integer k, count all distinct pairs with differences equal to k.
 *
 * Two Pointer Approach
 *
 * Time Complexity : O(N * log(N))
 * Space Complexity : O(1)
 * */

package array;

import java.util.Arrays;

public class CountDistinctPairsOfDifferenceKIII {
        
        private static int countPairsWithDiffK(int[] arr, int n, int k) {
                
                int count = 0;
                // sort the given array
                Arrays.sort(arr);
                // intialize both pointers to start
                int l = 0;
                int r = 0;
                
                while(r < n) {
                        
                        if (arr[r] - arr[l] == k) {
                                ++count;
                                ++l;
                                ++r;
                        }
                        else if (arr[r] - arr[l] > k) {
                                ++l;
                        }
                        else { // arr[r] - arr[l] < k
                                ++r;
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
