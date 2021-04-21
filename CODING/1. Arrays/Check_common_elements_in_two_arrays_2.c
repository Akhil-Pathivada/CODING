/* 
 * Given two given arrays of equal length, the task is to find if given arrays are equal or not.
 * Two arrays are said to be equal if both of them contain the same set of elements, arrangements (or permutation) of elements may be different though.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 *
 * This approach will work only if each  element exist only once in an array.
 *  */

#include<stdio.h>
#include<stdbool.h>

bool areEqual(int *arr1, int *arr2, int m, int n) { 

	if(m != n) {
		return false;
	}

	int x1 = *arr1;
	int x2 = *arr2;

	for(int i = 1; i < m; ++i) {

		x1 ^= arr1[i];
		x2 ^= arr2[i];
	}
	int all_xor = x1 ^ x2;
	
	if(all_xor == 0) {
		return true;
	}
	return false;
}

int main() {

	int arr1[] = { 3, 5, 2, 5, 2 };
	int arr2[] = { 2, 3, 5, 5, 2 };

	int m = sizeof(arr1) / sizeof(*arr1);
	int n = sizeof(arr2) / sizeof(*arr2);

	printf(areEqual(arr1, arr2, m , n) ? "Yes" : "No");
}
