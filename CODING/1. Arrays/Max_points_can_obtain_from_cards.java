/*
There are several cards arranged in a row, and each card has an associated number of points. 
The points are given in the integer array cardPoints.

In one step, you can take one card from the beginning or from the end of the row. You have to take exactly k cards.

Your score is the sum of the points of the cards you have taken.
Given the integer array cardPoints and the integer k, return the maximum score you can obtain.

Example:

Input: cardPoints = [1,2,3,4,5,6,1], k = 3
Output: 12
Explanation: After the first step, your score will always be 1. 
However, choosing the rightmost card first will maximize your total score. The optimal strategy is to take the three cards on the right, giving a final score of 1 + 6 + 5 = 12.

Time Complexity : O(K)
Space Complexity : O(1)
*/

class GFG {

	static int maxScore(int[] cardPoints, int k) {
        
		int leftSum = 0;
		
		for(int i = 0; i < k; ++i) {
		    
		    leftSum += cardPoints[i];
		}
		int max = leftSum;
		int n = cardPoints.length;

		for(int i = 0, rightSum = 0; i < k; ++i) {
		    
		    rightSum += cardPoints[n - 1 - i];
		    leftSum -= cardPoints[k - 1 - i];
		    
		    max = Math.max(max, leftSum + rightSum);
		}
		return max;
	}

	public static void main(String[] args) {

		int[] cardPoints = new int[]{1, 79, 80, 1, 1, 1, 200, 1};
		int k = 3;

		System.out.println("Max score can be obtained = " + maxScore(cardPoints, k));
	}
}
