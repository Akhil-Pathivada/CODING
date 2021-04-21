/*
Given weights and profits of n items, put these items in a knapsack of capacity W to get the maximum total profit in the knapsack.

(Greedy about max.profits)

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

void MaxHeapify( float profits[], float weights[], int size, int i) 
{
	int largest=i;

	int left=(2*i)+1;
	int right=(2*i)+2;

	if(left<size && profits[left] > profits[largest])
		largest=left;

	if(right<size && profits[right] > profits[largest])
		largest=right;

	if(largest!=i)
	{
		Swap(&profits[i],&profits[largest]);
		
		Swap(&weights[i],&weights[largest]);
		
		MaxHeapify(profits,weights,size,largest);
	}
}

void convertToMaxHeap( float profits[], float weights[], int size)
{
	for(int i=(size/2)-1 ;i>=0; --i)
		MaxHeapify(profits,weights,size,i);
}

void ExtractMax(float profits[], float weights[], float *weightValue, float *maxProfit, int *size)
{		
	*maxProfit = profits[0];
	*weightValue = weights[0];

	profits[0] = profits[--*size];
	weights[0] = weights[*size];

	MaxHeapify(profits,weights,*size,0);
}

float fillKnapSack( float profits[], float weights[], float capacity, int size)
{
	float weightValue, maxProfit, resProfit=0;
	
	convertToMaxHeap(profits,weights,size);
	
	while(size)
	{
		ExtractMax(profits,weights, &weightValue, &maxProfit, &size);
		 
		if( capacity && weightValue <= capacity)
		{	
			resProfit += maxProfit;
			capacity -= weightValue;
		}
		
		else 
		     break;
	}
	
	if(capacity)		
		resProfit += maxProfit * (capacity/weightValue);
		
	return resProfit;
}

void main()
{
	float profits[]= {10,5,15,7,6,18,3};
	float weights[]= {2,3,5,7,1,4,1};
	
	float W=15; // knapsack capacity
	
	int n=sizeof(profits)/sizeof(*profits);
	
	printf(" Max. Profit : %f ", fillKnapSack(profits,weights,W,n));
}
