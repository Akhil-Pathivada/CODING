/**
 * Date 04/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/number-of-islands/
 *
 * Time Complexity : O(M * N)
 * Space Complexity : O(M * N)
 *
 */
package graph;

public class NumberOfIslands {
        private int m, n; // rows, columns
        private void DFS(char[][] grid, int i, int j) {
                // base case
                if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] != '1') {
                        return;
                }
                // mark the island as visited
                grid[i][j] = '0';
                // recur on its neighbours
                DFS(grid, i + 1, j);
                DFS(grid, i - 1, j);
                DFS(grid, i, j + 1);
                DFS(grid, i, j - 1);
        }
        private int numOfIslands(char[][] grid) {
                m = grid.length;
                if (m == 0) {
                        return 0;
                }
                n = grid[0].length;
                int countOfIslands = 0;
                for (int i = 0; i < m; ++i) {
                        for (int j = 0; j < n; ++j) {
                                // island found
                                if (grid[i][j] == '1') {
                                        DFS(grid, i, j);
                                        ++countOfIslands;
                                }
                        }
                }
                return countOfIslands;
        }
        public static void main(String[] args) {
                char grid[][] = new char[][] {
                        { '1', '1', '0', '0', '0' },
                        { '0', '1', '0', '0', '1' },
                        { '1', '0', '0', '1', '1' },
                        { '0', '0', '0', '0', '0' },
                        { '1', '0', '1', '0', '1' } };
                System.out.printf("Number of Islands = %d", new NumberOfIslands().numOfIslands(grid));
        }
}
