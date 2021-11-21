/**
 * https://leetcode.com/problems/candy/
 *
 * 1 - Array Approach
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 * */

package misc;

import java.util.Arrays;

public class MinimumCandiesDistributionII {
        
        private static int minCandies(int[] ratings) {
                
                int candies = 0; // min candies
                int n = ratings.length;
                // stores final results
                int[] C = new int[n];
                // filling intial values
                Arrays.fill(C, 1);
                // compute candies based on left neighbour
                for(int i = 1; i < n; ++i) {
                        if(ratings[i] > ratings[i - 1]) {
                                C[i] = C[i - 1] + 1;
                        }
                }
                // compute candies based on right neighbour
                for(int i = n - 2; i >= 0; --i) {
                        if(ratings[i] > ratings[i + 1]) {
                                C[i] = Math.max(C[i + 1] + 1, C[i]);
                        }
                }
                // Sum of all candies
                for(int i = 0; i < n; ++i) {
                        candies += C[i];
                }
                return candies;
        }
        
        public static void main(String[] args) {
                
                int[] ratings = {1, 0, 2};
                System.out.println(minCandies(ratings));
        }
}
