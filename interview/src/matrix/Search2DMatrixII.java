/**
 * Date 22/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/search-a-2d-matrix/
 *
 * Time Complexity : O(log(m * n))
 * Space Complexity : O(1)
 */
package matrix;

public class Search2DMatrixII {
        
        private boolean searchMatrix(int[][] matrix, int target) {
                int m = matrix.length, n = matrix[0].length;
                int low = 0, high = (m * n) - 1;
                while(low <= high) {
                        int mid = (low + (high - low) / 2);
                        if(matrix[mid / n][mid % n] == target) {
                                return true;
                        } else if(matrix[mid / n][mid % n] < target) {
                                low = mid + 1;
                        } else {
                                high = mid - 1;
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
                System.out.println(new Search2DMatrixII().searchMatrix(matrix, target));
        }
}
