/**
 * Date 08/04/2022
 *
 * @author akhilpathivada
 *
 * https://www.geeksforgeeks.org/edit-distance-dp-5/
 *
 * Time Complexity : O(m * n)
 * Space Complexity : O(m * n)
 *
 */
package dp;

public class EditDistanceProblemII {
        
        private static int min(int a, int b, int c) {
                return (a < b) ? (a < c ? a : c) : (b < c ? b : c);
        }
        
        private static int minOperations(char[] X, char[] Y, int m, int n) {
                // Create a table to store results of subproblems
                int[][] table = new int[m + 1][n + 1];
                for(int i = 0; i <= m; ++i) {
                        for(int j = 0; j <= n; ++j) {
                                // If first string is empty, only option is
                                // to insert all characters of second string
                                if(i == 0) {
                                        table[i][j] = j;
                                }
                                // If second string is empty, only option is
                                // to remove all characters of second string
                                else if(j == 0) {
                                        table[i][j] = i;
                                }
                                // If last characters are same, ignore last
                                // char and recur for remaining string
                                else if(X[i - 1] == Y[j - 1]) {
                                        table[i][j] = table[i - 1][j - 1];
                                }
                                // If the last character is different,
                                // consider all possibilities and find the minimum
                                else {
                                        table[i][j] = 1 + min(
                                                table[i][j - 1], // Insert
                                                table[i - 1][j], // Remove
                                                table[i - 1][j - 1]); // Replace
                                }
                        }
                }
                return table[m][n];
        }
        
        public static void main(String[] args) {
                String X = "sunday";
                String Y = "saturday";
                System.out.printf("Min. Operations required = %d", minOperations(X.toCharArray(), Y.toCharArray(), X.length(), Y.length()));
        }
}
