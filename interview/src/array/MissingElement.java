/**
 * Date 19/04/2022
 *
 * @author akhilpathivada
 *
 * http://www.ardendertat.com/2011/09/27/programming-interview-questions-4-find-missing-element/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 */
package array;

public class MissingElement {
        private int find(int[] arr1, int[] arr2) {
                int result = 0;
                for (int num : arr1) {
                        result ^= num;
                }
                for (int num : arr2) {
                        result ^= num;
                }
                return result;
        }
        public static void main(String[] args) {
                int[] arr1 = { 4, 1, 0, 2, 9, 6, 8, 7, 5, 3 };
                int[] arr2 = { 6, 4, 7, 2, 1, 0, 8, 3, 9 };
                System.out.printf("Missing element = %d ", new MissingElement().find(arr1, arr2));
        }
}
