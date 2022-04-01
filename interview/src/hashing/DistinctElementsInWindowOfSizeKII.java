/**
 * Date 01/04/2022
 *
 * @author akhilpathivada
 *
 * https://www.geeksforgeeks.org/count-distinct-elements-in-every-window-of-size-k/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 */
package hashing;

import java.util.HashMap;

public class DistinctElementsInWindowOfSizeKII {
        
        private static void countDistinct(int[] arr, int k) {
        
                HashMap<Integer, Integer> hashMap = new HashMap<>();
                // Traverse the first window and store count of every element in hash ma
                for(int i = 0; i < k; ++i) {
                        hashMap.put(arr[i], hashMap.getOrDefault(arr[i], 0) + 1);
                }
                // Print count of first window
                System.out.print(hashMap.size() + ", ");
                // Traverse through the remaining array
                for(int i = k; i < arr.length; ++i) {
                        // Remove first element of previous window : if there was only one occurrence
                        if(hashMap.get(arr[i - k]) == 1) {
                                hashMap.remove(arr[i - k]);
                        }
                        else { // reduce count of the removed element
                                hashMap.put(arr[i - k], hashMap.getOrDefault(arr[i - k], 0) - 1);
                        }
                        // Add new element of current window If this element appears first time, set its count as 1
                        hashMap.put(arr[i], hashMap.getOrDefault(arr[i], 0)  + 1);
                        // Print count of current window
                        System.out.print(hashMap.size() + ", ");
                }
        }
        
        public static void main(String[] args) {
        
                int arr[] = { 1, 2, 1, 3, 4, 2, 3 }, k = 4;
                countDistinct(arr, k);
        }
}
