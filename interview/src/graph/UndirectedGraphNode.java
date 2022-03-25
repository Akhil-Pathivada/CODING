package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
                for(UndirectedGraphNode _node : node.neighbours) {
                        if(!visited.contains(_node.label)) {
                                DFSUtil(_node, visited);
                        }
                }
        }
        
        protected void DFS(UndirectedGraphNode node) {
                Set<Integer> visited = new HashSet<>();
                DFSUtil(node, visited);
        }
}
