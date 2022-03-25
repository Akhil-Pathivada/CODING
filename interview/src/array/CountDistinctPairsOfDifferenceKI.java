/**
 * https://www.geeksforgeeks.org/count-pairs-difference-equal-k/
 * Given an integer array and a positive integer k, count all distinct pairs with differences equal to k.
 *
 * Brute - Force Approach
 *
 * Time Complexity : O(N ^ 2)
 * Space Complexity : O(1)
 * */

package array;

public class CountDistinctPairsOfDifferenceKI {
        
        private static int countPairsWithDiffK(int[] arr, int n, int k) {
                
                int count = 0;
                
                for(int i = 0; i < n; ++i) {
                        for(int j = i + 1; j < n; ++j) {
                                if(Math.abs(arr[i] - arr[j]) == k) {
                                        ++count;
                                }
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
