/**
 * Date 22/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/rotting-oranges/
 *
 * Time Complexity : O(m * n)
 * Space Complexity : O(m * n)
 */
package graph;

public class RottingOranges {
        private void DFS(int[][] grid, int i, int j, int m, int n, int minutes) {
                // anchor condition
                if (i < 0 || i >= m || j < 0 || j >= n // out of bounds
                        || grid[i][j] == 0 // empty cell
                        || (grid[i][j] > 1 && grid[i][j] < minutes) // this orange is already rotten by another rotten orange
                ) {
                        return;
                }
                grid[i][j] = minutes;
                DFS(grid, i + 1, j, m, n, minutes + 1);
                DFS(grid, i - 1, j, m, n, minutes + 1);
                DFS(grid, i, j + 1, m, n, minutes + 1);
                DFS(grid, i , j - 1, m, n, minutes + 1);
        }
        private int orangesRotting(int[][] grid) {
                int m = grid.length, n = grid[0].length;
                for (int i = 0; i < m; ++i) {
                        for (int j = 0; j < n; ++j) {
                                if (grid[i][j] == 2) {
                                        DFS(grid, i, j, m, n, 2);
                                }
                        }
                }
                int minutes = 2;
                for (int[] row : grid) {
                        for (int cell : row) {
                                if (cell == 1) { // if any orange remained unrotten
                                        return -1;
                                }
                                // find out max minutes taken for an orange to rotten
                                minutes = Math.max(minutes, cell);
                        }
                }
                return minutes - 2;
        }
        public static void main(String[] args) {
                int[][] grid = {
                        { 2, 1, 1 },
                        { 1, 1, 0 },
                        { 0, 1, 1 }
                };
                System.out.println(new RottingOranges().orangesRotting(grid));
        }
}
