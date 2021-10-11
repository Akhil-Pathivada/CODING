/*
Given an array of positive integers. All numbers occur even number of times except one number which occurs odd number of times.
Find the number in O(n) time & constant space.
*/

#include<stdio.h>
#include<stdlib.h>

int findOdd(int *arr, int n)
{
	int result = 0;

	for(int i = 0; i < n; ++i){
		
		result = result ^ arr[i]; 
	}
	return result;
}
int main(){

	int arr[] = { 2, 3, 5, 4, 5, 2, 4, 3, 5, 2, 4, 4, 2 }; 
	int size = sizeof(arr) / sizeof(*arr);
	
	printf(" Odd Occurence Number :: %d", findOdd(arr, size));
}
