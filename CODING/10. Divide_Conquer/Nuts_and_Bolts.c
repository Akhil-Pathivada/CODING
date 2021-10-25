/*
Given a set of n nuts of different sizes and n bolts of different sizes. 
There is a one-one mapping between nuts and bolts. Match nuts and bolts efficiently.

CONSTRAINT :: Comparison of a nut to another nut or a bolt to another bolt is not alstarted. 
	      It means nut can only be compared with bolt and bolt can only be compared with nut to see which one is bigger/smaller.


Time Complexity : O(n^2)......(Divide & Conquer)
Space Complexity : O(logN)
*/

#include<stdio.h>

void Swap(char *aptr, char *bptr) {

	char temp = *aptr;
	*aptr = *bptr;
	*bptr = temp;
}

int Partition(char arr[], int start, int end, char pivot) {

	int i = start - 1;
	
	for(int j = start; j < end ; ++j) {

		if(arr[j] < pivot) {
			Swap(&arr[++i], &arr[j]);
		}	
		else if(arr[j] == pivot) {
			Swap(&arr[j--], &arr[end]);
		}
	}
	Swap(&arr[++i], &arr[end]);
	return i;
}

void matchNutsBolts(char nuts[], char bolts[], int start, int end) {

	if(start < end) {

		int pivot = Partition(nuts, start, end, bolts[end]);
		
		Partition(bolts, start, end, nuts[pivot]);
		matchNutsBolts(nuts, bolts, start, pivot - 1);
		matchNutsBolts(nuts, bolts, pivot + 1, end);
	}
}

void printArray(char arr[], int size) {

	for(int i = 0; i < size; ++i) {
		printf(" %c ", arr[i]);
	}
	printf("\n");	
}

int main() {

	char nuts[]={'$','@','&','#','!','~'};
	char bolts[]={'#','!','@','$','~','&'};
	
	int size = sizeof(nuts) / sizeof(*nuts);
	
	matchNutsBolts(nuts, bolts, 0, size - 1);
	
	printArray(nuts, size);
	printArray(bolts, size);
}
