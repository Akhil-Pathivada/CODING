/*
Adjacency List representation of a UnWeighted Graph.....

*/

#include<stdio.h>
#include<stdlib.h>

struct AdjListNode {

	int dest;
	struct AdjListNode *next;
};

struct Graph {

	struct AdjListNode *head;
};

struct Graph *createGraph(int V) {

	struct Graph *graph = (struct Graph*)calloc(V, sizeof(struct Graph));
	
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

void printAdjList(struct Graph graph[], int V) {

	for(int i = 0; i < V; ++i) {	

		printf(" %d ", i);
		
		struct AdjListNode *head = graph[i].head;
		
		for( ; head; head = head->next)
			printf("->%d ", head->dest);
			
		printf("\n");
	}	
}

int main() {

	int V = 7;
		
	struct Graph *graph = createGraph(V);
	
	addEdge(graph, 0, 2);
	addEdge(graph, 0, 5);
	addEdge(graph, 1, 3);
	addEdge(graph, 2, 3);
	addEdge(graph, 2, 6);
	addEdge(graph, 3, 1);
	addEdge(graph, 3, 4);
	addEdge(graph, 4, 1);
	addEdge(graph, 4, 6);
	addEdge(graph, 5, 2);
	addEdge(graph, 5, 1);
	addEdge(graph, 6, 1);
	
	printAdjList(graph, V);
}
