package graph;

import java.util.*;

public class GraphNode {
        public int label; // value of node
        public List<GraphNode> neighbours; // list of neighbours
        // Constructors
        public GraphNode() {
        }
        public GraphNode(int _label) {
                label = _label;
                neighbours = new ArrayList<GraphNode>();
        }
        public GraphNode(int _label, ArrayList<GraphNode> _neighbours) {
                label = _label;
                neighbours = _neighbours;
        }
        // Add Edge into the Graph Node
        protected void addEdge(GraphNode w) {
                this.neighbours.add(w);
        }
        // Utility function for Depth First Traversal
        private void DFSUtil(GraphNode node, Set<Integer> visited) {
                System.out.print(node.label + ", ");
                visited.add(node.label);
                // iterate over all neighbours of a node recursively
                for (GraphNode _node : node.neighbours) {
                        if (!visited.contains(_node.label)) {
                                DFSUtil(_node, visited);
                        }
                }
        }
        // Depth First Traversal
        protected void DFS(GraphNode node) {
                Set<Integer> visited = new HashSet<>();
                DFSUtil(node, visited);
        }
        // Utility function for Breadth First Traversal
        private void BFSUtil(GraphNode node) {
                Set<Integer> visited = new HashSet<>();
                Queue<GraphNode> queue = new LinkedList<>();
                visited.add(node.label);
                queue.add(node);
                while (!queue.isEmpty()) {
                        node = queue.poll();
                        System.out.print(node.label + ", ");
                        // iterate over all neighbours of a node
                        for (GraphNode _node : node.neighbours) {
                                // if node is visited first time : inser into Queue
                                if (!visited.contains(_node.label)) {
                                        visited.add(_node.label);
                                        queue.add(_node);
                                }
                        }
                }
                
        }
        // Breadth First Traversal
        protected void BFS(GraphNode node) {
                BFSUtil(node);
        }
}
