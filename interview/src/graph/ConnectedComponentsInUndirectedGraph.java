/**
 * Date 12/04/2022
 *
 * @author akhilpathivada
 *
 * Time Complexity : O(V + E)
 */
package graph;

import java.util.HashSet;

public class ConnectedComponentsInUndirectedGraph {
        private void DFS(GraphNode node, HashSet<Integer> visited) {
                // Mark the current node as visited and print it
                visited.add(node.label);
                System.out.print(node.label + ", ");
                // recur over all neighbours of a node recursively
                for (GraphNode _node : node.neighbours) {
                        if (!visited.contains(_node.label)) {
                                DFS(_node, visited);
                        }
                }
        }
        private int connectedComponents(GraphNode[] graph, int V) {
                int components = 0;
                HashSet<Integer> visited = new HashSet<>();
                for (int v = 0; v < V; ++v) {
                        if (!visited.contains(v)) {
                                DFS(graph[v], visited);
                                ++components;
                                System.out.println();
                        }
                }
                return components;
        }
        public static void main(String[] args) {
                // create graph with 5 nodes
                int V = 5;
                GraphNode[] graph = new GraphNode[V];
                graph[0] = new GraphNode(0);
                graph[1] = new GraphNode(1);
                graph[2] = new GraphNode(2);
                graph[3] = new GraphNode(3);
                graph[4] = new GraphNode(4);
                // adding neighbours to nodes
                graph[0].neighbours.add(graph[1]);
                graph[1].neighbours.add(graph[0]);
                graph[1].neighbours.add(graph[2]);
                graph[2].neighbours.add(graph[1]);
                graph[3].neighbours.add(graph[4]);
                graph[4].neighbours.add(graph[3]);
                System.out.println("Number of connected components = " + new ConnectedComponentsInUndirectedGraph().connectedComponents(graph, V));
        }
}
