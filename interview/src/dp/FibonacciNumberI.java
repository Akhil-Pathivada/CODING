/**
 * Date 13/04/2022
 *
 * @author akhilpathivada
 *
 * https://www.geeksforgeeks.org/program-for-nth-fibonacci-number/
 *
 * Time Complexity : O(2 ^ N)
 * Space Complexity : O(N)
 *
 */
package dp;

public class FibonacciNumberI {
        
        private int fibonacci(int n) {
                // base case
                if(n <= 1) {
                        return n;
                }
                return fibonacci(n - 1) + fibonacci(n -2 );
        }
        
        public static void main(String[] args) {
                int n = 9;
                System.out.println(new FibonacciNumberI().fibonacci(n));
        }
}
