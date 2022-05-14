/**
 * Date 09/04/2022
 *
 * @author akhilpathivada
 *
 * Get the majority element from a sorted array....
 * Majority Element : element which occurs more than n/2 times
 *
 * Moore Voting Algorithm....
 *
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 */
package array;

public class MajorityElementI {
        private int getMajorityElement(int[] nums, int n) {
                int voter = -1, votes = 0;
                for (int num : nums) {
                        if (votes == 0) {
                                voter = num;
                                votes = 1;
                        } else {
                                if (num == voter) {
                                        ++votes;
                                } else {
                                        --votes;
                                }
                        }
                }
                // Checking if majority candidate occurs more than n/2 times
                int count = 0;
                for (int num : nums) {
                        if (num == voter) {
                                ++count;
                        }
                }
                if (count > n/2) {
                        return voter;
                }
                return -1;
        }
        public static void main(String[] args) {
                int nums[] = { 1, 1, 1, 1, 2, 3, 4 };
                System.out.println(" The majority element is : " + new MajorityElementI().getMajorityElement(nums, nums.length));
        }
}
