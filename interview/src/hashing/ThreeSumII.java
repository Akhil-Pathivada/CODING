/**
 * https://www.geeksforgeeks.org/find-a-triplet-that-sum-to-a-given-value/
 *
 * Time Complexity : O(N ^ 2)
 * Space Complexity : O(1)
 * */
package hashing;

import java.util.Arrays;

public class ThreeSumII {
        private static void printTriplets(int[] arr, int sum) {
                int n = arr.length;
                Arrays.sort(arr);
                // Now fix the first element one by one and find the other two elements
                for (int i = 0; i < n - 2; ++i) {
                        /** To find the other two elements, start two index variables
                        from two corners of the array and move them toward each other */
                        int low = i + 1; // index of the first element in the remaining elements
                        int high = n - 1; // index of the last element
                        while (low < high) {
                                // triplet found
                                if (arr[i] + arr[low] + arr[high] == sum) {
                                        System.out.println(arr[i] + ", " + arr[low] + ", " + arr[high]);
                                        ++low; --high;
                                } else if (arr[i] + arr[low] + arr[high] < sum) {
                                        ++low;
                                } else {
                                        --high;
                                }
                        }
                }
        }
        public static void main(String[] args) {
                int[] arr = { 1, 4, 45, 6, 10, 8 };
                int sum = 22;
                printTriplets(arr, sum);
        }
}
