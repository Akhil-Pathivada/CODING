/**
 * Date 23/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/find-the-duplicate-number/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 */
package array;

public class DuplicateNumber {
        private int findDuplicate(int[] nums) {
                int slow = nums[0];
                int fast = nums[0];
                do {
                        slow = nums[slow];
                        fast = nums[nums[nums[fast]]];
                } while (slow != fast);
                slow = nums[0];
                while (slow != fast) {
                        slow = nums[slow];
                        fast = nums[fast];
                }
                return slow;
        }
        public static void main(String[] args) {
                int[] nums = { 1, 3, 4, 2, 2 };
                System.out.println(new DuplicateNumber().findDuplicate(nums));
        }
}
