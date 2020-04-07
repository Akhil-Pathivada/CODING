/*
Program for Breadth First Traversal for a Graph

(UnDirected Weighted Graph)

Time Complexity : O(E)+O(V)
Space Complexity : O(V)
*/
#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>
#define V 8

bool visited[V]={false}; // visited should be 'global' 

struct AdjListNode
{
	int dest;
	struct AdjListNode *next;
};

struct Graph
{
	struct AdjListNode *head;
};

struct Graph *createGraph()
{
	struct Graph *graph = (struct Graph*)calloc(V,sizeof(struct Graph));
	
	for(int i=0; i<V ;++i)
		graph[i].head = NULL;
		
	return graph;
}

struct AdjListNode* newNode( int vertex)
{
	struct AdjListNode *nn=(struct AdjListNode*)malloc(sizeof(struct AdjListNode));
	
	nn->dest=vertex;
	nn->next=NULL;
	
	return nn;
}

void addEdge( struct Graph *graph, int src, int dest)
{
	struct AdjListNode *nn = newNode(dest);
	
	struct AdjListNode *temp = graph[src].head;
	
	graph[src].head=nn;
	
	nn->next=temp;
}

void enQueue( int queue[], int vertex, int *rear)
{
	queue[++*rear]=vertex;
}

int deQueue( int queue[], int *front)
{
	return queue[++*front];
}

bool isQueueEmpty( int front, int rear)
{
	return (front==rear);
}

void printBFS( struct Graph graph[])
{
	int queue[V];
	
	int front=-1,rear=-1;
	
	// inserting Root vertex
	enQueue(queue,0,&rear);
	
	visited[0]=true;
	
	while( !isQueueEmpty(front,rear) )
	{
		int root = deQueue(queue,&front);
		
		printf(" %d,",root);
		
		struct AdjListNode *head = graph[root].head;
		
		for( ;head; head=head->next)
		{
			int adjVertex = head->dest;
			
			if(!visited[adjVertex])
			{
				
				enQueue(queue,adjVertex,&rear);
			
				visited[adjVertex]=true;
			}
		}	
	}
}

void main()
{
	struct Graph *graph = createGraph();
	
	addEdge(graph,0,2);
	addEdge(graph,0,1);
	addEdge(graph,1,0);
	addEdge(graph,1,4);
	addEdge(graph,1,3);
	addEdge(graph,2,0);
	addEdge(graph,2,6);
	addEdge(graph,2,5);
	addEdge(graph,3,1);
	addEdge(graph,3,7);
	addEdge(graph,4,1);
	addEdge(graph,4,7);
	addEdge(graph,5,2);
	addEdge(graph,5,7);
	addEdge(graph,6,2);
	addEdge(graph,6,7);
	addEdge(graph,7,3);
	addEdge(graph,7,4);
	addEdge(graph,7,5);
	addEdge(graph,7,6);
	
	printBFS(graph);
}
