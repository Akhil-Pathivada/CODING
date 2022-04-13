/**
 * Date 13/04/2022
 *
 * @author akhilpathivada
 *
 * https://www.geeksforgeeks.org/program-for-nth-fibonacci-number/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 *
 */
package dp;

public class FibonacciNumberIII {
        
        private int fibonacci(int n) {
                // base case
                if(n <= 1) {
                        return n;
                }
                int a = 0, b = 1, c;
                for(int i = 2; i <= n; ++i) {
                        c = a + b;
                        a = b;
                        b = c;
                }
                return b;
        }
        
        public static void main(String[] args) {
                int n = 9;
                System.out.println(new FibonacciNumberIII().fibonacci(n));
        }
}
