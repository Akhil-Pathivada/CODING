// Count the Characters in the string.....
#include<stdio.h>

int main() {

	int count;

	for(count = 0; getchar()!=EOF; ++count);

	printf("** Total Characters : %d **", count);
}
