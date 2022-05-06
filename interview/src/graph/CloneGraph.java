/**
 * https://leetcode.com/problems/clone-graph/
 * */

package graph;

import java.util.HashMap;

public class CloneGraph extends GraphNode {
        // tracks whether node is already cloned
        private HashMap<Integer, GraphNode> map = new HashMap<>();
        private GraphNode cloneGraph(GraphNode node) {
                if (node == null) {
                        return null;
                }
                // if the node is already formed in Clone graph
                if (map.containsKey(node.label)) {
                        return map.get(node.label);
                }
                // create new node into Clone graph
                GraphNode clone = new GraphNode(node.label);
                // add into map
                map.put(clone.label, clone);
                // iterate over all its neighbours
                for (GraphNode neighbour : node.neighbours) {
                        clone.neighbours.add(cloneGraph(neighbour));
                }
                return clone;
        }
        public static void main(String[] args) {
                // create graph with 4 nodes
                GraphNode[] graph = new GraphNode[4];
                graph[0] = new GraphNode(1);
                graph[1] = new GraphNode(2);
                graph[2] = new GraphNode(3);
                graph[3] = new GraphNode(4);
                // adding neighbours to nodes
                graph[0].neighbours.add(graph[1]);
                graph[0].neighbours.add(graph[2]);
                graph[1].neighbours.add(graph[0]);
                graph[1].neighbours.add(graph[3]);
                graph[2].neighbours.add(graph[0]);
                graph[2].neighbours.add(graph[3]);
                graph[3].neighbours.add(graph[1]);
                graph[3].neighbours.add(graph[2]);
                System.out.print("Original Graph : "); new GraphNode().DFS(graph[0]);
                System.out.print("Cloned Graph : "); new GraphNode().DFS(new CloneGraph().cloneGraph(graph[0]));
        }
}