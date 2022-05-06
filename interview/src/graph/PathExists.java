/**
 * Date 28/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/find-if-path-exists-in-graph/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 */
package graph;

import java.util.Stack;

public class PathExists {
        private boolean isPathExists(int[][] edges, int source, int destination) {
                // base case
                if (source == destination) {
                        return true;
                }
                int n = edges.length;
                // creating a graph from the input
                GraphNode[] graph = new GraphNode[n];
                for (int i = 0; i < n; ++i) {
                        graph[i] = new GraphNode(i);
                }
                // adding the edges
                for (int[] edge : edges) {
                        graph[edge[0]].addEdge(graph[edge[1]]);
                        graph[edge[1]].addEdge(graph[edge[0]]);
                }
                boolean[] visited = new boolean[n];
                Stack<Integer> stack = new Stack<>();
                // make source as visited and push to stack
                stack.push(source);
                visited[source] = true;
                while (!stack.isEmpty()) {
                        int current = stack.pop();
                        // found
                        if (current == destination) {
                                return true;
                        }
                        for (GraphNode neighbour : graph[current].neighbours) {
                                int u = neighbour.label;
                                if (!visited[u]) {
                                        visited[u] = true;
                                        stack.push(u);
                                }
                        }
                }
                return false;
        }
        public static void main(String[] args) {
                int[][] edges = {
                        { 0, 1 },
                        { 1, 2 },
                        { 2, 0 }
                };
                System.out.println(new PathExists().isPathExists(edges, 0, 2));
        }
}
