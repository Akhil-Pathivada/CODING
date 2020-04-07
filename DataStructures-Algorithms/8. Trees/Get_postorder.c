/*Given the PreOrder,InOrder print the PostOrder.....

Time Complexity :: O(n)
Space Complexity :: O(n)+O(n)......(RECURSION + HashTable) */

#include<stdio.h>
#include<stdlib.h>
#define N 7
struct HASH
{
	int index,data;
}*hash_table;

int k=0,t=0;

int H(int val)
{
	int i,key=val%N;
	if(!hash_table[key].data)
		return key;
	for(i=(key+1)%N; hash_table[i].data && i!=key ;i=(i+1)%N);
	return i;
}

void insertHash(int ind,int val)
{
	int key=H(val);
	hash_table[key].index=ind;
	hash_table[key].data=val;
}
int getPosition(int value)
{
	int i,key=value%N;
	if(hash_table[key].data == value)
		return hash_table[key].index;
	for(i=(key+1)%N ; hash_table[i].data!=value && i!=key  ; i=(i+1)%N);
	return hash_table[i].index;
}
void getPostOrder(int *pre,int *post,int start,int end)
{
	if(start > end)
		return;
	
	int temp=pre[t++];
	
	int pos=getPosition(temp);
	
	getPostOrder(pre,post,start,pos-1);

	getPostOrder(pre,post,pos+1,end);
	
	post[k++]=temp;
}
void main()
{
	int pre[N],in[N],post[N];
	hash_table=(struct HASH*)malloc(sizeof(struct HASH)*N);
	printf(" enter PreOrder : ");
	for(int i=0;i<N;i++)
		scanf("%d",&pre[i]);
	printf(" enter InOrder : ");
	for(int i=0;i<N;i++)
		scanf("%d",&in[i]);
		
	for(int i=0;i<N;i++)
		insertHash(i,in[i]);
		
	getPostOrder(pre,post,0,N-1);
	
	printf("\n POST ORDER : ");
	for(int i=0;i<N;i++)
		printf(" %d,",post[i]);
}
