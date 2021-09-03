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
  * Time Complexity: O(n)
  * Space Complexity: O(1)
  *  */

#include<stdio.h>
#include<limits.h>
#include<stdlib.h>

void printClosest(int arr[], int n, int x) {

    int p1, p2;  // To store indexes of result pair
    int diff = INT_MAX;
    int left = 0, right = n-1;

    while(left < right) {

	    if(abs(arr[left] + arr[right] - x) < diff) {

		    p1 = arr[left];
		    p2 = arr[right];
		    diff = abs(arr[left] + arr[right] - x);
	    }
	    // If this pair has more sum, move to smaller values.
	    if(arr[left] + arr[right] > x) {

		    --right;
	    }
	    else { // Move to larger values

		    ++left;
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
