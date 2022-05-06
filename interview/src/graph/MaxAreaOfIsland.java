/**
 * Date 04/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/max-area-of-island/
 * Time Complexity : O(M * N)
 * Space Complexity : O(M * N)
 *
 */
package graph;

public class MaxAreaOfIsland {
        private int m, n; // rows, columns
        private int DFS(int[][] grid, int i, int j) {
                // base case
                if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] != 1) {
                        return 0;
                }
                // mark the island as visited
                grid[i][j] = 0;
                // recur on its neighbours
                return 1 + DFS(grid, i + 1, j) + DFS(grid, i - 1, j) + DFS(grid, i, j + 1) + DFS(grid, i, j - 1);
        }
        private int maxArea(int[][] grid) {
                m = grid.length;
                if (m == 0) {
                        return 0;
                }
                n = grid[0].length;
                int area = 0;
                for (int i = 0; i < m; ++i) {
                        for (int j = 0; j < n; ++j) {
                                // island found
                                if (grid[i][j] == 1) {
                                        area = Math.max(area, DFS(grid, i, j));
                                }
                        }
                }
                return area;
        }
        public static void main(String[] args) {
                int grid[][] = new int[][] {
                        { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                        { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                        { 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                        { 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                        { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                        { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
                System.out.printf("Max Area of Island = %d", new MaxAreaOfIsland().maxArea(grid));
        }
        
}
