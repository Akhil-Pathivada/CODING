/**
 * https://leetcode.com/problems/climbing-stairs/
 *
 * Time Complexity : O(2 ^ N)
 * Space Complexity : O(N)
 * */

package dp;

public class ClimbingStairsI {
        
        private static int climbStairs(int n) {
                // base case
                if(n <= 1) {
                        return 1;
                }
                return climbStairs(n - 1) + climbStairs(n - 2);
        }
        
        public static void main(String[] args) {
                int stairs = 5;
                System.out.printf("Total ways a person can reach the Top : %d ", climbStairs(stairs));
        }
}
