/*
Given a number n, find the smallest number that has same set of digits as n and is greater than n. If n is the greatest possible number with its set of digits, then print “not possible”.

Examples: 
For simplicity of implementation, we have considered input number as a string. 

Input:  n = "218765"
Output: "251678"

Input:  n = "1234"
Output: "1243"

Input: n = "4321"
Output: "Not Possible"

Input: n = "534976"
Output: "536479"

Time Complexity : O(N)
Space Complexity : O(1)
*/

import java.util.*;

class GFG {
	
	private static void swap(char[] arr, int i, int j) {

		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}	

	private static void findNext(char[] arr, int n) {

		int i;
		for(i = n - 1; i > 0; --i) {

			if(arr[i] > arr[i - 1]) {
				break;
			}
		}
		if(i == 0) {

			System.out.println("Not Possible");
			return;
		}

		// find the smallest number which is greater then arr[i-1] from then end
		for(int j = n - 1; j >= i; --j) {

			if(arr[i - 1] < arr[j]) {

				swap(arr, i - 1, j);
				break;
			}
		}
		// Reverse the digits after (i-1) because the digits
    		// after (i-1) are in decreasing order and thus we will
    		// get the smallest element possible from these digits
		for(int left = i, right = n - 1; left < right; ++left, --right) {

			char t = arr[left];
			arr[left] = arr[right];
			arr[right] = t;
		}

		System.out.print("Next number with same set of digits is ");
		for(char ch : arr) {
			System.out.print(ch + ", ");
		}
	}

	public static void main(String[] args) {

		char digits[] = { '5','3','4','9','7','6' };
		int n = digits.length;
		findNext(digits, n);
	}
}
