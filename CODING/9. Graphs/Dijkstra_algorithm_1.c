/*
(Dijkstra's Algorithm)

Given a graph and a source vertex in the graph, find shortest paths from source to all vertices in the given graph.

The program is for adjacency matrix representation of the graph (UnDirected Weighted Graph)


*/
#include<stdio.h>
#include<stdbool.h>
#include<limits.h>

#define V 9

int minDistanceNode( int *dist, bool *computed)
{
	int min_Index , min = INT_MAX;	
	
	for( int i=0; i<V; ++i)
	{
		if(!computed[i] && dist[i] < min)
		{
			min = dist[i];
			min_Index = i;
		}
	}
	
	return min_Index;
}

bool isRelax( int graph[V][V], int *dist, int u, int v)
{
	return dist[u]+graph[u][v] < dist[v] ;
}

void Dijkstra( int graph[V][V], int src, int dist[])
{
	
	bool computed[V];
	
	for( int i=0; i<V; ++i)
	{
		dist[i] = INT_MAX;
		computed[i] = false;
	}
	
	dist[src] = 0;
	
	for( int count=0; count<V; ++count)
	{
		int u = minDistanceNode(dist,computed);
		
		computed[u] = true;
		
		for( int i=0; i<V; ++i)
		{
			if(!computed[i] && graph[u][i] && isRelax(graph,dist,u,i))
				dist[i] = dist[u] + graph[u][i];
		}
	}
}

void printDistance( int *dist)
{
	for( int i=0; i<V; ++i)
		printf(" %d,",dist[i]);
}

int main() 
{ 
	int graph[V][V] = {{ 0, 4, 0, 0, 0, 0, 0, 8, 0 }, 
         	        { 4, 0, 8, 0, 0, 0, 0, 11, 0 }, 
                        { 0, 8, 0, 7, 0, 4, 0, 0, 2 }, 
                        { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, 
                        { 0, 0, 0, 9, 0, 10, 0, 0, 0 }, 
                        { 0, 0, 4, 14, 10, 0, 2, 0, 0 }, 
                        { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, 
                        { 8, 11, 0, 0, 0, 0, 1, 0, 7 }, 
                        { 0, 0, 2, 0, 0, 0, 6, 7, 0 } }; 
  
	int dist[V];	
	  
	Dijkstra(graph,0,dist); // source is 0
	
	printDistance(dist);
} 
