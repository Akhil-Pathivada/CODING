package graph;

import java.util.*;

public class UndirectedGraphNode {
        
        public int label; // value of node
        public List<UndirectedGraphNode> neighbours; // list of neighbours
        
        public UndirectedGraphNode() {
        }
        
        public UndirectedGraphNode(int _label) {
                label = _label;
                neighbours = new ArrayList<UndirectedGraphNode>();
        }
        
        public UndirectedGraphNode(int _label, ArrayList<UndirectedGraphNode> _neighbours) {
                label = _label;
                neighbours = _neighbours;
        }
        
        private void DFSUtil(UndirectedGraphNode node, Set<Integer> visited) {
                System.out.print(node.label + ", ");
                visited.add(node.label);
                // iterate over all neighbours of a node recursively
                for (UndirectedGraphNode _node : node.neighbours) {
                        if (!visited.contains(_node.label)) {
                                DFSUtil(_node, visited);
                        }
                }
        }
        // Depth First Traversal
        protected void DFS(UndirectedGraphNode node) {
                Set<Integer> visited = new HashSet<>();
                DFSUtil(node, visited);
        }
        
        private void BFSUtil(UndirectedGraphNode node) {
                Set<Integer> visited = new HashSet<>();
                Queue<UndirectedGraphNode> queue = new LinkedList<>();
                visited.add(node.label);
                queue.add(node);
                while (!queue.isEmpty()) {
                        node = queue.poll();
                        System.out.print(node.label + ", ");
                        // iterate over all neighbours of a node
                        for (UndirectedGraphNode _node : node.neighbours) {
                                // if node is visited first time : inser into Queue
                                if (!visited.contains(_node.label)) {
                                        visited.add(_node.label);
                                        queue.add(_node);
                                }
                        }
                }
                
        }
        // Breadth First Traversal
        protected void BFS(UndirectedGraphNode node) {
                BFSUtil(node);
        }
}
