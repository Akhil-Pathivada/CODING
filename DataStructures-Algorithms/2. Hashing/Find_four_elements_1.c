/*
Find four elements i,j,k,l in an array such that i+j = k+l

(Naive Approach)

Time Complexity : O(n^4)
Space Complexity : O(1)
*/

#include<stdio.h>

void printElements( int *arr, int n)
{
	for(int i=0; i<n; ++i)
	{
		for(int j=i+1; j<n; ++j)
		{
			for(int k=j+1; k<n; ++k)
			{
				for(int l=k+1; l<n; ++l)
				{
					if(arr[i]+arr[j] == arr[k]+arr[l])
						printf(" (%d,%d,%d,%d)",arr[i],arr[j],arr[k],arr[l]);
						 
					else if(arr[i]+arr[k] == arr[j]+arr[l])
						printf(" (%d,%d,%d,%d)",arr[i],arr[k],arr[j],arr[l]);
						
					else if(arr[i]+arr[l] == arr[j]+arr[k])
						printf(" (%d,%d,%d,%d)",arr[i],arr[l],arr[j],arr[k]);		
				}
			}
		}
	}
}

void main()
{
	int arr[] = {6,2,3,4,5};
	
	int size = sizeof(arr)/sizeof(*arr);
	
	printElements(arr,size);
}
