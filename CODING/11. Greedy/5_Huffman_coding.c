/*
Program for Huffman Coding......

Time Complexity : O(N*logN)
Space Complexity : O(1)

*/

#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>

struct minHeapNode
{
	char data;
	int freq;
	
	struct minHeapNode *left,*right;
};

struct minHeapNode *newNode()
{
	return (struct minHeapNode*)malloc(sizeof(struct minHeapNode));
}

void Swap ( struct minHeapNode *aptr, struct minHeapNode *bptr)
{
	char data = aptr->data;
	
	int freq = aptr->freq;
	
	struct minHeapNode *left = aptr->left;
	
	struct minHeapNode *right = aptr->right;
	
	aptr->data = bptr->data;
	
	aptr->freq = bptr->freq;
	
	aptr->left = bptr->left;
	
	aptr->right = bptr->right;
	
	bptr->data = data;
	
	bptr->freq = freq;
	
	bptr->left = left;
	
	bptr->right = right;
}

void MinHeapify( struct minHeapNode MinHeap[], int size, int index) 
{
	int smallest = index;

	int left = 2*index + 1;
	int right = 2*index + 2;

	if(left < size &&  MinHeap[left].freq < MinHeap[smallest].freq)
		smallest = left;

	if(right < size &&  MinHeap[right].freq < MinHeap[smallest].freq)
		smallest = right;

	if(smallest != index)
	{
		Swap( &MinHeap[index], &MinHeap[smallest]);
		
		MinHeapify(MinHeap, size, smallest);
	}
}

void insertMinHeap( struct minHeapNode MinHeap[], struct minHeapNode *root, int *size)
{
	Swap(root, &MinHeap[*size]); // moving data	

	for(int i=*size; i>=0 && MinHeap[(i-1)/2].freq > MinHeap[i].freq ; i=(i-1)/2)
		
		Swap( &MinHeap[i], &MinHeap[(i-1)/2]);	
		
	++*size;
}

struct minHeapNode* ExtractMin( struct minHeapNode MinHeap[], int *size)
{	
	struct minHeapNode* min = newNode();
	
	Swap (MinHeap, min); // moving data

	MinHeap[0] = MinHeap[--*size];

	MinHeapify( MinHeap, *size, 0);
	
	return min;
}

void convertToMinHeap( struct minHeapNode MinHeap[], char arr[], int freq[], int size)
{
	for(int i=0; i<size; ++i)
	{
		MinHeap[i].data = arr[i];

		MinHeap[i].freq = freq[i];
		
		MinHeap[i].left = NULL;
		
		MinHeap[i].right = NULL;
	}
	
	for(int i=(size/2)-1 ; i>=0; --i)
		MinHeapify( MinHeap, size, i);
}

struct minHeapNode* buildHuffmanTree( char arr[], int freq[], int size)
{
	struct minHeapNode MinHeap[size];	
	
	convertToMinHeap( MinHeap, arr, freq, size);

	while(size>1)
	{
		struct minHeapNode *root = newNode();
		
		root->left = ExtractMin(MinHeap, &size);
		
		root->right = ExtractMin(MinHeap, &size);
		
		root->freq = root->left->freq + root->right->freq;
		
		insertMinHeap( MinHeap, root, &size);
	}
	
	return ExtractMin( MinHeap, &size);
}

void printArr( int arr[], int n)
{
	for( int i=0; i<n; ++i)
		printf(" %d", arr[i]);

	printf("\n");
}

void printHuffmanCodes( struct minHeapNode *root, int codes[], int index)
{	
	if(!root->left && !root->right)	
	{
		printf(" %c,", root->data);

		printArr(codes, index);

		return;	
	}
	
	if(root->left)
	{
		codes[index] = 0;

		printHuffmanCodes(root->left, codes, index+1);
	}
	
	if(root->right)
	{
		codes[index] = 1;

		printHuffmanCodes(root->right, codes, index+1);
	}	
}

int main()
{
	char arr[] = { 'a', 'b', 'c', 'd', 'e', 'f' }; 
 	int freq[] = { 45, 13, 12, 16, 9, 5 }; 
 	
 	int size = sizeof(arr)/sizeof(*arr);
 	
 	struct minHeapNode *root = buildHuffmanTree(arr,freq,size);
 	
	int codes[size], index = 0;

 	printHuffmanCodes(root, codes, index);
}
