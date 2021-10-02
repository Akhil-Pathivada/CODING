/*
Given n non-negative integers a_1, a_2, ..., a_n               where each represents a point at coordinate (i, a_i)               . ‘ n ‘ vertical lines are drawn such that the two endpoints of line i is at (i, a_i)               and (i, 0)               . 
Find two lines, which together with x-axis forms a container, such that the container contains the most water.
The program should return an integer which corresponds to the maximum area of water that can be contained (maximum area instead of maximum volume sounds weird but this is the 2D plane we are working with for simplicity).

Note: You may not slant the container. 

Examples :  

Input: array = [1, 5, 4, 3]
Output: 6
Explanation : 
5 and 3 are distance 2 apart. 
So the size of the base = 2. 
Height of container = min(5, 3) = 3. 
So total area = 3 * 2 = 6

Input: array = [3, 1, 2, 4, 5]
Output: 12
Explanation : 
5 and 3 are distance 4 apart. 
So the size of the base = 4. 
Height of container = min(5, 3) = 3. 
So total area = 4 * 3 = 12

Time Complexity : O(N)
Space Complexity : O(1)

*/

class GFG {

	static int maxArea(int arr[]) {

		int left = 0;
		int right = arr.length - 1;
		int maxArea = 0;

		while(left < right) {

			maxArea = Math.max(maxArea, Math.min(arr[left], arr[right]) * (right - left));

			if(arr[left] < arr[right]) {
				++left;
			}
			else {
				--right;
			}
		}
		return maxArea;
	}

	public static void main(String[] args) {

		int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7};
		System.out.println("Max. water can contains = " + maxArea(height));
	}
}