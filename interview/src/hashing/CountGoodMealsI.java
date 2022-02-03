/**
 *
 * https://leetcode.com/problems/count-good-meals/
 *
 * Time Complexity : O(N ^ 2)
 * Space Complexity : O(1)
 * */
package hashing;

public class CountGoodMealsI {
        
        // Method to check if x is power of 2
        private static boolean isPowerOfTwo(int x) {
                // First x in the below expression is for the case when x is 0
                return x != 0 && ((x & (x - 1)) == 0);
        }
        
        private static int countPairs(int[] deliciousness) {
        
                int n = deliciousness.length;
                int result = 0;
                for(int i = 0; i < n; ++i) {
                        for(int j = i + 1; j < n; ++j) {
                                // found
                                if(isPowerOfTwo(deliciousness[i] + deliciousness[j])) {
                                        ++result;
                                }
                        }
                }
                return result;
        }
        public static void main(String[] args) {
                int deliciousness[] = { 1, 1, 1, 3, 3, 3, 7};
                System.out.println(countPairs(deliciousness));
        }
}
