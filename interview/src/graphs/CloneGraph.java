/**
 * https://leetcode.com/problems/clone-graph/
 * */

package graphs;

import java.util.HashMap;

public class CloneGraph extends UndirectedGraphNode {
        // tracks whether node is already cloned
        private static HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();
        
        private static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
                
                if(node == null) {
                        return null;
                }
                // if the node is already formed in Clone graph
                if(map.containsKey(node.label)) {
                        return map.get(node.label);
                }
                // create new node into Clone graph
                UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
                // add into map
                map.put(clone.label, clone);
                // iterate over all its neighbours
                for(UndirectedGraphNode neighbour : node.neighbours) {
                        clone.neighbours.add(cloneGraph(neighbour));
                }
                return clone;
        }
        
        public static void main(String[] args) {
                // create graph with 4 nodes
                UndirectedGraphNode[] graph = new UndirectedGraphNode[4];
                graph[0] = new UndirectedGraphNode(1);
                graph[1] = new UndirectedGraphNode(2);
                graph[2] = new UndirectedGraphNode(3);
                graph[3] = new UndirectedGraphNode(4);
                // adding neighbours to nodes
                graph[0].neighbours.add(graph[1]);
                graph[0].neighbours.add(graph[2]);
                graph[1].neighbours.add(graph[0]);
                graph[1].neighbours.add(graph[3]);
                graph[2].neighbours.add(graph[0]);
                graph[2].neighbours.add(graph[3]);
                graph[3].neighbours.add(graph[1]);
                graph[3].neighbours.add(graph[2]);
        
                System.out.print("Original Graph : "); new UndirectedGraphNode().DFS(graph[0]);
                System.out.print("Cloned Graph : "); new UndirectedGraphNode().DFS(cloneGraph(graph[0]));
        }
}