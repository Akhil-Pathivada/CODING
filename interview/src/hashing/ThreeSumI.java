/**
 * https://www.geeksforgeeks.org/find-a-triplet-that-sum-to-a-given-value/
 *
 * Time Complexity : O(N ^ 3)
 * Space Complexity : O(1)
 * */
package hashing;

public class ThreeSumI {
        private static void printTriplets(int[] arr, int sum) {
                int n = arr.length;
                for (int i = 0; i < n; ++i) {
                        for (int j = i + 1; j < n; ++j) {
                                for (int k = j + 1; k < n; ++k) {
                                        // triplet found
                                        if (arr[i] + arr[j] + arr[k] == sum) {
                                                System.out.println(arr[i] + ", " + arr[j] + ", " + arr[k]);
                                        }
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
