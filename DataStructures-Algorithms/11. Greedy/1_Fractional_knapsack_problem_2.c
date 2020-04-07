/*
Given weights and profits of n items, put these items in a knapsack of capacity W to get the maximum total profit in the knapsack.

(Greedy about min.weights)

Time Complexity : O(N*logN)
Space Complexity : O(1)
*/

#include<stdio.h>
#include<stdlib.h>

void Swap(float *aptr,float *bptr)
{
	float temp=*aptr;
	*aptr=*bptr;
	*bptr=temp;
}

void MinHeapify( float weights[], float profits[], int size, int i) 
{
	int smallest=i;

	int left=(2*i)+1;
	int right=(2*i)+2;

	if(left<size && weights[left] < weights[smallest])
		smallest=left;

	if(right<size && weights[right] < weights[smallest])
		smallest=right;

	if(smallest!=i)
	{
		Swap(&weights[i],&weights[smallest]);

		Swap(&profits[i],&profits[smallest]);
	
		MinHeapify(weights,profits,size,smallest);
	}
}

void convertToMinHeap( float weights[], float profits[], int size)
{
	for(int i=(size/2)-1 ;i>=0; --i)
		MinHeapify(weights,profits,size,i);
}

void ExtractMax( float weights[], float profits[], float *profitValue, float *minWeight, int *size)
{		
	*minWeight = weights[0];
	*profitValue = profits[0];

	weights[0] = weights[--*size];
	profits[0] = profits[*size];

	MinHeapify(weights,profits,*size,0);
}

float fillKnapSack( float weights[], float profits[], float capacity, int size)
{
	float profitValue, minWeight, resProfit=0;
	
	convertToMinHeap(weights,profits,size);
	
	while(size)
	{
		ExtractMax(weights,profits, &profitValue, &minWeight, &size);
		
		if( capacity && minWeight <= capacity)
		{	
			resProfit += profitValue;
			capacity -= minWeight;
		}
		
		else 
		      break;
	}

	if(capacity)		
		resProfit += profitValue * (capacity/minWeight);
		
	return resProfit;
}

void main()
{
	float profits[]= {10,5,15,7,6,18,3};
	float weights[]= {2,3,5,7,1,4,1};
	
	float W=15; // knapsack capacity
	
	int n=sizeof(weights)/sizeof(*weights);
	
	printf(" Max. Profit : %f ", fillKnapSack(weights,profits,W,n));
}
