/** 
  * https://www.gohired.in/2017/12/28/stickler-thief/
  *
  * Time Complexity: O(n)
  * Space Complexity: O(1)
  *  */


#include<stdio.h>
#include<stdlib.h>

int maxLoot(int *arr, int n) {

	int s1 = arr[0];
	int s2 = 0;
	int res = 0;

	for(int i = 1; i < n; ++i) {
		
		res = s1 > s2 ? s1 : s2;
		s1 = s2 + arr[i];
		s2 = res;
	}
	return s1 > s2 ? s1 : s2;
}

int main() {

    int arr[] = {6, 7, 1, 3, 8, 2, 4};
    int n = sizeof(arr) / sizeof(arr[0]);

    printf("Maximum loot possible = %d ", maxLoot(arr, n));
    return 0;
}

