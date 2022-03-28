/**
 * https://leetcode.com/problems/contains-duplicate-ii/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(K)
 * */
package slidingwindow;

import java.util.HashSet;

public class DuplicatesInKDistance {
        
        private static boolean containsNearbyDuplicate(int[] nums, int k) {
                
                int n = nums.length;
                HashSet<Integer> hashSet = new HashSet<Integer>(k);
                for(int i = 0; i < n; ++i) {
                        // duplicate found in distance k
                        if(hashSet.contains(nums[i])) {
                                return true;
                        }
                        hashSet.add(nums[i]);
                        // slide the window
                        if(i >= k) {
                                hashSet.remove(nums[i - k]);
                        }
                }
                return false;
        }
        
        public static void main(String[] args) {
        
                int nums[] = {1, 2, 3, 4, 4, 5}, k = 3;
                System.out.println(containsNearbyDuplicate(nums, k));
        }
}
