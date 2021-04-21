// Find the next sparse number of a given number
// Space Complexity :: O(n*logn)
#include<stdio.h>
int isSparse(int n)
{
	return !(n&(n<<1)); //O(logn)
}
void main()
{
	int num;
	printf(" enter number : ");
	scanf("%d",&num);
	while(1) // O(n)
	{
		if(isSparse(num))
			break;
		num++;
	}
	printf(" next SPARSE number : %d \n",num);
}

 
