/**
 * Date 13/04/2022
 *
 * @author akhilpathivada
 *
 * https://www.geeksforgeeks.org/program-for-nth-fibonacci-number/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 *
 */
package dp;

public class FibonacciNumberII {
        
        private int fibonacci(int n) {
                // base case
                if(n <= 1) {
                        return n;
                }
                int dp[] = new int[n + 1];
                dp[0] = 0;
                dp[1] = 1;
                for(int i = 2; i <= n; ++i){
                        dp[i] = dp[i - 1] + dp[i - 2];
                }
                return dp[n];
        }
        
        public static void main(String[] args) {
                int n = 9;
                System.out.println(new FibonacciNumberII().fibonacci(n));
        }
}
