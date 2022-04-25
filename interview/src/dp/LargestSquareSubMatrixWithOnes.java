/**
 * Date 25/04/2022
 *
 * @author akhilpathivada
 *
 * https://www.geeksforgeeks.org/maximum-size-sub-matrix-with-all-1s-in-a-binary-matrix/
 *
 * Time Complexity : O(m * n)
 * Space Complexity : O(m * n)
 */
package dp;

public class LargestSquareSubMatrixWithOnes {
        
        private void printLargestSubSquare(int[][] M) {
                int m = M.length, n = M[0].length;
                int S[][] = new int[m][n];
                for (int i = 0; i < m; ++i) {
                        S[i][0] = M[i][0];
                }
                for (int j = 0; j < n; ++j) {
                        S[0][j] = M[0][j];
                }
                for (int i = 1; i < m; ++i) {
                        for (int j = 1; j < n; ++j) {
                                if (M[i][j] == 1) {
                                        S[i][j] = 1 + Math.min(S[i][j - 1],
                                                 Math.min(S[i - 1][j], S[i - 1][j - 1])
                                        );
                                } else {
                                        S[i][j] = 0;
                                }
                        }
                }
                // Find the maximum entry, and indexes of maximum entry in S[][]
                int max_of_s = S[0][0], max_i = 0, max_j = 0;
                for (int i = 0; i < m; ++i) {
                        for (int j = 0; j < n; ++j) {
                                if (S[i][j] > max_of_s) {
                                        max_of_s = S[i][j];
                                        max_i = i;
                                        max_j = j;
                                }
                        }
                }
                System.out.println("Maximum size sub-matrix is: ");
                for (int i = max_i; i > max_i - max_of_s; --i) {
                        for (int j = max_j; j > max_j - max_of_s; --j) {
                                System.out.print(M[i][j] + " ");
                        }
                        System.out.println();
                }
        }
        
        public static void main(String[] args) {
                int M[][] = {
                        {0, 1, 1, 0, 1},
                        {1, 1, 0, 1, 0},
                        {0, 1, 1, 1, 0},
                        {1, 1, 1, 1, 0},
                        {1, 1, 1, 1, 1},
                        {0, 0, 0, 0, 0}
                };
                new LargestSquareSubMatrixWithOnes().printLargestSubSquare(M);
        }
}
