/*
Given two linked lists(can be sorted or unsorted) of size n1 and n2 of distinct elements. Given a value x. The problem is to count all pairs from both lists whose sum is equal to the given value x.
Note: The pair has an element from each linked list.
Examples: 
 

Input : list1 = 3->1->5->7
        list2 = 8->2->5->3
        x = 10
Output : 2
The pairs are:
(5, 5) and (7, 3)

Time Complexity : O(n1 * n2) 
Space Complexity : O(1)
*/

import java.util.*;

class GFG {

	private static int countPairs(LinkedList<Integer> list1, LinkedList<Integer> list2, int x) {

		int count = 0;

		for(Integer e1 : list1) {

			for(Integer e2 : list2) {

				if(e1 + e2 == x) {
					++count;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		
		Integer arr1[] = {3, 1, 5, 7};
		Integer arr2[] = {8, 2, 5, 3};

		LinkedList<Integer> list1 = new LinkedList<>(Arrays.asList(arr1));
		LinkedList<Integer> list2 = new LinkedList<>(Arrays.asList(arr2));

		int x = 10;

		System.out.println("Count = " + countPairs(list1, list2, x));
	}
}