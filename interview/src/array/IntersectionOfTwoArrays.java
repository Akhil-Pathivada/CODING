/**
 *
 * https://leetcode.com/problems/intersection-of-two-arrays/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 * */
package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {
        
        private static int[] intersectionOfArrays(int[] nums1, int[] nums2) {
        
                Set<Integer> set = new HashSet<>();
                Set<Integer> intersect = new HashSet<>();
                // insert all elements into set
                for(int i : nums1) {
                        set.add(i);
                }
                for(int i : nums2) {
                        // intersection element found: insert into intersection set
                        if(set.contains(i)) {
                                intersect.add(i);
                        }
                }
                int[] result = new int[intersect.size()];
                int i = 0;
                // add to result array
                for(int num : intersect) {
                        result[i++] = num;
                }
                return result;
        }
        
        public static void main(String[] args) {
                
                int nums1[] = { 4, 9, 5};
                int nums2[] = { 9, 4, 9, 8, 4};
                System.out.println(Arrays.toString(intersectionOfArrays(nums1, nums2)));
        }
}
