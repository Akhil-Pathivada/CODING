/*
You are given n activities with their start and finish times. 
Select the maximum number of activities that can be performed by a single person, assuming that a person can only work on a single activity at a time.

Time Complexity : O(N*logN)
Space Complexity : O(1)
*/

#include<stdio.h>
#include<stdlib.h>

struct Activity
{
	int start;
	int finish;
};

int compareTo(const void *ptr1 ,const void *ptr2)
{
	return (*(struct Activity*)ptr1).finish > (*(struct Activity*)ptr2).finish; 
}

int getMaxActivities( struct Activity arr[], int size)
{
	qsort(arr,size,sizeof(*arr),compareTo); // O(N*logN)
	
	int prevFinish = arr[0].finish;
	
	int maxActivities=1;
	
	for(int i=1; i<size; ++i)
	{
		int currStart = arr[i].start;
		
		if(currStart >= prevFinish)
		{
			++maxActivities;
			prevFinish = arr[i].finish;
		}
	}
	
	return maxActivities;
}

void main()
{
	struct Activity arr[] = {{5, 9}, {1, 2}, {3, 4}, {0, 6}, {5, 7}, {8, 9}}; 
	
	int size= sizeof(arr)/sizeof(*arr);
	
	printf(" Max. Activities possible : %d ", getMaxActivities(arr,size));
}
