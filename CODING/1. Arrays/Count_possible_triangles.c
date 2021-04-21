/*
Count the number of possible triangles....

Time Complexity :: O(n^2)
Sort the Array :: O(n*logn)

*/

#include<stdio.h>

int CountTraingles(int Arr[],int n)
{
	int count=0;

	for(int i=0; i<n-2; ++i)
	{
		int k=i+2;

		for(int j=i+1; j<n-1; ++j)
		{
			while(k<n && Arr[i]+Arr[j] > Arr[k])
				k++;

			if(k>j)
				count += k-j-1;
		}
	}

	return count;
}

int main()
{
	int Arr[] = {10, 21, 22, 100, 101, 200, 300};
	
	int n = sizeof(Arr)/sizeof(*Arr);

	printf(" No.of Traingles possible = %d ", CountTraingles(Arr,n));
}
