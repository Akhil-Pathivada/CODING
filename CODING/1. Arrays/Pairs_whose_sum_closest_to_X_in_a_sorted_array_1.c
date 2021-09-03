/** 
  * https://www.geeksforgeeks.org/given-sorted-array-number-x-find-pair-array-whose-sum-closest-x/
  *
  * Given a sorted array and a number x, find a pair in array whose sum is closest to x.
  * Examples:
  *
  * Input: arr[] = {10, 22, 28, 29, 30, 40}, x = 54
  * Output: 22 and 30
  *
  * Input: arr[] = {1, 3, 4, 7, 10}, x = 15
  * Output: 4 and 10
  *
  * Time Complexity: O(n ^ 2)
  * Space Complexity: O(1)
  *  */

#include<stdio.h>
#include<limits.h>
#include<stdlib.h>

void printClosest(int arr[], int n, int x) {

    int p1, p2;  // To store indexes of result pair
    int diff = INT_MAX;

    for(int i = 0; i < n; ++i) {

	    for(int j = i + 1; j < n; ++j) {

		    if(abs(arr[i] + arr[j] - x) < diff) {
			
			    p1 = arr[i];
			    p2 = arr[j];
			    diff = abs(arr[i] + arr[j] - x);
		    }
	    }
    } 
    printf("The closest pair is : [%d, %d]", p1, p2);
}


int main() {

    int arr[] =  {10, 22, 28, 29, 30, 40}, x = 54;
    int n = sizeof(arr) / sizeof(*arr);
    
    printClosest(arr, n, x);
    
    return 0;
}
