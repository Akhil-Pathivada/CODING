/**
 * Date 08/04/2022
 *
 * @author akhilpathivada
 *
 * https://www.geeksforgeeks.org/edit-distance-dp-5/
 *
 * Time Complexity : O(3 ^ max(m, n))
 */
package dp;

public class EditDistanceProblemI {
        
        private static int min(int a, int b, int c) {
                return (a < b) ? (a < c ? a : c) : (b < c ? b : c);
        }
        
        private static int minOperations(char[] X, char[] Y, int m, int n) {
                // If first string is empty, the only option is to
                // insert all characters of second string into first
                if(m == 0) {
                        return n;
                }
                // If second string is empty, the only option is to
                // remove all characters of first string
                if(n == 0) {
                        return m;
                }
                // If last characters of two strings are same, nothing much to do.
                // Ignore last characters and get count for remaining strings.
                if(X[m - 1] == Y[n - 1]) {
                        return minOperations(X, Y, m - 1, n - 1);
                }
                // If last characters are not same, consider all three operations on last character of first string,
                // recursively compute minimum cost for all three operations and take minimum of three values. */
                return 1 + min(
                        minOperations(X, Y, m, n - 1), // insert
                        minOperations(X, Y, m - 1, n), // remove
                        minOperations(X, Y, m - 1, n - 1) // replace
                );
        }
        
        public static void main(String[] args) {
                String X = "sunday";
                String Y = "saturday";
                System.out.printf("Min. Operations required = %d", minOperations(X.toCharArray(), Y.toCharArray(), X.length(), Y.length()));
        }
}
