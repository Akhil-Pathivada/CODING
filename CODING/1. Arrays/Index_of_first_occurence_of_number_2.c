/** Given a sorted array consisting 0’s and 1’s. The problem is to find the index of first ‘1’ in the sorted array.
  * It could be possible that the array consists of only 0’s or only 1’s. If 1’s are not present in the array then print “-1”.
  *
  * Time Complexity : O(logN)
  * Space Complexity : O(1)
  *  */

#include<stdio.h>

int indexOfFirstOne(int *arr, int low, int high) {
	
	while(low <= high) {
		
		int mid = (low + high) / 2;
		
		if(arr[mid] == 1 && (mid == 0 || arr[mid - 1] == 0))
			return mid;
		
		else if(arr[mid] == 1)
			high = mid - 1;
		else
			low = mid + 1;
	}
	return -1;
}

int main() {

	int arr[] = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1};
	int n = sizeof(arr) / sizeof(*arr);
	printf("Index of first occurence of 1 is = %d ", indexOfFirstOne(arr, 0, n-1));
	return 0;
}

