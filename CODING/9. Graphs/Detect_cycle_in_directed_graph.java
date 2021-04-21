/* 
 * Given a directed graph, check whether the graph contains a cycle or not.
 * Your function should return true if the given graph contains at least one cycle, else return false.
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
	}

	private boolean isCyclicUtil(int v, boolean[] visited, boolean[] recStack) {
		
		if(recStack[v]) {
			return true;
		}
		if(visited[v]) {
			return false;
		}
		recStack[v] = true;
		visited[v] = true;

		for(Integer children : adj.get(v)) {
			
			if(isCyclicUtil(children, visited, recStack)) {
				return true;
			}
		}
		recStack[v] = false;

		return false;
	}

	private boolean isCyclic() {

		boolean[] visited = new boolean[V];
		boolean[] recStack = new boolean[V];

		for(int i = 0; i < V; ++i) {

			if(isCyclicUtil(i, visited, recStack)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String args[]) {

		// A Graph of 6 nodes
		Graph graph = new Graph(4);

		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);

		if(graph.isCyclic()) {
		    System.out.println("Graph contains cycle");
		}
		else {
		    System.out.println("Graph doesn't contains cycle");
		    
		}
	}
}
