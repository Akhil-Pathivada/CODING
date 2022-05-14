/**
 * Date 09/04/2022
 *
 * @author akhilpathivada
 *
 * Get the majority element from a sorted array....
 * Majority Element : element which occurs more than n/3 times
 *
 * https://leetcode.com/problems/majority-element-ii/
 *
 * Moore Voting Algorithm....
 *
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 */
package array;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {
        private static List<Integer> getMajorityElement(int[] nums, int n) {
                // atmost only 2 elements can be of frequency n/3
                int n1 = -1, n2 = -1, c1 = 0, c2 = 0;
                for (int num : nums) {
                        if (num == n1) {
                                ++c1;
                        } else if (num == n2) {
                                ++c2;
                        } else if(c1 == 0) {
                                n1 = num;
                                c1 = 1;
                        } else if(c2 == 0) {
                                n2 = num;
                                c2 = 1;
                        } else {
                                --c1;
                                --c2;
                        }
                }
                List<Integer> result = new ArrayList<>();
                // Checking if majority candidate occurs more than n/3 times
                int count1 = 0, count2 = 0;
                for (int num : nums) {
                        if (num == n1) {
                                ++count1;
                        } else if(num == n2) {
                                ++count2;
                        }
                }
                if (count1 > n/3) {
                        result.add(n1);
                }
                if (count2 > n/3) {
                        result.add(n2);
                }
                return result;
        }
        public static void main(String[] args) {
                int nums[] = { 1, 1, 1, 2, 2, 2, 4 };
                System.out.println(" The majority element is : " + getMajorityElement(nums, nums.length));
        }
}
