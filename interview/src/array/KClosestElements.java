/**
 * https://leetcode.com/problems/find-k-closest-elements/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 * */
package array;

import java.util.ArrayList;
import java.util.List;

public class KClosestElements {
        private List<Integer> findKClosestElements(int[] arr, int k, int x) {
                int low = 0;
                int high = arr.length - 1;
                // since array is given sorted, `k` elements nearer to `x` will be as a contiguous array
                while (high - low >= k) {
                        if (Math.abs(arr[low]- x) > Math.abs(arr[high] - x)) {
                                ++low;
                        } else {
                                --high;
                        }
                }
                List<Integer> result = new ArrayList<Integer>(k);
                while (low <= high) {
                        result.add(arr[low++]);
                }
                return result;
        }
        public static void main(String[] args) {
                int arr[] = {1, 2, 3, 4, 5};
                int k = 4, x = -1;
                System.out.println(new KClosestElements().findKClosestElements(arr, k, x));
        }
}
