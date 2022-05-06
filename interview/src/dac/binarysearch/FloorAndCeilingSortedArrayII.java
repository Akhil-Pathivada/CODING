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
 * Time Complexity : O(log(N))
 * Space Complexity : O(1)
 */
package dac.binarysearch;

public class FloorAndCeilingSortedArrayII {
        private static int floor(int[] arr, int x) {
                int low = 0;
                int high = arr.length - 1;
                while (low <= high) {
                        /* get the index of middle element
                        of arr[low..high]*/
                        int mid = low + ((high - low) / 2);
                        /* If x is same as middle element,
                        then return mid */
                        if (arr[mid] == x) {
                                return mid;
                        }
                        /* If x is smaller than arr[mid],
                        then either arr[mid-1] is florring of x
                        or ceiling lies in arr[low...mid-1] */
                        else if(x < arr[mid]) {
                                
                                if(mid - 1 >= low && x >= arr[mid - 1]) {
                                        return mid - 1;
                                }
                                else {
                                        high = mid - 1;
                                }
                        }
                        /* If x is greater than arr[mid], then
                        either arr[mid] is flooring of x or
                        ceiling lies in arr[mid+1...high] */
                        else {
                                if (mid + 1 <= high && x <= arr[mid + 1]) {
                                        return mid;
                                } else {
                                        low = mid + 1;
                                }
                        }
                }
                return -1;
        }
        private static int ceil(int[] arr, int x) {
                int low = 0;
                int high = arr.length - 1;
                while (low <= high) {
                        /* get the index of middle element
                        of arr[low..high]*/
                        int mid = low + ((high - low) / 2);
                        /* If x is same as middle element,
                        then return mid */
                        if (arr[mid] == x) {
                                return mid;
                        }
                        /* If x is smaller than arr[mid],
                        then either arr[mid] is ceiling of x
                        or ceiling lies in arr[low...mid-1] */
                        else if (x < arr[mid]) {
                                
                                if(mid - 1 >= low && x >= arr[mid - 1]) {
                                        
                                        if(x == arr[mid - 1]) {
                                                return mid - 1;
                                        }
                                        return mid;
                                }
                                else {
                                        high = mid - 1;
                                }
                        }
                        /* If x is greater than arr[mid], then
                        either arr[mid + 1] is ceiling of x or
                        ceiling lies in arr[mid+1...high] */
                        else {
                                if(mid + 1 <= high && x <= arr[mid + 1]) {
                                        return mid + 1;
                                } else {
                                        low = mid + 1;
                                }
                        }
                }
                return -1;
        }
        
        public static void main(String[] args) {
                int arr[] = {1, 2, 8, 10, 10, 12, 19};
                int index = ceil(arr, 3);
                System.out.println((index != -1) ? arr[index] : "Ceil not exists");
                index = floor(arr, 7);
                System.out.println((index != -1) ? arr[index] : "Floor not exists");
        }
}
