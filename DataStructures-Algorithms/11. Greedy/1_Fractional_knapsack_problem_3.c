/*
Given weights and profits of n items, put these items in a knapsack of capacity W to get the maximum total profit in the knapsack.

(Greedy about ratio)

Time Complexity : O(N*logN)
Space Complexity : O(N)
*/

#include<stdio.h>
#include<stdlib.h>

void Swap( float *aptr, float *bptr)
{
	float temp=*aptr;
	*aptr=*bptr;
	*bptr=temp;
}

void MaxHeapify( float ratio[], float profits[], float weights[], int size, int i) 
{
	int largest=i;

	int left=(2*i)+1;
	int right=(2*i)+2;

	if(left<size && ratio[left] > ratio[largest])
		largest=left;

	if(right<size && ratio[right] > ratio[largest])
		largest=right;

	if(largest!=i)
	{
		Swap(&ratio[i],&ratio[largest]);
			
		Swap(&profits[i],&profits[largest]);
		
		Swap(&weights[i],&weights[largest]);
		
		MaxHeapify(ratio,profits,weights,size,largest);
	}
}

void convertToMaxHeap( float ratio[], float profits[], float weights[], int size)
{
	for(int i=(size/2)-1 ;i>=0; --i)
		MaxHeapify(ratio,profits,weights,size,i);
}

void ExtractMax( float ratio[], float profits[], float weights[], float *maxRatio, float *weightValue, float *profitValue, int *size)
{	
	*maxRatio = ratio[0];	
	*profitValue = profits[0];
	*weightValue = weights[0];

	ratio[0] = ratio[--*size];
	profits[0] = profits[*size];
	weights[0] = weights[*size];

	MaxHeapify(ratio,profits,weights,*size,0);
}

float fillKnapSack( float profits[], float weights[], float capacity, int size)
{
	float ratio[size];
	
	for(int i=0; i<size; ++i)
		ratio[i] = profits[i]/weights[i];
	
	convertToMaxHeap(ratio,profits,weights,size);
	
	float maxRatio,weightValue, profitValue, resProfit=0;
	
	while(size)
	{
		ExtractMax(ratio,profits,weights, &maxRatio, &weightValue, &profitValue, &size);
		 
		if( capacity && weightValue <= capacity)
		{	
			resProfit += profitValue;
			capacity -= weightValue;
		}
		
		else 
		      break;
	}
	
	if(capacity)		
		resProfit += profitValue * (capacity/weightValue);
		
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
