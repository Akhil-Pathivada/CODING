/**
 * Date 06/05/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/number-of-provinces/
 *
 * Time Complexity : O(V ^ 2)
 * Space Complexity : O(V)
 */
package graph;

public class NumberOfProvinces {
        private void DFS(int[][] M, int[] visited, int i) {
                for (int j = 0; j < M.length; ++j) {
                        if (M[i][j] == 1 && visited[j] == 0) {
                                visited[j] = 1;
                                DFS(M, visited, j);
                        }
                }
        }
        private int findConnected(int[][] isConnected) {
                int m = isConnected.length;
                int count = 0;
                int[] visited = new int[m];
                for (int i = 0; i < m; ++i) {
                        if (visited[i] == 0) {
                                DFS(isConnected, visited, i);
                                ++count;
                        }
                }
                return count;
        }
        public static void main(String[] args) {
                int[][] isConnected = {
                        { 1, 1, 0 },
                        { 1, 1, 0 },
                        { 0, 0, 1 }
                };
                System.out.println(new NumberOfProvinces().findConnected(isConnected));
        }
}
