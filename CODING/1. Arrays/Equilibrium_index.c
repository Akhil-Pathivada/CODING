/*
Find the Equilibrium Index (leftSum == rightSum)
Time Complexity :: O(n)
Space Complexity :: O(1)
*/
#include<stdio.h>
#include<stdlib.h>

int findEquilibrium(int *arr, int size) {

	int sum = 0; // sum of whole array
	int leftSum = 0; 

	for(int i = 0; i < size; ++i) {
		sum += arr[i];
	}

	for(int i = 0; i < size; ++i){

		sum -= arr[i];
		
		if(leftSum == sum){	
			return arr[i];
		}
		leftSum += arr[i];
	}
	return -1;
}
int main(){

	int arr[] = {-7, 1, 5, 2, -4, 3, 0 };
	int size = sizeof(arr) / sizeof(arr[0]);
	
	printf("**EQUILIBRIUM INDEX :: %d **", findEquilibrium(arr, size));
}
