/**
 * https://www.geeksforgeeks.org/count-pairs-difference-equal-k/
 * Given an integer array and a positive integer k, count all distinct pairs with differences equal to k.
 *
 * Hashing Approach
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 * */
package array;

import java.util.HashMap;

public class CountDistinctPairsOfDifferenceKIV {
        
        private static int countPairsWithDiffK(int[] arr, int n, int k) {
                
                int count = 0;
                HashMap<Integer, Integer> hashMap = new HashMap<>();
                
                for(int i = 0; i < n; ++i) {
                        
                        if(hashMap.containsKey(arr[i] - k)) {
                                count += hashMap.get(arr[i] - k);
                        }
                        else if (hashMap.containsKey(arr[i] + k)) {
                                count += hashMap.get(arr[i] + k);
                        }
                        hashMap.put(arr[i], hashMap.getOrDefault(arr[i], 0) + 1);
                }
                return count;
        }
        
        public static void main(String[] args) {
                
                int arr[] = { 1, 2, 2, 1 };
                int n = arr.length;
                int k = 3;
                
                System.out.println("Count of pairs with given diff is " + countPairsWithDiffK(arr, n, k));
        }
}
