/**
 *
 * You are given an array of n+2 elements.
 * All elements of the array are in range 1 to n.
 * And all elements occur once except two numbers which occur twice. Find the two repeating numbers.
 *
 * Time Complexity ::O(N)
 * Space Complexity : O(1)
 * */
package array;

public class TwoRepeatingNumbers {
        private void printTwoRepeatingNumbers(int[] arr) {
                for (int i = 0; i < arr.length; ++i) {
                        // duplicate found
                        if (arr[Math.abs(arr[i])] < 0) {
                                System.out.print(Math.abs(arr[i]) + ", ");
                        } else { // change the sign
                                arr[Math.abs(arr[i])] = -1 * arr[Math.abs(arr[i])];
                        }
                }
        }
        public static void main(String[] args) {
                int[] arr = { 1, 2, 4, 3, 1, 3 };
                new TwoRepeatingNumbers().printTwoRepeatingNumbers(arr);
        }
}
