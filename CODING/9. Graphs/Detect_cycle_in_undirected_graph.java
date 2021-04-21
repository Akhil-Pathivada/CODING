/* 
 * Given an undirected graph, how to check if there is a cycle in the graph.
 *
 * Time Complexity: O(V + E)
 * Space Complexity: O(V)
 *  */

import java.util.*;

class Graph {
	
	// No. of vertices
	private int V;
	// Representation using Adjacency List
	private ArrayList<ArrayList<Integer>> adj;

	// Constructor
	private Graph(int v) {
		
		V = v;
		adj = new ArrayList<ArrayList<Integer>>(v);
		
		for(int i = 0; i < v; ++i) {
			adj.add(new ArrayList<Integer>());
		}
	}
	
	// Add Edge into the Graph
	private void addEdge(int v, int w) {

		adj.get(v).add(w);
		adj.get(w).add(v);
	}

	private boolean isCyclicUtil(int v, boolean[] visited, int parent) {
		
		visited[v] = true;

		Iterator<Integer> itr = adj.get(v).iterator();
		
		while(itr.hasNext()) {

			Integer i = itr.next();

			if(!visited[i]) {

				if(isCyclicUtil(i, visited, v)) {
					return true;
				}
			}
			else if(i != parent) {
				return true;
			}
		}
		return false;
	}

	private boolean isCyclic() {

		boolean[] visited = new boolean[V];

		for(int i = 0; i < V; ++i) {
			// Don't recur for u if already visited
			if(!visited[i]) {

				if(isCyclicUtil(i, visited, -1)) {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String args[]) {

		// A Graph of 6 nodes
		Graph graph = new Graph(5);

		graph.addEdge(1, 0);
		graph.addEdge(0, 2);
		graph.addEdge(2, 1);
		graph.addEdge(0, 3);
		graph.addEdge(3, 4);

		if(graph.isCyclic()) {
		    System.out.println("Graph contains cycle");
		}
		else {
		    System.out.println("Graph doesn't contains cycle");
		    
		}
	}
}
