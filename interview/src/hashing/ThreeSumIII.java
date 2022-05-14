/**
 * https://www.geeksforgeeks.org/find-a-triplet-that-sum-to-a-given-value/
 *
 * Time Complexity : O(N ^ 2)
 * Space Complexity : O(N)
 * */
package hashing;

import java.util.Arrays;
import java.util.HashSet;

public class ThreeSumIII {
        private static void printTriplets(int[] arr, int sum) {
                int n = arr.length;
                // Fix the first element as A[i]
                for (int i = 0; i < n - 2; ++i) {
                        HashSet<Integer> set = new HashSet<Integer>();
                        // Find pair in subarray A[i+1..n-1] with sum equal to sum - A[i]
                        int curr_sum = sum - arr[i];
                        for (int j = i + 1; j < n; ++j) {
                                // triplet found
                                if (set.contains(curr_sum - arr[j])) {
                                        System.out.printf("%d, %d, %d", arr[i], arr[j], curr_sum - arr[j]);
                                        
                                }
                                set.add(arr[j]);
                        }
                }
        }
        public static void main(String[] args) {
                int[] arr = { 1, 4, 45, 6, 10, 8 };
                int sum = 22;
                printTriplets(arr, sum);
        }
}
