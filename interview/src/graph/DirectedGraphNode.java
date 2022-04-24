/**
 * Date 24/04/2022
 *
 * @author akhilpathivada
 */
package graph;

import java.util.ArrayList;
import java.util.List;

public class DirectedGraphNode {
        
        public int label;
        public List<DirectedGraphNode> neighbours; // list of neighbours
        
        public DirectedGraphNode() {
        }
        
        public DirectedGraphNode(int _label) {
                label = _label;
                neighbours = new ArrayList<DirectedGraphNode>();
        }
        // Add Edge into the Graph Node
        protected void addEdge(DirectedGraphNode w) {
                this.neighbours.add(w);
        }
}
