// Count number of set bits in a number.....
// Time Complexity :: O(logn)

#include<stdio.h>

int main() {

	int num, count = 0;

	printf("Enter a number : ");
	scanf("%d", &num);

	while(num) {

		if(num % 2 == 1) {
			++count;
		}
		num /= 2;
	}
	printf("No. of set bits  : %d ", count);
}
