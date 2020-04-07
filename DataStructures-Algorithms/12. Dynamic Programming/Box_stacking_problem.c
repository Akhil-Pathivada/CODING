/*
Refer to the exact explanation.....

A Box can be rotated and placed on other.
Constraints : length >= width

Time Complexity : O(n^2)
Space Complexity : O(n)
*/

#include<stdio.h>
#include<stdlib.h>

struct Box
{
	int l,w,h;
};

int max( int a, int b)
{
	return a>b ? a : b;
}

int min( int a, int b)
{
	return a<b ? a : b;
}

int compareTo( const void *aptr, const void *bptr)
{
	return ((*(struct Box*)bptr).l * (*(struct Box*)bptr).w ) - 
	       ((*(struct Box*)aptr).l * (*(struct Box*)aptr).w);
}

int maxStackHeight( struct Box arr[], int n)
{
	struct Box rot[3*n];
	
	int index = -1;
	
	for(int i=0; i<n; ++i)
	{
		// original box
		rot[++index].h = arr[i].h;
		rot[index].l = max(arr[i].l ,arr[i].w);
		rot[index].w = min(arr[i].l ,arr[i].w);
		
		// first rotation
		rot[++index].h = arr[i].l;
		rot[index].l = max(arr[i].w ,arr[i].h);
		rot[index].w = min(arr[i].w ,arr[i].h);
		
		// second rotation
		rot[++index].h = arr[i].w;
		rot[index].l = max(arr[i].l ,arr[i].h);
		rot[index].w = min(arr[i].l ,arr[i].h);
	}
	
	n *= 3;
	
	qsort(rot, n, sizeof(rot[0]), compareTo);
	
	// Longest Increasing Subsequence
	int msh[n];
	
	msh[0] = rot[0].h;
	
	for(int i=1; i<n; ++i)
	{
	    	msh[i] = rot[i].h;
	    
		for(int j=0; j<i; ++j)
		{
			if( rot[i].l < rot[j].l &&
			    rot[i].w < rot[j].w &&
			    msh[i] < msh[j]+rot[i].h )
				 	    
				msh[i] = msh[j] + rot[i].h;
		}
	}
	
	int max = msh[0];
	
	for(int i=1; i<n; ++i)
	{
		if(msh[i] > max)
			max = msh[i];
	}
	
	return max;
}

void main()
{	
	struct Box arr[] = { {6, 4, 7}, {2, 1, 3}, {5, 4, 6}, {12, 10, 32} }; 
	
	int n = sizeof(arr)/sizeof(*arr);
	
	printf(" Max. Stack Height = %d ", maxStackHeight(arr,n));
}

