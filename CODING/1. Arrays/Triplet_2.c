/* 
Find the Triplet whose sum is 'X'

Time Complexity : O(n^2)
Space Complexity : O(1)
Assume the Array was Sorted, Otherwise O(n*logn)

*/

#include<stdio.h>
#include<stdlib.h>

void findTriplet(int *arr, int size, int X) {

	printf(" Triplets : ");	
	
	for(int i = 0; i < size; ++i) {

	       int left = i + 1;     
	       int right = size - 1;

		while(left < right) {

			if(arr[i] + arr[left] + arr[right] < X) {
				++left;	
			}	
			else if(arr[i] + arr[left] + arr[right] > X) {
				--right;
			}	
			else {
				printf(" (%d, %d, %d)", arr[i], arr[left], arr[right]);
				++left;
				--right;
			}
		}
	}
}
int main(){

	int arr[] = {1, 4, 6, 8, 10, 45};	
	int n = sizeof(arr)/sizeof(*arr);	
	int X = 22;

	findTriplet(arr, n, X);
}	
