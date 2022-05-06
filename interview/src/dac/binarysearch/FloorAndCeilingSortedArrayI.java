/**
 * Given a sorted array and a value x, the ceiling of x is the smallest element in array greater than or equal to x, and the floor is the greatest element smaller than or equal to x. Assume than the array is sorted in non-decreasing order. Write efficient functions to find floor and ceiling of x.
 * Examples :
 *
 * For example, let the input array be {1, 2, 8, 10, 10, 12, 19}
 * For x = 0:    floor doesn't exist in array,  ceil  = 1
 * For x = 1:    floor  = 1,  ceil  = 1
 * For x = 5:    floor  = 2,  ceil  = 8
 * For x = 20:   floor  = 19,  ceil doesn't exist in array
 *
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 */
package dac.binarysearch;

public class FloorAndCeilingSortedArrayI {
        private static int ceil(int[] arr, int x) {
                
                for(int ele : arr) {
                        if(ele >= x) {
                                return ele;
                        }
                }
                /* If we reach here then x is greater than the
                last element of the array,  return -1 in this case */
                return -1;
        }
        private static int floor(int[] arr, int x) {
                for(int i = arr.length - 1; i >= 0; --i) {
                        if(arr[i] <= x) {
                                return arr[i];
                        }
                }
               /* If we reach here then x is lesser than the
                start element of the array,  return -1 in this case */
                return -1;
        }
        public static void main(String[] args) {
                int arr[] = {1, 2, 5, 6, 11, 15};
                System.out.println(floor(arr, 3));
                System.out.println(ceil(arr, 7));
        }
}
