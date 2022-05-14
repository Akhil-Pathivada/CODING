/**
 * Seperate the ZEROs to the LEFT && ONEs to the RIGHT side of the Array
 *
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 * */
package array;

import java.util.Arrays;

public class SeparateZerosOnes {
        private void separateZerosOnes(int[] arr) {
                int left = 0, right = arr.length - 1;
                while (left < right) {
                        // Increment left index while we see 0 at left
                        while (arr[left] == 0 && left < right) {
                                ++left;
                        }
                        // Decrement right index while we see 1 at right
                        while (arr[right] == 1 && left < right) {
                                --right;
                        }
                        // If left is smaller than right then there is a 1 at left
                        // and a 0 at right. Exchange arr[left] and arr[right]
                        if (left < right) {
                                // swap numbers
                                arr[left] = 0;
                                arr[right] = 1;
                                ++left;
                                --right;
                        }
                }
        }
        public static void main(String[] args) {
                int arr[] = {1, 0, 1, 0, 1, 0, 0, 1};
                new SeparateZerosOnes().separateZerosOnes(arr);
                System.out.println(Arrays.toString(arr));
        }
}
