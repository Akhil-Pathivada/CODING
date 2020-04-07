/*
Check whether two arrays are Disjoint or not....

Time Complexity : O(m*n)
Space Complexity : O(1)
*/

#include<stdio.h>
#include<stdbool.h>

bool checkDisjoint(int arr1[],int arr2[],int m,int n)
{
	for(int i=0; i<m; ++i)
	{
		for(int j=0; j<n; ++j)
		{
			if(arr1[i]==arr2[j])
				return true;
		}
	}
	return false;
}

int main()
{
	int arr1[]={1,2,3,4,5};
	int arr2[]={6,7,8,9,10,5,12};

	checkDisjoint(arr1,arr2,5,7) ? printf("TRUE") : printf("FALSE");
}
