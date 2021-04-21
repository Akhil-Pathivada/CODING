/*
Program for Insertion,Deletion,Search in Hash Table (LINEAR PROBING)
Search Time :: O(1)
*/

#include<stdio.h>
#include<stdlib.h>
#define MAX 6

int hash_table[MAX]={0};

int H(int x)
{
	int index, k=x%MAX;

	if(!hash_table[k])
		return k;

	for(index=(k+1)%MAX ; hash_table[index] && index!=k  ; index=(index+1)%MAX);

	return !hash_table[index] ? index :0;
}

void Insert(int value)
{
	int x = H(value);
	hash_table[x] = value;
}

int Search(int value)
{
	int index, k=value%MAX;

	if(!hash_table[k])
		return k;

	for(index=(k+1)%MAX ; hash_table[index]!=value && index!=k  ; index=(index+1)%MAX);

	return hash_table[index]==value;
}
void main()
{
	int ch,val;
	do
	{
		printf("\n\t1.Insert ");
		printf("\n\t2.Search");
		printf("\n Enter U R Choice : ");
		scanf("%d",&ch);
		switch(ch)
		{
			case 1 :
				printf("\nEnter the Elements :: ");
				for(int i=0; i<MAX; ++i)
				{
					scanf("%d",&val);
					Insert(val);
				}
				break;
			case 2:
				printf("\nEnter the element to Search :: ");
				scanf("%d",&val);
				Search(val) ? printf("\n** Element was found **\n") : printf("\n** Element was not found **\n");
				break;	
		}
	}while(ch<4);	
}
