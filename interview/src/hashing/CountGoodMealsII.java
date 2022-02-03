/**
 *
 * https://leetcode.com/problems/count-good-meals/
 *
 * Time Complexity : O(N * 22) -> O(N)
 * Space Complexity : O(N)
 * */
package hashing;

import java.util.HashMap;
import java.util.Map;

public class CountGoodMealsII {
        
        static int mod = 1000000007;
        
        private static int countPairs(int[] deliciousness) {
                
                int n = deliciousness.length;
                int result = 0;
                Map<Integer, Integer> map = new HashMap<>();
                for(int x : deliciousness) {
                        int power = 1;
                        for(int p = 0; p <= 21; ++p) {
                                // compute `y`
                                int y = power - x;
                                // found: (x + y) == power of 2
                                if(map.containsKey(y)) {
                                        result += map.get(y);
                                        result %= mod;
                                }
                                power *= 2;
                        }
                        // insert item and its count
                        map.put(x, map.getOrDefault(x, 0) + 1);
                }
                return (int) result;
        }
        public static void main(String[] args) {
                int deliciousness[] = { 1, 1, 1, 3, 3, 3, 7};
                System.out.println(countPairs(deliciousness));
        }
}
