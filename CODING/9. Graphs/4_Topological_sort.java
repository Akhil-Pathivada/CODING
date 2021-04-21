/* 
 * Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices
 * such that for every directed edge u v, vertex u comes before v in the ordering.
 * Topological Sorting for a graph is not possible if the graph is not a DAG.
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
	
	private void topologicalSortUtil(int v, boolean visited[], Stack<Integer> stack) {

		visited[v] = true;

		Iterator<Integer> itr = adj.get(v).iterator();

		while(itr.hasNext()) {
			Integer i = itr.next();

			// if the node is not visited - 
			// recursively call its adjacent nodes
			if(!visited[i]) {
				topologicalSortUtil(i, visited, stack);
			}
		}
		stack.push(v);
	}

	private void topologicalSort() {

		Stack<Integer> stack = new Stack<Integer>();

		// Mark all the vertices as not visited
		boolean visited[] = new boolean[V];

		for(int i = 0; i < V; ++i) {
			visited[i] = false;
		}
		// Call the recursive helper
		// function to store
		// Topological Sort starting
		// from all vertices one by one
		for(int i = 0; i < V; ++i) {
			if(!visited[i]) {
				topologicalSortUtil(i, visited, stack);
			}
		}

		while(!stack.isEmpty()) {
			System.out.print(stack.pop() + ", ");
		}
	}

	public static void main(String args[]) {

		// A Graph of 6 nodes
		Graph graph = new Graph(6);

		graph.addEdge(5, 2);
		graph.addEdge(5, 0);
		graph.addEdge(4, 0);
		graph.addEdge(4, 1);
		graph.addEdge(2, 3);
		graph.addEdge(3, 1);

		graph.topologicalSort();
	}
}
