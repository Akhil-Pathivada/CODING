/** 
  * https://www.geeksforgeeks.org/given-two-sorted-arrays-number-x-find-pair-whose-sum-closest-x/
  *
  * Given two sorted arrays and a number x, find the pair whose sum is closest to x and the pair has an element from each array.
  * We are given two arrays ar1[0…m-1] and ar2[0..n-1] and a number x, we need to find the pair ar1[i] + ar2[j] such that absolute value of (ar1[i] + ar2[j] – x) is minimum.
  * Example:
  *
  * Input:  ar1[] = {1, 4, 5, 7};
  *         ar2[] = {10, 20, 30, 40};
  *         x = 32
  * Output:  1 and 30
  *
  * Input:  ar1[] = {1, 4, 5, 7};
  *         ar2[] = {10, 20, 30, 40};
  *         x = 50
  * Output:  7 and 40
  *
  * Time Complexity: O(m * n)
  * Space Complexity: O(1)
  *  */

#include<stdio.h>
#include<limits.h>
#include <stdlib.h>

void printClosest(int arr1[], int arr2[], int m, int n, int x) {
	
	int p1, p2, diff = INT_MAX;

	for(int i = 0; i < m; ++i) {

		for(int j = 0; j < n; ++j) {

			if(abs(arr1[i] + arr2[j] - x) < diff) {

				p1 = arr1[i];
				p2 = arr2[j];
				diff = abs(arr1[i] + arr2[j] - x);
			}
		}
	}
	printf("The closest pair is : [%d, %d]", p1, p2);
}

int main() {

	int arr1[] = {1, 4, 5, 7};
	int arr2[] = {10, 20, 30, 40};

	int m = sizeof(arr1) / sizeof(arr1[0]);
	int n = sizeof(arr2) / sizeof(arr2[0]);
	
	int x = 38;
	printClosest(arr1, arr2, m, n, x);

	return 0;
}

