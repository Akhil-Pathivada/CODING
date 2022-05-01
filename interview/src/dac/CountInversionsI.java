/**
 * Date 01/05/2022
 *
 * @author akhilpathivada
 *
 * https://www.geeksforgeeks.org/counting-inversions/
 *
 * Time Complexity : O(N ^ 2)
 * Space Complexity : O(1)
 */
package dac;

public class CountInversionsI {
        
        private int inversions(int[] arr) {
                int count = 0;
                for (int i = 0; i < arr.length; ++i) {
                        for (int j = i + 1; j < arr.length; ++j) {
                                if (arr[j] < arr[i]) {
                                        ++count;
                                }
                        }
                }
                return count;
        }
        
        public static void main(String[] args) {
                int[] arr = { 7, 5, 1, 3, 4, 6 };
                System.out.println(new CountInversionsI().inversions(arr));
        }
}
