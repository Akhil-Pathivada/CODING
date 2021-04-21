/** 
  * Given three strings A, B and C. Write a function that checks whether C is an interleaving of A and B.
  * C is said to be interleaving A and B, if it contains all characters of A and B and order of all characters in individual strings is preserved.
  *
  * Input: strings: "XXXXZY", "XXY", "XXZ"
  * Output: XXXXZY is interleaved of XXY and XXZ
  * The string XXXXZY can be made by
  * interleaving XXY and XXZ
  * String:    XXXXZY
  * String 1:    XX Y
  * String 2:  XX  Z
  *
  * Time Complexity: O(m + n)
  * Space Complexity: O(m + n)
  *  */

#include<stdio.h>
#include<stdbool.h>

bool checkInterleaved(char *A, char *B, char *C) {

	// Base Case: If all strings are empty
	if(!(*A || *B || *C)) {
		return true;
	}
        // If C is empty and any of the
        // two strings is not empty
	if(!*C) {
		return false;
	}

	return ((*C == *A) && checkInterleaved(A + 1, B, C + 1)) || 
	       ((*C == *B) && checkInterleaved(A, B + 1, C + 1));
}

int main() {

	printf(checkInterleaved("XXY", "XXZ", "XXZXXXY") ? "Yes" : "No");
	printf(checkInterleaved("XY", "WZ", "WZXY") ? "Yes" : "No");
}
