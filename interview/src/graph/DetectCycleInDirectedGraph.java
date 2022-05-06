/**
 * Date 27/04/2022
 *
 * @author akhilpathivada
 *
 * https://www.geeksforgeeks.org/detect-cycle-in-a-graph/
 *
 * Time Complexity : O(V + E)
 * Space Complexity : O(V)
 */
package graph;

public class DetectCycleInDirectedGraph {
        private boolean isCycleUtil(GraphNode node, boolean[] visited, boolean[] recStack) {
                if (recStack[node.label]) {
                        return true;
                }
                if (visited[node.label]) {
                        return false;
                }
                // Mark the current node as visited and
                // part of recursion stack
                visited[node.label] = true;
                recStack[node.label] = true;
                for (GraphNode neighbour : node.neighbours) {
                        if (isCycleUtil(neighbour, visited, recStack)) {
                                return true;
                        }
                }
                recStack[node.label] = false;
                return false;
        }
        private boolean isCycle(GraphNode[] graph) {
                // Mark all the vertices as not visited and
                // not part of recursion stack
                boolean[] visited = new boolean[graph.length];
                boolean[] recStack = new boolean[graph.length];
                for (int i = 0; i < graph.length; ++i) {
                        if (isCycleUtil(graph[i], visited, recStack)) {
                                return true;
                        }
                }
                return false;
        }
        public static void main(String[] args) {
                GraphNode[] graph = new GraphNode[4];
                graph[0] = new GraphNode(0);
                graph[1] = new GraphNode(1);
                graph[2] = new GraphNode(2);
                graph[3] = new GraphNode(3);
                graph[0].addEdge(graph[1]);
                graph[0].addEdge(graph[2]);
                graph[1].addEdge(graph[2]);
                graph[2].addEdge(graph[0]);
                graph[2].addEdge(graph[3]);
                graph[3].addEdge(graph[3]);
                System.out.println(new DetectCycleInDirectedGraph().isCycle(graph));
        }
}
