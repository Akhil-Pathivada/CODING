/**
 * Date 22/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/redundant-connection/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 */
package graph;

import java.util.Arrays;

public class RedundantConnection {
        // captures parent of each node
        int[] parent;
        private int[] findRedundantConnection(int[][] edges) {
                int n = edges.length + 1;
                parent = new int[n + 1];
                for (int i = 0; i <= n; ++i) {
                        parent[i] = i;
                }
                for (int[] edge : edges) {
                        // found the edge which created cycle
                        if (find(edge[0]) == find(edge[1])) {
                                return edge;
                        }
                        union(edge[0], edge[1]);
                }
                return null;
        }
        // find which set it belongs
        private int find(int node) {
                while (parent[node] != node) {
                        node = parent[node];
                }
                return node;
        }
        // combine 2 disjoint sets
        private void union(int i, int j) {
                int iRoot = find(i);
                int jRoot = find(j);
                if (iRoot != jRoot) {
                        parent[jRoot] = iRoot;
                }
        }
        public static void main(String[] args) {
                int[][] edges = {
                        { 1, 2 },
                        { 2, 3 },
                        { 3, 4 },
                        { 1, 4 },
                        { 1, 5 }
                };
                System.out.println(Arrays.toString(new RedundantConnection().findRedundantConnection(edges)));
        }
}
