/** Write a program to print all the LEADERS in the array. An element is leader if it is greater than all the elements to its right side.
  * And the rightmost element is always a leader. For example int the array {16, 17, 4, 3, 5, 2}, leaders are 17, 5 and 2.
  *
  * Time Complexity : O(n)
  * Space Complexity : O(1)
  *  */

#include<stdio.h>

void printLeaders(int *arr, int n) {
	
	int max_from_right = arr[n-1];

	printf(" %d,", max_from_right);
	
	for(int i = n-2; i >= 0; --i) {

		if(max_from_right <= arr[i]) {
		
			max_from_right = arr[i];
			printf(" %d,", max_from_right);
		}
	
	}
}

int main() {
	
	int arr[] = {16, 17, 4, 3, 5, 2};
	int n = sizeof(arr) / sizeof(*arr);
	printLeaders(arr, n);
	return 0;
}
