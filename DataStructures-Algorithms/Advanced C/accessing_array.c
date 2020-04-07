
#include<stdio.h>

int main()
{
	int arr[] = {11,12,13};
	
	printf(" arr[2]= %d \n", arr[2]);
	
	printf(" *(arr+2)= %d \n", *(arr+2));
	
	printf(" 2[arr]= %d \n", 2[arr]); // same as *(2+arr)
}
