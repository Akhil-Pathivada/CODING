/* 
 * Breadth First Traversal (or Search) for a graph
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

	private void BFS(int s) {
		
		boolean[] visited = new boolean[V];

		Queue<Integer> queue = new LinkedList<>();

		visited[s] = true;
		queue.add(s);

		while(!queue.isEmpty()) {

			s = queue.poll();
			System.out.print(s + ", ");

			Iterator<Integer> itr = adj.get(s).iterator();
			
			while(itr.hasNext()) {

				Integer i = itr.next();

				if(!visited[i]) {
					visited[i] = true;
					queue.add(i);
				}
			}
		}
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
		// send the start node of BFS
		graph.BFS(2);
	}
}
