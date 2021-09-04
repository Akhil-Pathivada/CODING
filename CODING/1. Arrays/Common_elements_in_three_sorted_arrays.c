/*
Find common elements in three sorted arrays

Time Complexity : O(n1 + n1 + n3)
Space Complexity : O(1)
*/

#include<stdio.h>

void findCommonElements(int *a, int *b, int *c, int n1, int n2, int n3) {

	int i = 0, j = 0, k = 0;

	printf(" Common Elements : ");

	while(i < n1 && j < n2 && k < n3) {

		if(a[i] == b[j] && b[j] == c[k]) {

			printf(" %d,", a[i]);

			++i, ++j, ++k;
		}

		else if(a[i] < b[j]) {
			++i;
		}
		else if(b[j] < c[k]) {
			++j;
		}
		else {
			++k;
		}
	}
}

int main() {

	int n1, n2, n3;	
	
	int arr1[] = {1, 5, 10, 20, 40, 80};

	int arr2[] = {6, 7, 20, 80, 100};

	int arr3[] = {3, 4, 15, 20, 30, 70, 80, 120};

	n1 = sizeof(arr1) / sizeof(int);

	n2 = sizeof(arr2) / sizeof(int);

	n3 = sizeof(arr3) / sizeof(int);

	findCommonElements(arr1, arr2, arr3, n1, n2, n3);
}

