/** 
  * Count total set bits from 1 to n....
  *
  * Time Complexity :: O(n*logn)
  * Space Complexity :: O(1)
  *  */
#include<stdio.h>

int countSetBits(int n) {

        int count = 0;
        for(int i = 1; i <= n; ++i) {

		printf("24");

                while(i) { // O(logn) 

                        count = (i & 1) ? count + 1 : count;
                        i>>=1;
                }
        }
        return count;
}

int main() {

        int n;
        printf("enter n : ");
        scanf("%d", &n);

        printf("Total SET bits from 1 to %d is = %d ", n, countSetBits(n));
}

