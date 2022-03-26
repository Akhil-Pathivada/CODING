/**
 * Seperate the ZEROs to the LEFT && ONEs to the RIGHT side of the Array
 *
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 * */
package array;

import java.util.Arrays;

public class SeparateZerosOnes {
        
        private static void separateZerosOnes(int[] arr) {
                
                int left = 0, right = arr.length - 1;
                
                while(left < right) {
                        
                        while(arr[left] == 0 && left < right) {
                                ++left;
                        }
                        while(arr[right] == 1 && left < right) {
                                --right;
                        }
                        if(left < right) {
                                // swap numbers
                                arr[left] = 0;
                                arr[right] = 1;
                                
                                ++left; --right;
                        }
                }
        }
        
        public static void main(String[] args) {
                
                int arr[] = {1, 0, 1, 0, 1, 0, 0, 1};
                separateZerosOnes(arr);
                System.out.println(Arrays.toString(arr));
        }
}
