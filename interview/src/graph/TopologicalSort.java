/**
 * Date 24/04/2022
 *
 * @author akhilpathivada
 *
 * https://www.geeksforgeeks.org/topological-sorting/
 *
 * Time Complexity: O(V + E)
 * Space Complexity: O(V)
 */
package graph;

import java.util.Iterator;
import java.util.Stack;

public class TopologicalSort extends GraphNode {
        private void topologicalSortUtil(GraphNode v, boolean[] visited, Stack<Integer> stack) {
                visited[v.label] = true;
                Iterator<GraphNode> iterator = v.neighbours.iterator();
                while (iterator.hasNext()) {
                        GraphNode _v = iterator.next();
                        // if the node is not visited : recursively call its adjacent nodes
                        if (!visited[_v.label]) {
                                topologicalSortUtil(_v, visited, stack);
                        }
                }
                stack.push(v.label);
        }
        private void topologicalSort(GraphNode[] graph) {
                // by default all the vertices are not visited
                boolean[] visited = new boolean[graph.length];
                // stack stores the result
                Stack<Integer> stack = new Stack<>();
                // call the recursive util function to store
                // Topological Sort starting from all vertices one by one
                for (GraphNode v : graph) {
                        if (!visited[v.label]) {
                                topologicalSortUtil(v, visited, stack);
                        }
                }
                while (!stack.isEmpty()) {
                        System.out.print(stack.pop() + ", ");
                }
        }
        public static void main(String[] args) {
                // create graph with 4 nodes
                GraphNode[] graph = new GraphNode[6];
                graph[0] = new GraphNode(0);
                graph[1] = new GraphNode(1);
                graph[2] = new GraphNode(2);
                graph[3] = new GraphNode(3);
                graph[4] = new GraphNode(4);
                graph[5] = new GraphNode(5);
                // add edges
                graph[5].addEdge(graph[2]);
                graph[5].addEdge(graph[0]);
                graph[4].addEdge(graph[0]);
                graph[4].addEdge(graph[1]);
                graph[2].addEdge(graph[3]);
                graph[3].addEdge(graph[1]);
                new TopologicalSort().topologicalSort(graph);
        }
}
