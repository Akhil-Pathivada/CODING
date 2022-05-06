/**
 * Date 28/04/2022
 *
 * @author akhilpathivada
 *
 * https://www.geeksforgeeks.org/detect-cycle-undirected-graph/
 *
 * Time Complexity : O(V + E)
 * Space Complexity : O(V)
 */
package graph;

public class DetectCycleInUndirectedGraph {
        private boolean isCycleUtil(GraphNode node, boolean[] visited, GraphNode parent) {
                visited[node.label] = true;
                for (GraphNode neighbour : node.neighbours) {
                        if (!visited[neighbour.label]) {
                                if (isCycleUtil(neighbour, visited, node)) {
                                        return true;
                                }
                        }
                        else if (neighbour != parent){
                                return true;
                        }
                }
                return false;
        }
        private boolean isCycle(GraphNode[] graph) {
                boolean[] visited = new boolean[graph.length];
                for (GraphNode node : graph) {
                        if (!visited[node.label]) {
                                if (isCycleUtil(node, visited, null)) {
                                        return true;
                                }
                        }
                }
                return false;
        }
        public static void main(String[] args) {
                GraphNode[] graph = new GraphNode[5];
                graph[0] = new GraphNode(0);
                graph[1] = new GraphNode(1);
                graph[2] = new GraphNode(2);
                graph[3] = new GraphNode(3);
                graph[4] = new GraphNode(4);
                graph[1].addEdge(graph[0]);
                graph[0].addEdge(graph[2]);
                graph[2].addEdge(graph[1]);
                graph[0].addEdge(graph[3]);
                graph[3].addEdge(graph[4]);
                System.out.println(new DetectCycleInUndirectedGraph().isCycle(graph));
        }
}
