/*
LRU Cache Implementation....

Time Complexity : O(1)
Space Complexity : O(n)
*/
#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>
#define size 3
#define MAX 100

struct node
{
	int data;
	struct node *prev, *next;
};

struct hash
{
	int page;
	struct node *addr;	
};

void removeFromHash( struct hash *HashTable, int victim)
{
	HashTable[victim].page = 0;
	
	HashTable[victim].addr = NULL;
}

void insertToHash( struct hash *HashTable, int newPage, struct node *page_addr)
{
	HashTable[newPage].page = newPage;
	
	HashTable[newPage].addr = page_addr;
}

void insertCache( struct node **head, struct node **tail, int data, int *cacheIndex)
{
	struct node *nn = (struct node *)malloc(sizeof(struct node));
	
	nn->data = data;
	
	nn->prev = NULL;
	
	nn->next = *head;
	
	if(*head)
		(*head)->prev = nn;
		
	*head = nn;
	
	if(!*tail)
		*tail = *head;
	
	++*cacheIndex;	
}

bool isCacheFree(int rear)
{
	return rear != size ;
}

void makeAsHead( struct node **head, struct node **tail, struct node *currNode, struct node *prevNode)
{
	if(currNode == prevNode)
		return;
	
	if(currNode == *tail)
		*tail = prevNode;
	
	prevNode->next = currNode->next;
	
	if(currNode->next)
		currNode->next->prev = prevNode;
	
	currNode->next = *head;
	
	currNode->prev = NULL;
	
	(*head)->prev = currNode;
	
	*head = currNode;
}

bool isCacheHit(struct hash *HashTable, int page, struct node **curr, struct node **prev)
{
	if(HashTable[page].addr == NULL)
		return false;
	
	*curr = HashTable[page].addr;
	
	*prev = (*curr)->prev;
	
	if((*curr)->prev == NULL)
		*prev = *curr;
		
	return true;	
}

void replacePage( struct node **head, struct node **tail, int newPage)
{
	struct node *temp = *tail;
	
	temp->data = newPage;
	
	*tail = (*tail)->prev;
	
	(*tail)->next = NULL;
	
	temp->prev = NULL;
	
	temp->next = *head;
	
	(*head)->prev = temp;
	
	*head = temp;
}

struct node* replaceLRU( int *ref, int n)
{
	struct node *head, *tail, *curr, *prev;

	head = tail = NULL;
	
	struct hash HashTable[MAX] = {0};
	
	int rear = 0;
	
	for(int i=0; i<n; ++i)
	{
		int newPage = ref[i];
		
		if(isCacheFree(rear))
			insertCache(&head, &tail, newPage, &rear);
		
		else if(isCacheHit(HashTable, newPage, &curr, &prev))
			makeAsHead(&head, &tail, curr, prev);
		
		else
		{	
			removeFromHash(HashTable, tail->data);
			
			replacePage(&head, &tail, newPage);
		}
		
		insertToHash(HashTable, newPage, head);
	}
	
	return head;
}

void main()
{
	struct node *cache;
	
	int ref[] = {1, 2, 3, 4, 1, 2, 5, 1, 2, 3};
	
	int n = sizeof(ref)/sizeof(*ref);
	
	cache = replaceLRU(ref, n);
	
	printf(" Resultant Cache : ");
	
	for( ; cache; cache=cache->next)
			printf(" %d,",cache->data);
}
