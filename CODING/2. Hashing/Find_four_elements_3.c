/*
Find four elements i,j,k,l in an array such that i+j = k+l

(Using HASHING)

Time Complexity : O(n^2)
Space Complexity : O(n^2)
*/

#include<stdio.h>
#include<stdlib.h>
#include<string.h>

struct LL
{
	int x,y;
	struct LL *next;
};

struct HASH
{
	int sum,count;
	struct LL *link;
};

struct LL *newListNode( int d1, int d2)
{
	struct LL *nn = (struct LL*)malloc(sizeof(struct LL));
	
	nn->x = d1;
	
	nn->y = d2;
	
	nn->next = NULL;
	
	return nn;
}

int addHash( struct HASH HashTable[], int sum, int N) // O(1)
{
	int i, pos = sum % N;
	
	if(HashTable[pos].count == 0)
	{
		HashTable[pos].sum = sum;
		
		return pos;
	}
	
	for(i=(pos+1)%N; (HashTable[i].count ==0) && i != pos; i=(i+1)%N);
	
	HashTable[i].sum = sum;
	
	return i;
}

int searchHash( struct HASH HashTable[], int N, int target)
{
	int i, pos = target % N;
	
	if(HashTable[pos].sum == target)
		return pos;
	
	for(i=(pos+1)%N; HashTable[i].sum != target && i != pos; i=(i+1)%N);
	
	return (i!=pos) ? i : -1;
}

void addListNode( struct HASH HashTable[], int index, struct LL *listNode)
{
	struct LL *temp = HashTable[index].link;
	
	HashTable[index].link = listNode;
	
	listNode->next = temp;
	
	HashTable[index].count ++;
}

void printElements( struct HASH HashTable[], int N)
{
	for(int i=0; i<N ; ++i)
	{
			
		if(HashTable[i].count > 1)
		{
			struct LL *head = HashTable[i].link;
		
			for( ; head; head = head->next)
				printf("%d,%d,", head->x,head->y);
				
			printf("\n");
		}
	}
}

void getElements( int *arr, int n)
{
	int N = n*n;
	
	struct HASH HashTable[N];
	
	memset(HashTable,0,N*sizeof(struct HASH));	
		
	for(int i=0; i<n; ++i)
	{
		for(int j=i+1; j<n; ++j)
		{
			int index;
			
			int sum = arr[i] + arr[j];
			
			struct LL *listNode = newListNode(arr[i],arr[j]);
			
			if((index = searchHash(HashTable,N,sum)) != -1)
				addListNode(HashTable,index,listNode);
			else
			{
				index = addHash(HashTable,sum,N);
				
				addListNode(HashTable,index,listNode);
			}	
		}
	}
	
	printElements(HashTable,N);
}

void main()
{
	int arr[] = {6,2,3,4,5};
	
	int size = sizeof(arr)/sizeof(*arr);
	
	getElements(arr,size);
}
