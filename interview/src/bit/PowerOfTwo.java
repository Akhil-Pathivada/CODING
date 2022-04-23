/**
 * Date 23/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/power-of-two/
 *
 * Time Complexity : O(1)
 */
package bit;

public class PowerOfTwo {
        private boolean isPowerOfTwo(int n) {
                if (n <= 0) {
                        return false;
                }
                return (n & (n - 1)) == 0;
        }
        public static void main(String[] args) {
                int n = 16;
                System.out.println(new PowerOfTwo().isPowerOfTwo(n));
        }
}
