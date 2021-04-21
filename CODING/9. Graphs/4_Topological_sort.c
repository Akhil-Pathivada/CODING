 /*
Program for Topological Sort of a Graph

(Directed Acyclic Graph)

Time Complexity : O(V + E)
Space Complexity : O(V)
*/
#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>

struct AdjListNode {

	int dest;
	struct AdjListNode *next;
};

struct Graph {

	struct AdjListNode *head;
};

struct Graph *createGraph(int V) {

	struct Graph *graph = (struct Graph*)calloc(V,sizeof(struct Graph));
	
	for(int i = 0; i < V ;++i)
		graph[i].head = NULL;
		
	return graph;
}

struct AdjListNode* newNode( int vertex) {

	struct AdjListNode *nn = (struct AdjListNode*)malloc(sizeof(struct AdjListNode));
	
	nn->dest = vertex;
	nn->next = NULL;
	
	return nn;
}

void addEdge( struct Graph *graph, int src, int dest) {

	struct AdjListNode *nn = newNode(dest);
	
	struct AdjListNode *temp = graph[src].head;
	
	graph[src].head = nn;
	
	nn->next = temp;
}

void enQueue(int queue[], int vertex, int *rear) {

	queue[++*rear] = vertex;
}

int deQueue(int queue[], int *front) {

	return queue[++*front];
}

bool isQueueEmpty(int front, int rear) {

	return (front == rear);
}

void computeInDegree(struct Graph graph[], int inDegree[], int V) {

	for(int i = 0; i < V; ++i) {

		struct AdjListNode *head = graph[i].head;
		
		for( ; head; head = head->next)
			
			++inDegree[head->dest];
	}
}

void printTopologicalOrder(struct Graph graph[], int V) {

	int inDegree[V];
	
	int queue[V];
	
	int front = -1, rear = -1;
	
	// initialising the inDegree of each node as '0'
	for(int i = 0; i < V; ++i)
		inDegree[i] = 0;
		
	computeInDegree(graph, inDegree, V);
	
	// searching for the root
	for(int i = 0; i < V; ++i) {

		if(!inDegree[i])
			enQueue(queue, i, &rear);
	}
	
	// Topological Sort
	while(!isQueueEmpty(front, rear)) {

		int root = deQueue(queue, &front);
		
		printf(" %d,", root);
		
		struct AdjListNode *head = graph[root].head;
		
		for( ; head; head = head->next) {

			if(--inDegree[head->dest] == 0)
					enQueue(queue, head->dest, &rear);
		}
	}
}

int main() {

	int V = 6;
		
	struct Graph *graph = createGraph(V);
	
	addEdge(graph, 0, 2);
	addEdge(graph, 0, 3);
	addEdge(graph, 1, 0);
	addEdge(graph, 2, 5);
	addEdge(graph, 3, 2);
	addEdge(graph, 3, 5);
	addEdge(graph, 4, 0);
	
	printTopologicalOrder(graph, V);
}
