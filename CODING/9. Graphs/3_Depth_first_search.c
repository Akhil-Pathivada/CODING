/*
Program for Depth First Traversal for a Graph

(UnDirected Weighted Graph)

Time Complexity : O(E)+O(V)
Space Complexity : O(V)
*/
#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>
#define V 8

bool visited[V] = {false}; // visited should be 'global' 

struct AdjListNode {

	int dest;
	struct AdjListNode *next;
};

struct Graph {

	struct AdjListNode *head;
};

struct Graph *createGraph() {

	struct Graph *graph = (struct Graph*)calloc(V,sizeof(struct Graph));
	
	for(int i = 0; i < V; ++i)
		graph[i].head = NULL;
		
	return graph;
}

struct AdjListNode* newNode(int vertex) {

	struct AdjListNode *nn = (struct AdjListNode*)malloc(sizeof(struct AdjListNode));
	
	nn->dest = vertex;
	nn->next = NULL;
	
	return nn;
}

void addEdge(struct Graph *graph, int src, int dest) {

	struct AdjListNode *nn = newNode(dest);
	
	struct AdjListNode *temp = graph[src].head;
	
	graph[src].head = nn;
	
	nn->next = temp;
}

void printDFS(struct Graph graph[], int root) {

	visited[root] = true;
	
	printf(" %d,", root);
	
	struct AdjListNode *head = graph[root].head;
	
	for( ; head; head = head->next) {

		int adjVertex = head->dest;
		
		if(!visited[adjVertex])
			printDFS(graph, adjVertex);		
	}
}

int main() {
		
	struct Graph *graph = createGraph();
	
	addEdge(graph, 0, 2);
	addEdge(graph, 0, 1);
	addEdge(graph, 1, 0);
	addEdge(graph, 1, 4);
	addEdge(graph, 1, 3);
	addEdge(graph, 2, 0);
	addEdge(graph, 2, 6);
	addEdge(graph, 2, 5);
	addEdge(graph, 3, 1);
	addEdge(graph, 3, 7);
	addEdge(graph, 4, 1);
	addEdge(graph, 4, 7);
	addEdge(graph, 5, 2);
	addEdge(graph, 5, 7);
	addEdge(graph, 6, 2);
	addEdge(graph, 6, 7);
	addEdge(graph, 7, 3);
	addEdge(graph, 7, 4);
	addEdge(graph, 7, 5);
	addEdge(graph, 7, 6);

	printDFS(graph, 0);
}
