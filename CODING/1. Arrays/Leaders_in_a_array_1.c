/** Write a program to print all the LEADERS in the array. An element is leader if it is greater than all the elements to its right side.
  * And the rightmost element is always a leader. For example int the array {16, 17, 4, 3, 5, 2}, leaders are 17, 5 and 2.
  *
  * Time Complexity : O(n^2)
  * Space Complexity : O(1)
  *  */

#include<stdio.h>

void printLeaders(int *arr, int n) {
	
	for(int i = 0; i < n; ++i) {
		
		int j;
		for(j = i+1; j < n; ++j){

			if(arr[j] > arr[i]) {
				break;
			}
		}
		if(j == n) {

			printf(" %d,", arr[i]);
		}
	}
}

int main() {
	
	int arr[] = {16, 17, 4, 3, 5, 2};
	int n = sizeof(arr) / sizeof(*arr);

	printLeaders(arr, n);
	return 0;
}
