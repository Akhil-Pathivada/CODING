/**
 * Date 22/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/search-a-2d-matrix/
 *
 * Time Complexity : O(m + n)
 * Space Complexity : O(1)
 */
package matrix;

public class Search2DMatrixI {
        
        private boolean searchMatrix(int[][] matrix, int target) {
                int m = matrix.length, n = matrix[0].length;
                int i = 0, j = n - 1;
                while(i < m && j >= 0) {
                        if(matrix[i][j] == target) { // found
                                return true;
                        } else if(matrix[i][j] > target) { // move left
                                --j;
                        } else { // move down
                                ++i;
                        }
                }
                return false;
        }
        
        public static void main(String[] args) {
                int[][] matrix = {
                        { 1, 3, 5, 7 },
                        { 10, 11, 16, 20 },
                        { 23, 30, 34, 60 }
                };
                int target = 3;
                System.out.println(new Search2DMatrixI().searchMatrix(matrix, target));
        }
}
