/**
 * https://leetcode.com/problems/candy/
 *
 * 2 - Arrays Approach
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 * */

package misc;

import java.util.Arrays;

public class MinimumCandiesDistributionI {
        
        private static int minCandies(int[] ratings) {
                
                int candies = 0; // min candies
                int n = ratings.length;
                int[] L = new int[n];
                int[] R = new int[n];
                // filling intial values
                Arrays.fill(L, 1);
                Arrays.fill(R, 1);
                // compute candies based on left neighbour
                for(int i = 1; i < n; ++i) {
                        if(ratings[i] > ratings[i - 1]) {
                                L[i] = L[i - 1] + 1;
                        }
                }
                // compute candies based on right neighbour
                for(int i = n - 2; i >= 0; --i) {
                        if(ratings[i] > ratings[i + 1]) {
                                R[i] = R[i + 1] + 1;
                        }
                }
                //Merge both the sides
                for(int i = 0; i < n; ++i) {
                        candies += Math.max(L[i], R[i]);
                }
                return candies;
        }
        
        public static void main(String[] args) {
                
                int[] ratings = {1, 0, 2};
                System.out.println(minCandies(ratings));
        }
}
